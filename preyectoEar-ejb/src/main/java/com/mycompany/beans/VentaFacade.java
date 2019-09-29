/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOProducto;
import com.mycompany.dto.DTOVenta;
import com.mycompany.entity.Inversor;
import com.mycompany.interfaces.VentaFacadeLocal;
import com.mycompany.entity.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Yonathan
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> implements VentaFacadeLocal {
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }
    
    @Override
    public List<Venta> obtenerListaVentas(int idUsuario){
        List<Venta> listaVentas = new ArrayList();
        TypedQuery<Venta> consulta = em.createNamedQuery("ventas", Venta.class);
        consulta.setParameter("idUsuario", idUsuario);
        listaVentas = consulta.getResultList();
        return listaVentas;
    }
}
