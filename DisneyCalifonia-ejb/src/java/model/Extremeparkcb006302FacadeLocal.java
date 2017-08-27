/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Extremeparkcb006302;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Umair
 */
@Local
public interface Extremeparkcb006302FacadeLocal {

    void create(Extremeparkcb006302 extremeparkcb006302);

    void edit(Extremeparkcb006302 extremeparkcb006302);

    void remove(Extremeparkcb006302 extremeparkcb006302);

    Extremeparkcb006302 find(Object id);

    List<Extremeparkcb006302> findAll();

    List<Extremeparkcb006302> findRange(int[] range);

    int count();
    
}
