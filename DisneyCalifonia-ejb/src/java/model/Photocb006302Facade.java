/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Photocb006302;
import entities.Wristbandcb006302;
import entities.AdminPhotoscb006302;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Umair
 */
@Stateless
@DeclareRoles({"AdminRole"})
public class Photocb006302Facade extends AbstractFacade<Photocb006302> implements Photocb006302FacadeLocal {

    @PersistenceContext(unitName = "DisneyCalifonia-ejbPU")
    private EntityManager em;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Photocb006302Facade() {
        super(Photocb006302.class);
    }
    @RolesAllowed({"AdminRole"})
    @Override
    public void uploadPhoto(String photoid, String wristid) {
            AdminPhotoscb006302 photo = new AdminPhotoscb006302();
            Wristbandcb006302 wristband = new Wristbandcb006302();
            
            photo.setPhotoId(photoid);
            photo.setWristId(wristid);
            //photo.setWristId(new Wristbandcb006302(wristid));
            em.persist(photo);
    }
    @PermitAll
    @Override
    public void addPhoto(String photoid, String wristid, String type, String price) {
        Photocb006302 photo = new Photocb006302();
        Wristbandcb006302 wristband = new Wristbandcb006302();
        photo.setPhotoId(photoid);
        //photo.setWristId(new Wristbandcb006302(wristband.getWristId()));
        photo.setWristId(new Wristbandcb006302(wristid));
        photo.setPhotoType(type);
        photo.setPhotoPrice(price);
        em.persist(photo);
        
    }
    
}
