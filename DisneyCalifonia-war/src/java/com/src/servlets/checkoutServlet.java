/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.servlets;

import com.subservice.SubcalcWebService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.UserdetailsFacadeLocal;
import model.Wristbandcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
public class checkoutServlet extends HttpServlet {

    @EJB
    private UserdetailsFacadeLocal userdetailsFacade;

    @WebServiceRef(wsdlLocation = "http://localhost:8080/subcalcWebService/subcalcWebService?wsdl")
    private SubcalcWebService_Service service;

    @EJB
    private Wristbandcb006302FacadeLocal wristbandcb006302Facade;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String wristid=request.getSession().getAttribute("user").toString();
        
        RequestDispatcher rd;
        
        try{
            int reloaded_amount=wristbandcb006302Facade.returnCredit(wristid);
            int expenditure=wristbandcb006302Facade.returnExpense(wristid);
            int balance=sub(reloaded_amount, expenditure);
            String balances="Please collect your balance : $."+balance;
            request.setAttribute("balances", balances);

            out.println("Balance = "+balance);
            wristbandcb006302Facade.removeUser(wristid);
            userdetailsFacade.removeusername(wristid);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            out.println("Transaction was successful!");
//            request.setAttribute("reload" , reloaded_amount);
//            request.setAttribute("expenses", expenditure);
            
        }catch(Exception ex){
             rd = request.getRequestDispatcher("checkout.jsp?loginstate=1");
             rd.forward(request, response);
             out.println("User wasnt deleted");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private int sub(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.subservice.SubcalcWebService port = service.getSubcalcWebServicePort();
        return port.sub(num1, num2);
    }

}
