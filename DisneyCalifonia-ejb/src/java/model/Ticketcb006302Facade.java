/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Ticketcb006302;
import entities.Wristbandcb006302;
import entities.Userdetails;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Umair
 */
@Stateless
public class Ticketcb006302Facade extends AbstractFacade<Ticketcb006302> implements Ticketcb006302FacadeLocal {

    @PersistenceContext(unitName = "DisneyCalifonia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Ticketcb006302Facade() {
        super(Ticketcb006302.class);
    }

    @Override
    public void addticket(String ticketid, String wristID, String type1, String type2, String ticket_date, int ticket_price,String wristid, int credit, int expense) {
        Ticketcb006302 ticket = new Ticketcb006302();
        Wristbandcb006302 wristband = new Wristbandcb006302();
        Userdetails userdetails = new Userdetails();
        
        wristband.setWristId(wristid);
        wristband.setCreditLimit(credit);
        wristband.setExpence(expense);
        em.persist(wristband);
        
        ticket.setTicketId(ticketid);
        //ticket.setWristId(new Wristbandcb006302(wristID));
        ticket.setWristId(new Wristbandcb006302(wristband.getWristId()));
        ticket.setTicketType(type1);
        ticket.setTicketType2(type2);
        ticket.setTicketDate(ticket_date);
        ticket.setTicketPrice(ticket_price);
        //em.getTransaction().begin();
        em.persist(ticket);
        //em.getTransaction().commit();
  
    }

//    @Override
//    public void addWristband(String wristid, int credit, int expense) {
//        
//        Wristbandcb006302 wristband = new Wristbandcb006302();
//        wristband.setWristId(wristid);
//        wristband.setCreditLimit(credit);
//        wristband.setExpence(expense);
//        em.persist(wristband);
//        
//    }

    @Override
    public void addExtremeparkTicket(String ticketid, String wristID, String type1, String type2, String ticket_date, int ticket_price) {
        Ticketcb006302 ticket = new Ticketcb006302();
        Wristbandcb006302 wristband = new Wristbandcb006302();

        ticket.setTicketId(ticketid);
        //ticket.setWristId(new Wristbandcb006302(wristband.getWristId()));
        ticket.setWristId(new Wristbandcb006302(wristID));
        ticket.setTicketType(type1);
        ticket.setTicketType2(type2);
        ticket.setTicketDate(ticket_date);
        ticket.setTicketPrice(ticket_price);
        //em.getTransaction().begin();
        em.persist(ticket);
    }

    @Override
    public Number selectedSales(String date) {
        Query query=em.createQuery("SELECT SUM (t.ticketPrice) FROM Ticketcb006302 t WHERE t.ticketDate = :ticketDate").setParameter("ticketDate", date);
        Number sales=(Number)query.getSingleResult();
        return sales;
    }

    @Override
    public Number totalSales() {
        Query query=em.createQuery("SELECT SUM (t.ticketPrice) FROM Ticketcb006302 t");
        Number totsales=(Number)query.getSingleResult();
        return totsales;
    }
    
    
    
}
