/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.EstudianteM;
import java.util.List;
import javax.ejb.Local;

/**
 * Declaracion de la interface
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 */
@Local
//Interface con las acciones a ejecutar
public interface EstudianteMFacadeLocal {

    void create(EstudianteM estudianteM);

    void edit(EstudianteM estudianteM);

    void remove(EstudianteM estudianteM);

    EstudianteM find(Object id);

    List<EstudianteM> findAll();

    List<EstudianteM> findRange(int[] range);

    int count();
    
    List<EstudianteM> filtro(int id_clase);
    
}
