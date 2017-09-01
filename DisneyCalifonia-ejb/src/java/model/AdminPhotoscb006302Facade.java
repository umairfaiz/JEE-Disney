/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.AdminPhotoscb006302;
import entities.Photocb006302;
import entities.Wristbandcb006302;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Umair
 */
@Stateless
public class AdminPhotoscb006302Facade extends AbstractFacade<AdminPhotoscb006302> implements AdminPhotoscb006302FacadeLocal {

    @PersistenceContext(unitName = "DisneyCalifonia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminPhotoscb006302Facade() {
        super(AdminPhotoscb006302.class);
    }

    
    
}
