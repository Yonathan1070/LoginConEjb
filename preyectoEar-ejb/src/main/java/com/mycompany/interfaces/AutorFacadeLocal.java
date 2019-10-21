/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.Autor;
import java.util.List;
import javax.ejb.Local;

/**
 * Declaracion de la interface
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
@Local
//Interface con las acciones a ejecutar
public interface AutorFacadeLocal {

    void create(Autor autor);

    void edit(Autor autor);

    void remove(Autor autor);

    Autor find(Object id);

    List<Autor> findAll();

    List<Autor> findRange(int[] range);

    int count();
    
}
