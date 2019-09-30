/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.Empleado;
import java.util.List;
import javax.ejb.Local;

/**
 * Declaracion de la Interface
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Local
//Interface con las acciones a implementar
public interface EmpleadoFacadeLocal {

    void create(Empleado empleado);

    void edit(Empleado empleado);

    void remove(Empleado empleado);

    Empleado find(Object id);

    List<Empleado> findAll();

    List<Empleado> findRange(int[] range);

    int count();
    
}
