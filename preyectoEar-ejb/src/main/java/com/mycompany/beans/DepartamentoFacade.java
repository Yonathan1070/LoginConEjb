/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.DepartamentoFacadeLocal;
import com.mycompany.entity.Departamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Declaracion de la Clase DepartamentoFacade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<Departamento> implements DepartamentoFacadeLocal {
    //Implementacion donde se llama a la unidad de Persistencia
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //Constructor de la Clase
    public DepartamentoFacade() {
        super(Departamento.class);
    }
    
}
