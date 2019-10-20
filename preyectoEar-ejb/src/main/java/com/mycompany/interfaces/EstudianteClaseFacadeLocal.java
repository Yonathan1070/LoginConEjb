/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.EstudianteClase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface EstudianteClaseFacadeLocal {

    void create(EstudianteClase estudianteClase);

    void edit(EstudianteClase estudianteClase);

    void remove(EstudianteClase estudianteClase);

    EstudianteClase find(Object id);

    List<EstudianteClase> findAll();

    List<EstudianteClase> findRange(int[] range);

    int count();
    
    int obtenerDatos(int id_clase, int id_estudiante);
    
}
