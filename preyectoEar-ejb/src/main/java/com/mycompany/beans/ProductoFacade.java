/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOProducto;
import com.mycompany.interfaces.ProductoFacadeLocal;
import com.mycompany.entity.Producto;
import com.mycompany.entity.Venta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;

/**
 * Declaracion de la Clase ProductoFacade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {
    //implementacion donde se llama a la unidad de Persistencia
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //Constructor de la Clase
    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    //Metodo de CrearProducto
    public void crearProducto(DTOProducto producto) {
        ModelMapper modelMapper = new ModelMapper();
        Producto productoEntity = modelMapper.map(producto, Producto.class);
        create(productoEntity);
    }

    @Override
    //Metodo para ObtenerProducto
    public List<DTOProducto> obtenerProductos() {

        ModelMapper modelMapper = new ModelMapper();
        List<DTOProducto> listaProductos = new ArrayList();
        List<Producto> listaEntProductos = findAll();
        if (!listaEntProductos.isEmpty()) {
            for (Producto pro : listaEntProductos) {
                listaProductos.add(modelMapper.map(pro, DTOProducto.class));
            }
        }
        return listaProductos;
    }

    @Override
    //Metodo para Obtener el Stock del Producto 
    public boolean obtenerStockProducto(DTOProducto producto) {

        Producto eProducto = new Producto();
        eProducto = find(producto.getId());
        if (eProducto.getCantidad() < producto.getCantSeleccionada()) {
            return false;
        } else {
            eProducto.setCantidad(eProducto.getCantidad() - producto.getCantSeleccionada());
            edit(eProducto);
            return true;
        }
    }

    @Override
    //Metodo para Eliminar  Carrito y Productos añadidos
    public void eliminarDelCarrito(DTOProducto producto) {
        Producto eProducto = find(producto.getId());
        eProducto.setCantidad(eProducto.getCantidad() + producto.getCantSeleccionada());
        edit(eProducto);
    }
    
    @Override
    //Metodo para Agregar Venta
    public void agregarVenta(List<DTOProducto> listaProductos, int idUsuario){
        for (DTOProducto dtoProducto : listaProductos) {
            Producto eProducto = find(dtoProducto.getId());
            Venta venta = new Venta(idUsuario, eProducto, dtoProducto.getCantSeleccionada(), new Date());
            eProducto.getListaVentas().add(venta);
            edit(eProducto);
        }
    }
}
