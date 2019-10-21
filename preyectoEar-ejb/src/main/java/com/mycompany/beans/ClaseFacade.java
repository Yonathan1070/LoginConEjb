/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.ClaseFacadeLocal;
import com.mycompany.entity.Clase;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Declaracion de ClaseFacade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
@Stateless
public class ClaseFacade extends AbstractFacade<Clase> implements ClaseFacadeLocal {
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClaseFacade() {
        super(Clase.class);
    }
}
