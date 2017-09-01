/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Wristbandcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
public class foodServlet extends HttpServlet {

    @EJB
    private Wristbandcb006302FacadeLocal wristbandcb006302Facade;


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String wrist_id= request.getSession().getAttribute("user").toString();
       String type= request.getParameter("foodItem");
       String foodsucess="Food item was purchased successfully!";
       String foodfail="Something went wrong try again!";
       int reloaded_amount=wristbandcb006302Facade.returnCredit(wrist_id);
       int expenditure=wristbandcb006302Facade.returnExpense(wrist_id);
       String lowcredit="Not enough credit to buy this item";
       int charges=0;
       
        RequestDispatcher rd;
        
       if("Submarine".equals(type)){
           charges=4;
         
       }else if("bucket".equals(type)){
           charges=5;
       }
       else{
           charges=2;
       }
       
        try{
            if(reloaded_amount>expenditure){
             wristbandcb006302Facade.updateExpense(wrist_id, charges);
             request.setAttribute("foodsucess", foodsucess);
             rd = request.getRequestDispatcher("food.jsp?loginstate=1");
             rd.forward(request, response);
             out.println("Transaction successful");
            
            }
            else{
             request.setAttribute("lowcredit", lowcredit);
             rd = request.getRequestDispatcher("eload.jsp?loginstate=1");
             rd.forward(request, response);
             out.println("Transaction successful");
            }
             
        }
        catch(Exception ex){
            request.setAttribute("foodfail", foodfail);
             rd = request.getRequestDispatcher("food.jsp?loginstate=1");
             rd.forward(request, response);
             out.println("OOppppppppppsssssssssss");
        }
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
