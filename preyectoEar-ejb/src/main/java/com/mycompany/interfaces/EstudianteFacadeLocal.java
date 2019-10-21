/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.Estudiante;
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
public interface EstudianteFacadeLocal {

    void create(Estudiante estudiante);

    void edit(Estudiante estudiante);

    void remove(Estudiante estudiante);

    Estudiante find(Object id);

    List<Estudiante> findAll();

    List<Estudiante> findRange(int[] range);

    int count();
    
    List<Estudiante> filtro(int id_clase);
    
    List<Estudiante> estudiantesPorMaterias(int id_clase);
    
}
