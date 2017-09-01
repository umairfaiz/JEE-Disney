/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Elockercb006302FacadeLocal;
import model.Wristbandcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
public class lockerServlet extends HttpServlet {

   
    @EJB
    private Wristbandcb006302FacadeLocal wristbandcb006302Facade;

    @EJB
    private Elockercb006302FacadeLocal elockercb006302Facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //String wrist_id= request.getParameter("wrsitid");
       String wrist_id= request.getSession().getAttribute("user").toString();
       String elocker_id= request.getParameter("elockerid");
       int reuse_charges=reuseLocker();
       String lockererror="There is no such locker. Try again with a valid ID!";
       String reusesuccess="Locker was reserved again successfully!";
       
       RequestDispatcher rd;
       
       

        if(elockercb006302Facade.isLockerExist(wrist_id, elocker_id)){
             wristbandcb006302Facade.updateExpense(wrist_id, reuse_charges);
             request.setAttribute("reusesuccess", reusesuccess);
             rd = request.getRequestDispatcher("index.jsp?loginstate=1");
             rd.forward(request, response);
             out.println("Transaction successful");
        }
        else{
            request.setAttribute("lockererror", lockererror);
             rd = request.getRequestDispatcher("elocker.jsp?loginstate=1");
             rd.forward(request, response);
             out.println("No such locker in DB");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String locker_id=String.valueOf(randomID());
        //String wrist_id= request.getParameter("wristid");
        String wrist_id= request.getSession().getAttribute("user").toString();
        String locker_type= request.getParameter("drpLockerType");
        int locker_charges=lockerCost(locker_type);
        String elockersuccess="E-locker was purchased successfully!";
        String elockerfail="Something went wrong try again!";
        String lockID= " Locker ID : "+locker_id;
        int reloaded_amount=wristbandcb006302Facade.returnCredit(wrist_id);
       int expenditure=wristbandcb006302Facade.returnExpense(wrist_id);
        String lowcredit="Not enough credit to buy this item";
        
        RequestDispatcher rd;
        wristbandcb006302Facade.updateExpense(wrist_id, locker_charges);
        try{
            if(reloaded_amount>expenditure){
                elockercb006302Facade.addElocker(locker_id, wrist_id, locker_type, locker_charges);
                request.setAttribute("elockersuccess", elockersuccess);
                request.setAttribute("lockID", lockID);
                rd = request.getRequestDispatcher("index.jsp?loginstate=1");
                rd.forward(request, response);
                out.println("Transaction ticket was successful!");
            }
            else{
                request.setAttribute("lowcredit", lowcredit);
                rd = request.getRequestDispatcher("eload.jsp?loginstate=1");
                rd.forward(request, response);
                out.println("Transaction successful");
            }
        }catch(Exception ex){
            request.setAttribute("elockerfail", elockerfail);
            rd = request.getRequestDispatcher("elocker.jsp?loginstate=1");
            rd.forward(request, response);
            out.println(ex + ". Try again");
        
        }
        
    }
    
    public int lockerCost(String type){
        int charges=0;
        if("Individual".equals(type)){
            charges=5;
        }else{
            charges=10;
        }
        return charges;
    }
    
    public int reuseLocker(){
        return 5;
    }
    
    public int randomID(){
        Random r = new Random();
        int Low = 100;
        int High = 1000;  
        int Result = r.nextInt(High-Low) + Low;
        return Result;
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
