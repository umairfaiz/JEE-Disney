/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Bulletinboardcb006302;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Umair
 */
@Local
public interface Bulletinboardcb006302FacadeLocal {

    void create(Bulletinboardcb006302 bulletinboardcb006302);

    void edit(Bulletinboardcb006302 bulletinboardcb006302);

    void remove(Bulletinboardcb006302 bulletinboardcb006302);

    Bulletinboardcb006302 find(Object id);

    List<Bulletinboardcb006302> findAll();

    List<Bulletinboardcb006302> findRange(int[] range);

    int count();
    
    public void addEvent(String event_id, String event_time, String event_name);
    
    public void removeEvent(String id);
    
}
