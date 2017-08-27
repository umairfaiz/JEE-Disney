/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Ticketcb006302;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Umair
 */
@Local
public interface Ticketcb006302FacadeLocal {

    void create(Ticketcb006302 ticketcb006302);

    void edit(Ticketcb006302 ticketcb006302);

    void remove(Ticketcb006302 ticketcb006302);

    Ticketcb006302 find(Object id);

    List<Ticketcb006302> findAll();

    List<Ticketcb006302> findRange(int[] range);

    int count();
    
    public void addticket(String ticketid,String wristID,String type1,String type2,String ticket_date, int ticket_price,String wristid, int credit, int expense);
    
    //public void addWristband(String wristid, int credit, int expense);
    
    public void addExtremeparkTicket(String ticketid,String wristID,String type1,String type2,String ticket_date, int ticket_price);
}
