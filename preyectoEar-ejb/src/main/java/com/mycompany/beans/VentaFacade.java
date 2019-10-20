/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.VentaFacadeLocal;
import com.mycompany.entity.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Declaracion de la Clase VentaFacade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> implements VentaFacadeLocal {
    //Implementacion donde se llama a la unidad de Persitencia
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //Constructor de la clase
    public VentaFacade() {
        super(Venta.class);
    }
    
    @Override
    //Metodo para obtener la Lista de Ventas para cada Usuario
    public List<Venta> obtenerListaVentas(int idUsuario){
        List<Venta> listaVentas = new ArrayList();
        TypedQuery<Venta> consulta = em.createNamedQuery("ventas", Venta.class);
        consulta.setParameter("idUsuario", idUsuario);
        listaVentas = consulta.getResultList();
        return listaVentas;
    }
}
