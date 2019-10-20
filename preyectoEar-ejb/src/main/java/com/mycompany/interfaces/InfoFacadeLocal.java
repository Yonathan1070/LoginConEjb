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
 *
 * @author Admin
 */
@Local
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
