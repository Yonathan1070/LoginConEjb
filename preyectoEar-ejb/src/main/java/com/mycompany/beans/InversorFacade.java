/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOCuenta;
import com.mycompany.dto.DTOInversor;
import com.mycompany.entity.Cuenta;
import com.mycompany.interfaces.InversorFacadeLocal;
import com.mycompany.entity.Inversor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yonathan
 */
@Stateless
public class InversorFacade extends AbstractFacade<Inversor> implements InversorFacadeLocal {
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InversorFacade() {
        super(Inversor.class);
    }
    
    @Override
    public void crearInversor(DTOInversor inv, DTOCuenta cuenta){
        Inversor inversor = new Inversor();
        inversor.setNombre(inv.getNombre());
        Cuenta entityCuenta = new Cuenta();
        entityCuenta.setNumeroCuenta(cuenta.getNumeroCuenta());
        inversor.setCuenta(entityCuenta);
        entityCuenta.setInversor(inversor);
        create(inversor);
    }
    
}
