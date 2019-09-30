/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.Cuenta;
import java.util.List;
import javax.ejb.Local;

/**
 * Declaracion de la Interface
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-19 1.0
 */
@Local
//Interface con las acciones a implementar
public interface CuentaFacadeLocal {

    void create(Cuenta cuenta);

    void edit(Cuenta cuenta);

    void remove(Cuenta cuenta);

    Cuenta find(Object id);

    List<Cuenta> findAll();

    List<Cuenta> findRange(int[] range);

    int count();
    
}
