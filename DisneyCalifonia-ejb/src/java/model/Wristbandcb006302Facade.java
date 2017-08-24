/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Wristbandcb006302;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Umair
 */
@Stateless
public class Wristbandcb006302Facade extends AbstractFacade<Wristbandcb006302> implements Wristbandcb006302FacadeLocal {

    @PersistenceContext(unitName = "DisneyCalifonia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Wristbandcb006302Facade() {
        super(Wristbandcb006302.class);
    }

    @Override
    public void updateCredit(String wristid, int amount) {
       //Query query = em.createQuery("UPDATE Wristbandcb006302 u SET u.creditLimit=u WHERE u.wristId = :w < :u");
       Query query = em.createQuery("UPDATE Wristbandcb006302 u SET u.creditLimit = :u WHERE u.wristId = :w").setParameter("u", amount).setParameter("w", wristid);
       //int updateCredit = query.executeUpdate();
       query.executeUpdate();
    }
    
}
