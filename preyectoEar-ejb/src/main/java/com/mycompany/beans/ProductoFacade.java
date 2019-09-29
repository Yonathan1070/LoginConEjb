/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOProducto;
import com.mycompany.interfaces.ProductoFacadeLocal;
import com.mycompany.entity.Producto;
import com.mycompany.entity.Usuario;
import com.mycompany.entity.Venta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
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
    public void eliminarDelCarrito(DTOProducto producto) {
        Producto eProducto = find(producto.getId());
        eProducto.setCantidad(eProducto.getCantidad() + producto.getCantSeleccionada());
        edit(eProducto);
    }
    
    @Override
    public void agregarVenta(List<DTOProducto> listaProductos, int idUsuario){
        for (DTOProducto dtoProducto : listaProductos) {
            Producto eProducto = find(dtoProducto.getId());
            Venta venta = new Venta(idUsuario, eProducto, dtoProducto.getCantSeleccionada(), new Date());
            eProducto.getListaVentas().add(venta);
            edit(eProducto);
        }
    }
}
