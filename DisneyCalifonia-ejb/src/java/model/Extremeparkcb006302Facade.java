/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Extremeparkcb006302;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Umair
 */
@Stateless
public class Extremeparkcb006302Facade extends AbstractFacade<Extremeparkcb006302> implements Extremeparkcb006302FacadeLocal {

    @PersistenceContext(unitName = "DisneyCalifonia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Extremeparkcb006302Facade() {
        super(Extremeparkcb006302.class);
    }
    
}
