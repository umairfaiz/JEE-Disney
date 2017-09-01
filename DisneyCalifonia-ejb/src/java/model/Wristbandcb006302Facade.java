/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Wristbandcb006302;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

    @Override
    public int updateExpense(String wristid, int expense) {
        Wristbandcb006302 exp = em.find(Wristbandcb006302.class, wristid);
//        TypedQuery<Wristbandcb006302> query = em.createNamedQuery("Wristbandcb006302.findByWristId", Wristbandcb006302.class);
        int old_expense = exp.getExpence();
//        List<Wristbandcb006302> results = query.getResultList();
//        int old_expense = 
        int new_expense=old_expense+expense;
        
        
        Query query = em.createQuery("UPDATE Wristbandcb006302 u SET u.expence = :u WHERE u.wristId = :w").setParameter("u", new_expense).setParameter("w", wristid);
        query.executeUpdate();
        return new_expense;
    }
    @Override
    public int returnCredit(String wristid){
        
        Wristbandcb006302 exp = em.find(Wristbandcb006302.class, wristid);
        int reload=exp.getCreditLimit();
        return reload;
    }

    @Override
    public int returnExpense(String wristid) {
        Wristbandcb006302 exp = em.find(Wristbandcb006302.class, wristid);
        int expense=exp.getExpence();
        return expense;
    }

    @Override
    public void removeUser(String id) {
        Wristbandcb006302 exp = em.find(Wristbandcb006302.class, id);
        em.remove(exp);
    }
    
    
    
}
