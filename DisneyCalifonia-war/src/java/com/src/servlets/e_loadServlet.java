/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.servlets;

import java.io.IOException;
import static java.lang.System.out;
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
public class e_loadServlet extends HttpServlet {


    @EJB
    private Wristbandcb006302FacadeLocal wristbandcb006302Facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String wrist_id= request.getParameter("wrsitid");
        int wrist_credit= Integer.parseInt(request.getParameter("wrist_amount"));
        
        RequestDispatcher rd;
        
        try{
            wristbandcb006302Facade.updateCredit(wrist_id, wrist_credit);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            out.println("Transaction was successful!");
        }catch(Exception ex){
            rd = request.getRequestDispatcher("eload.jsp");
            rd.forward(request, response);
            out.println(ex + "Try again");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
