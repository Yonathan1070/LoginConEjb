/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.ClaseM;
import java.util.List;
import javax.ejb.Local;

/**
 * Declaracion de la interface
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 */
@Local
//Interface con las acciones a ejecutar
public interface ClaseMFacadeLocal {

    void create(ClaseM claseM);

    void edit(ClaseM claseM);

    void remove(ClaseM claseM);

    ClaseM find(Object id);

    List<ClaseM> findAll();

    List<ClaseM> findRange(int[] range);

    int count();
    
}
