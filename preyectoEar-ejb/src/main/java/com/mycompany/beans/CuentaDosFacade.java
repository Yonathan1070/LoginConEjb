/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.CuentaDosFacadeLocal;
import com.mycompany.entity.CuentaDos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Declaracion de la Clase CuentaDosFacade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019
 */
@Stateless
public class CuentaDosFacade extends AbstractFacade<CuentaDos> implements CuentaDosFacadeLocal {
    //Implementacion donde se llama a la unidad de persistencia
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //Constructor de la Clase
    public CuentaDosFacade() {
        super(CuentaDos.class);
    }
    
}
