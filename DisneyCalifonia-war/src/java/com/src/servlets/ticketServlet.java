/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ticketcb006302FacadeLocal;
import model.Wristbandcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
public class ticketServlet extends HttpServlet {

    @EJB
    private Wristbandcb006302FacadeLocal wristbandcb006302Facade;

    @EJB
    private Ticketcb006302FacadeLocal ticketcb006302Facade;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate = LocalDate.now();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String wristid = request.getParameter("wristID");
        String wristid =request.getSession().getAttribute("user").toString();
        String ticketid=String.valueOf(randomID());
        String gameType=request.getParameter("gameType"); //ticket_Type
        String ticketQty=request.getParameter("quantity"); //ticket_Type2
        int ticketPrice=Integer.parseInt(request.getParameter("gamePrice"));
        String ticket_date = dtf.format(localDate);
        int expense = Integer.parseInt(ticketQty)*  ticketPrice;
        
        RequestDispatcher rd;
        wristbandcb006302Facade.updateExpense(wristid, expense);
        try{
            ticketcb006302Facade.addExtremeparkTicket(ticketid,wristid,gameType,ticketQty,ticket_date, ticketPrice);
            rd = request.getRequestDispatcher("extremepark_tickets.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Transaction ticket was successful!");
        }
        catch(Exception ex){
            rd = request.getRequestDispatcher("ticket.jsp?loginstate=1");
            rd.forward(request, response);
            out.println(ex + "Try again");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type1 =" ";
        String type2 =" ";
        
        type1= request.getParameter("adult_ticket").toString();
        type2= request.getParameter("child_ticket").toString();
        String ticketid=String.valueOf(randomID());
        String ticket_date = dtf.format(localDate);
        String wristID = String.valueOf(randomID());
        int ticket_price = (Integer.parseInt(type1)*10)+(Integer.parseInt(type2)*6);
        int credit = Integer.parseInt(request.getParameter("credit"));
        int expense = 0;
        
        RequestDispatcher rd;
        
        try{
            ticketcb006302Facade.addticket(ticketid,wristID,type1,type2,ticket_date, ticket_price, wristID, credit, expense);
            rd = request.getRequestDispatcher("account.jsp");
            rd.forward(request, response);
            out.println("Transaction ticket was successful!");
        }
        catch(Exception ex){
            rd = request.getRequestDispatcher("ticket.jsp");
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
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
