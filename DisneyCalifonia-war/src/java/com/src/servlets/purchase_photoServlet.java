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
import model.Photocb006302FacadeLocal;
import model.Wristbandcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
public class purchase_photoServlet extends HttpServlet {

    @EJB
    private Wristbandcb006302FacadeLocal wristbandcb006302Facade;

    @EJB
    private Photocb006302FacadeLocal photocb006302Facade;

    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String wrist_id= request.getSession().getAttribute("user").toString();
        //String photo_id= request.getParameter("photoid");
        String photo_id=String.valueOf(randomID());
        String type= request.getParameter("rbnSize");
        String price = String.valueOf(photo_price(type));
        String photosucess="Selected photo was purchased successfully!";
        String photofail="Something went wrong try again!";
        int reloaded_amount=wristbandcb006302Facade.returnCredit(wrist_id);
       int expenditure=wristbandcb006302Facade.returnExpense(wrist_id);
        String lowcredit="Not enough credit to buy this item";
        
         RequestDispatcher rd;
         wristbandcb006302Facade.updateExpense(wrist_id, Integer.parseInt(price));
        try{
             if(reloaded_amount>expenditure){
                  photocb006302Facade.addPhoto(photo_id, wrist_id, type, price);
                    request.setAttribute("photosucess", photosucess);
                    rd = request.getRequestDispatcher("viewPhotos.jsp?loginstate=1");
                    rd.forward(request, response);
                    out.println("Transaction was successful!");
             
             }else{
                request.setAttribute("lowcredit", lowcredit);
                rd = request.getRequestDispatcher("eload.jsp?loginstate=1");
                rd.forward(request, response);
                out.println("Transaction successful");
            }
           
        }catch(Exception ex){
            request.setAttribute("photofail", photofail);
            rd = request.getRequestDispatcher("viewPhotos.jsp?loginstate=1");
            rd.forward(request, response);
            out.println(ex + "Try again");
        }
    }

   public int randomID(){
        Random r = new Random();
        int Low = 100;
        int High = 1000;  
        int Result = r.nextInt(High-Low) + Low;
        return Result;
    }
    public int photo_price(String type){
        int charges=0;
        if("Normal".equals(type)){
            charges=5;
        }else{
            charges=10;
        }
        return charges;
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
