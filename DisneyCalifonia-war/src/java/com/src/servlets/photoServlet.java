/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Random;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Photocb006302FacadeLocal;
import model.Wristbandcb006302FacadeLocal;

/**
 *
 * @author Umair
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"AdminRole"}))
public class photoServlet extends HttpServlet {

    @EJB
    private Wristbandcb006302FacadeLocal wristbandcb006302Facade;

    @EJB
    private Photocb006302FacadeLocal photocb006302Facade;

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String wristid = request.getParameter("wristid");
        String photoid=request.getParameter("photoid");
        String image = request.getParameter("photoimg");
        
         RequestDispatcher rd;
         browseImages(image);
        try{
            photocb006302Facade.uploadPhoto(photoid, wristid);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            out.println("Transaction was successful!");
        }catch(Exception ex){
            rd = request.getRequestDispatcher("photos.jsp");
            rd.forward(request, response);
            out.println(ex + "Try again");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String wrist_id= request.getSession().getAttribute("user").toString();
        //String photo_id= request.getParameter("photoid");
        String photo_id=String.valueOf(randomID());
        String type= request.getParameter("rbnSize");
        String price = String.valueOf(photo_price(type));
         RequestDispatcher rd;
         wristbandcb006302Facade.updateExpense(wrist_id, Integer.parseInt(price));
        try{
            photocb006302Facade.addPhoto(photo_id, wrist_id, type, price);
            rd = request.getRequestDispatcher("viewPhotos.jsp?loginstate=1");
            rd.forward(request, response);
            out.println("Transaction was successful!");
        }catch(Exception ex){
            rd = request.getRequestDispatcher("viewPhotos.jsp?loginstate=1");
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
    public int photo_price(String type){
        int charges=0;
        if("Normal".equals(type)){
            charges=5;
        }else{
            charges=10;
        }
        return charges;
        
    }
    public boolean browseImages(String id) {
        boolean flag = false;
        BufferedImage img = null;
        File file = null;

        try {
            file = new File("C:\\Users\\Admin\\Desktop\\Images\\" + id);
            img = ImageIO.read(file);

        } catch (Exception e) {
            
        }
        try {
            file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\DisneyCalifonia\\DisneyCalifonia-war\\web\\img\\park");
            ImageIO.write(img, "jpg", file);
        } catch (Exception e) {
        }
        return flag;
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
