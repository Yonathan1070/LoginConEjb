/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTOInfo;
import com.mycompany.entity.Info;
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
public interface InfoFacadeLocal {

    void create(Info info);

    void edit(Info info);

    void remove(Info info);

    Info find(Object id);

    List<Info> findAll();

    List<Info> findRange(int[] range);

    int count();
    
    List<DTOInfo> obtenerEstudiantesConStore(Integer id);
    
}
