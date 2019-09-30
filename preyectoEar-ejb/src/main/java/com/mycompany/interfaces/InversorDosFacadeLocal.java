/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTOCuenta;
import com.mycompany.dto.DTOInversor;
import com.mycompany.entity.InversorDos;
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
public interface InversorDosFacadeLocal {

    void create(InversorDos inversorDos);

    void edit(InversorDos inversorDos);

    void remove(InversorDos inversorDos);

    InversorDos find(Object id);

    List<InversorDos> findAll();

    List<InversorDos> findRange(int[] range);

    int count();
    
    public void crearInversor(DTOInversor inv, DTOCuenta cuenta);
}
