/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.servlets;

import com.subservice.SubcalcWebService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.Wristbandcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
public class CheckBalanceServlet extends HttpServlet {

    @EJB
    private Wristbandcb006302FacadeLocal wristbandcb006302Facade;

    @WebServiceRef(wsdlLocation = "http://localhost:8080/subcalcWebService/subcalcWebService?wsdl")
    private SubcalcWebService_Service service;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String wristid=request.getSession().getAttribute("user").toString();
        balanceState(wristid);
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
    
    public boolean balanceState(String wristid){
            int reloaded_amount=wristbandcb006302Facade.returnCredit(wristid);
            int expenditure=wristbandcb006302Facade.returnExpense(wristid);
            int balance=sub(reloaded_amount, expenditure);
           
            
            if(balance<0){
                return true;
            }
            else{
                return false;
            }
    }
}
