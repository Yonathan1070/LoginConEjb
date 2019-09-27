/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOProducto;
import com.mycompany.interfaces.ProductoFacadeLocal;
import com.mycompany.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Yonathan
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    public void crearProducto(DTOProducto producto) {
        ModelMapper modelMapper = new ModelMapper();
        Producto productoEntity = modelMapper.map(producto, Producto.class);
        create(productoEntity);
    }
    
    @Override
    public List<DTOProducto> obtenerProductos(){
        
        ModelMapper modelMapper = new ModelMapper();
        List<DTOProducto> listaProductos = new ArrayList();
        List<Producto> listaEntProductos = findAll();
        if(!listaEntProductos.isEmpty()){
            for (Producto pro : listaEntProductos) {
                listaProductos.add(modelMapper.map(pro, DTOProducto.class));
            }
        }
        return listaProductos;
    }
}
