/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Elockercb006302;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Umair
 */
@Local
public interface Elockercb006302FacadeLocal {

    void create(Elockercb006302 elockercb006302);

    void edit(Elockercb006302 elockercb006302);

    void remove(Elockercb006302 elockercb006302);

    Elockercb006302 find(Object id);

    List<Elockercb006302> findAll();

    List<Elockercb006302> findRange(int[] range);

    int count();
    
    public void addElocker(String lockerID, String wristID, String lockerType, int lockerPrice);
    public boolean isLockerExist(String wristid, String lockerid);
    
}
