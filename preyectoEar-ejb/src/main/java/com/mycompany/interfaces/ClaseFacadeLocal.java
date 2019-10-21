/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTOClase;
import com.mycompany.dto.DTOEstudiante;
import com.mycompany.entity.Clase;
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
public interface ClaseFacadeLocal {

    void create(Clase clase);

    void edit(Clase clase);

    void remove(Clase clase);

    Clase find(Object id);

    List<Clase> findAll();

    List<Clase> findRange(int[] range);

    int count();
    
}
