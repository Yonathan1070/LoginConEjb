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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Declaracion de la Clase InversorFacade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-19 1.0
 */
@Stateless
public class InversorFacade extends AbstractFacade<Inversor> implements InversorFacadeLocal {
    //implementacion donde se llama a la unidad de persistencia
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //Constructor de la clase
    public InversorFacade() {
        super(Inversor.class);
    }
    
    @Override
    //Metodo donde se crea el inversor mediante el DTOInversor y DTOCuenta
    public void crearInversor(DTOInversor inv, DTOCuenta cuenta){
        Inversor inversor = new Inversor();
        inversor.setNombre(inv.getNombre());
        Cuenta entityCuenta = new Cuenta();
        entityCuenta.setNumeroCuenta(cuenta.getNumeroCuenta());
        inversor.setCuenta(entityCuenta);
        entityCuenta.setInversor(inversor);
        create(inversor);
    }
    
    @Override
    //Metodo donde se Obtiene los datos de nombre y cuenta implementando el metodo Joincolumn
    public List<Inversor> obtenerConJoin(String nombre, String cuenta){
        TypedQuery<Inversor> consulta = em.createNamedQuery("join", Inversor.class);
        consulta.setParameter("nombre", nombre);
        consulta.setParameter("cuenta", cuenta);
        return consulta.getResultList();
    }
}
