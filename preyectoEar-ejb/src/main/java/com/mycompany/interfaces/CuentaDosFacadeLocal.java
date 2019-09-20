/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.CuentaDos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yonathan
 */
@Local
public interface CuentaDosFacadeLocal {

    void create(CuentaDos cuentaDos);

    void edit(CuentaDos cuentaDos);

    void remove(CuentaDos cuentaDos);

    CuentaDos find(Object id);

    List<CuentaDos> findAll();

    List<CuentaDos> findRange(int[] range);

    int count();
    
}
