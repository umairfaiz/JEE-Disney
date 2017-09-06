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
import model.Ticketcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
public class adminsalesServlet extends HttpServlet {

    @EJB
    private Ticketcb006302FacadeLocal ticketcb006302Facade;
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String date = request.getParameter("checkDate");
        String salesfail="Incorrect date! Check and try again!";
         RequestDispatcher rd;
         Number totsales=ticketcb006302Facade.totalSales();
        try{
            Number sales=ticketcb006302Facade.selectedSales(date);
            request.setAttribute("sales", sales);
            request.setAttribute("totsales", totsales);
            rd = request.getRequestDispatcher("ticketSales.jsp?salesstate=1");
             rd.forward(request, response);
             out.println("Transaction successful");
        }catch(Exception ex){
            request.setAttribute("salesfail", salesfail);
            rd = request.getRequestDispatcher("ticketSales.jsp");
             rd.forward(request, response);
             out.println("Transaction unsuccessful");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
