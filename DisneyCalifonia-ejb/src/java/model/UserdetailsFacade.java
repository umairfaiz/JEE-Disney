/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Userdetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Umair
 */
@Stateless
public class UserdetailsFacade extends AbstractFacade<Userdetails> implements UserdetailsFacadeLocal {

    @PersistenceContext(unitName = "DisneyCalifonia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserdetailsFacade() {
        super(Userdetails.class);
    }

    @Override
    public void addUser(String id, String username, String email, String type, String password) {
        Userdetails user = new Userdetails();
        user.setUserId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setUsertype(type);
        
        em.persist(user);
    }

    @Override
    public boolean isUserExist(String usr, String pwd) {
        //Userdetails checkUser=new Userdetails();
        boolean flag=false;
        
        Query query = em.createQuery("SELECT u FROM Userdetails u WHERE u.username = :u").setParameter("u", usr);
        
        if(!query.getResultList().isEmpty()){
             flag=true;
        }
         return flag;
    }

    @Override
    public void removeusername(String id) {
        Query query = em.createQuery("DELETE FROM Userdetails c WHERE c.username = :u").setParameter("u", id);
        query.executeUpdate();
    }
    
}
