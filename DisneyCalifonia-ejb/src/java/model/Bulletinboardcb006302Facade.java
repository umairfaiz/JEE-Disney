/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Bulletinboardcb006302;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Umair
 */
@Stateless
public class Bulletinboardcb006302Facade extends AbstractFacade<Bulletinboardcb006302> implements Bulletinboardcb006302FacadeLocal {

    @PersistenceContext(unitName = "DisneyCalifonia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Bulletinboardcb006302Facade() {
        super(Bulletinboardcb006302.class);
    }

    @Override
    public void addEvent(String event_id, String event_time, String event_name) {
        Bulletinboardcb006302 board = new Bulletinboardcb006302();
        board.setEventId(event_id);
        board.setEventTime(event_time);
        board.setEventName(event_name);
        em.persist(board);
    }

    @Override
    public void removeEvent(String id) {
       Bulletinboardcb006302 rem_board = em.find(Bulletinboardcb006302.class, id);
       em.remove(rem_board);
    }
    
}
