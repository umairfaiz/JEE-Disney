/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Wristbandcb006302;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Umair
 */
@Local
public interface Wristbandcb006302FacadeLocal {

    void create(Wristbandcb006302 wristbandcb006302);

    void edit(Wristbandcb006302 wristbandcb006302);

    void remove(Wristbandcb006302 wristbandcb006302);

    Wristbandcb006302 find(Object id);

    List<Wristbandcb006302> findAll();

    List<Wristbandcb006302> findRange(int[] range);

    int count();
    
    public void updateCredit(String wristid, int amount);
    
}
