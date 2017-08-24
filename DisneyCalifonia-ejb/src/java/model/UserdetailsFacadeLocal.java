/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Userdetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Umair
 */
@Local
public interface UserdetailsFacadeLocal {

    void create(Userdetails userdetails);

    void edit(Userdetails userdetails);

    void remove(Userdetails userdetails);

    Userdetails find(Object id);

    List<Userdetails> findAll();

    List<Userdetails> findRange(int[] range);

    int count();
    
    public void addUser(String id, String username, String email, String type, String password);
    public boolean isUserExist(String usr, String pwd);
}
