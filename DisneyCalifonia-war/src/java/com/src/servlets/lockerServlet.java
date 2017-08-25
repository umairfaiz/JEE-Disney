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
         
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String locker_id=String.valueOf(randomID());
        String wrist_id= request.getParameter("wristid");
        String locker_type= request.getParameter("drpLockerType");
        int locker_charges=lockerCost(locker_type);
        
        RequestDispatcher rd;
        wristbandcb006302Facade.updateExpense(wrist_id, locker_charges);
        try{
            elockercb006302Facade.addElocker(locker_id, wrist_id, locker_type, locker_charges);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            out.println("Transaction ticket was successful!");
        }catch(Exception ex){
            rd = request.getRequestDispatcher("elocker.jsp");
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
