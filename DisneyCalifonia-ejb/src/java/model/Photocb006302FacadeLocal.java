/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Photocb006302;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Umair
 */
@Local
public interface Photocb006302FacadeLocal {

    void create(Photocb006302 photocb006302);

    void edit(Photocb006302 photocb006302);

    void remove(Photocb006302 photocb006302);

    Photocb006302 find(Object id);

    List<Photocb006302> findAll();

    List<Photocb006302> findRange(int[] range);

    int count();
    
    public void uploadPhoto(String photoid, String wristid);
    
    public void addPhoto(String photoid, String wristid, String type, String price);
}
