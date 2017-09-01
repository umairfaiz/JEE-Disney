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
import model.Bulletinboardcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
public class bulletinServlet extends HttpServlet {

    @EJB
    private Bulletinboardcb006302FacadeLocal bulletinboardcb006302Facade;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("event_id");
        String eventdeletedfail="Something went wrong try again!";
        String eventdeleted="Event deleted successfully";
        RequestDispatcher rd;
        
        try{
            bulletinboardcb006302Facade.removeEvent(id);
            request.setAttribute("eventdeleted", eventdeleted);
            rd = request.getRequestDispatcher("bulletinBoard.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Transaction was successful!");
        }catch(Exception ex){
            request.setAttribute("eventdeletedfail", eventdeletedfail);
            rd = request.getRequestDispatcher("bulletinBoard.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Try again");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("e_id");
        String time = request.getParameter("e_time");
        String name = request.getParameter("e_name"); 
        String eventadded ="Event added successfully!";
        String eventaddedfail="Something went wrong try again!";
        
        
        RequestDispatcher rd;
        
        try{
            bulletinboardcb006302Facade.addEvent(id, time, name);
            request.setAttribute("eventadded", eventadded);
            rd = request.getRequestDispatcher("bulletinBoard.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Transaction was successful!");
        }catch(Exception ex){
            request.setAttribute("eventaddedfail", eventaddedfail);
            rd = request.getRequestDispatcher("bulletinBoard.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Try again");
        }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
