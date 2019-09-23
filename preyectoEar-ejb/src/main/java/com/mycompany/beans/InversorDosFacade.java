/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOCuenta;
import com.mycompany.dto.DTOInversor;
import com.mycompany.entity.CuentaDos;
import com.mycompany.interfaces.InversorDosFacadeLocal;
import com.mycompany.entity.InversorDos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Declaracion de la Clase InversorDosFacade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 22-09-19 1.0
 */
@Stateless
public class InversorDosFacade extends AbstractFacade<InversorDos> implements InversorDosFacadeLocal {
    //Implementacion donde se llama a la unidad de persistencia
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //Constructor de la clase
    public InversorDosFacade() {
        super(InversorDos.class);
    }
    
    @Override
    //Metodo donde se crea el inversor dos llamando al DTOInversor y DTOCuenta
    public void crearInversor(DTOInversor inv, DTOCuenta cuenta){
        InversorDos inversor = new InversorDos();
        inversor.setNombre(inv.getNombre());
        CuentaDos entityCuenta = new CuentaDos();
        entityCuenta.setNumeroCuenta(cuenta.getNumeroCuenta());
        inversor.setCuenta(entityCuenta);
        entityCuenta.setInversor(inversor);
        create(inversor);
    }
    
}
