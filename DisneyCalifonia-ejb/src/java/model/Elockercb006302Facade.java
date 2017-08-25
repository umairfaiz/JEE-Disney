/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Elockercb006302;
import entities.Wristbandcb006302;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Umair
 */
@Stateless
public class Elockercb006302Facade extends AbstractFacade<Elockercb006302> implements Elockercb006302FacadeLocal {

    @PersistenceContext(unitName = "DisneyCalifonia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Elockercb006302Facade() {
        super(Elockercb006302.class);
    }

    @Override
    public void addElocker(String lockerID, String wristID, String lockerType, int lockerPrice) {
        Elockercb006302 locker = new Elockercb006302();
        
        
        locker.setElockerId(lockerID);
        locker.setWristId(new Wristbandcb006302(wristID));
        locker.setElockerType(lockerType);
        locker.setElockerPrice(lockerPrice);
        
        em.persist(locker);
    }
    
}
