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
import javax.servlet.http.HttpSession;
import model.UserdetailsFacadeLocal;

/**
 *
 * @author Umair
 */
public class accountServlet extends HttpServlet {

    @EJB
    private UserdetailsFacadeLocal userdetailsFacade;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String userID= String.valueOf(randomID());
        String wristid= request.getParameter("wristid");
        String userPassword= request.getParameter("password");
        
        RequestDispatcher rd;
        
        //creating session
        HttpSession loginsession = request.getSession();
        loginsession.setAttribute("user", wristid);
        
        if(userdetailsFacade.isUserExist(wristid, userPassword)){
//            rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
            rd = request.getRequestDispatcher("eload.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Transaction ticket was successful!");
            
        }
        else{
            rd = request.getRequestDispatcher("account.jsp");
            rd.forward(request, response);
            out.println("Try again");
        }
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
