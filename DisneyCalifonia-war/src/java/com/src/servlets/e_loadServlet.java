/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.servlets;

import com.services.CalWebService_Service;
import java.io.IOException;
import static java.lang.System.out;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.Elockercb006302FacadeLocal;
import model.Wristbandcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
public class e_loadServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/calWebService/calWebService?wsdl")
    private CalWebService_Service service;


    @EJB
    private Wristbandcb006302FacadeLocal wristbandcb006302Facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String wrist_id= request.getParameter("wrsitid");
        String message1="Reload successful!";
        String message2="Reload Failed. Try again!";
        String message3="Enter only numbers!";
        RequestDispatcher rd;
        String wrist_id= request.getSession().getAttribute("user").toString();
        try {
            int wrist_credit = Integer.parseInt(request.getParameter("wrist_amount"));
            if (request.getSession().getAttribute("user").equals(wrist_id)) {
                int a = 0;
                request.setAttribute("message1", message1);
                int sum = add(a, wrist_credit);
                wristbandcb006302Facade.updateCredit(wrist_id, sum);
                rd = request.getRequestDispatcher("index.jsp?loginstate=1");
                rd.forward(request, response);
                out.println("Transaction was successful!");
            } else {
                request.setAttribute("message2", message2);
                rd = request.getRequestDispatcher("eload.jsp?loginstate=1");
                rd.forward(request, response);
                out.println("Try again");
            }
        }
        catch(NumberFormatException e){
            request.setAttribute("message3", message3);
            rd = request.getRequestDispatcher("eload.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Try again");
        }
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private int add(int num1, int num2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.services.CalWebService port = service.getCalWebServicePort();
        return port.add(num1, num2);
    }

}
