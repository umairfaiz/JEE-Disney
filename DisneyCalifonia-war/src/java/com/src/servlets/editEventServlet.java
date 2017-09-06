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
public class editEventServlet extends HttpServlet {

    @EJB
    private Bulletinboardcb006302FacadeLocal bulletinboardcb006302Facade;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("event_id");
        String name = request.getParameter("event_name");
        String time = request.getParameter("event_time");
        String eventeditsuccess="Event edited successfully";
        String eventeditfail="Something went wrong try again!";
        RequestDispatcher rd;
        
        
        try{
            bulletinboardcb006302Facade.editEvent(id, name, time);
            request.setAttribute("eventeditsuccess", eventeditsuccess);
            rd = request.getRequestDispatcher("editbulletinBoard.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Transaction was successful!");
        }catch(Exception ex){
            request.setAttribute("eventeditfail", eventeditfail);
            rd = request.getRequestDispatcher("editbulletinBoard.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Try again");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
