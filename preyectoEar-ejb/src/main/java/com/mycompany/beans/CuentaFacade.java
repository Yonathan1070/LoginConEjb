/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.CuentaFacadeLocal;
import com.mycompany.entity.Cuenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Declaracion de la Clase CuentaFacade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 22-09-2019 1.0
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> implements CuentaFacadeLocal {
    //implementacion donde se llama a la unidad de persistencia
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //Constructor de la clase
    public CuentaFacade() {
        super(Cuenta.class);
    }
    
}
