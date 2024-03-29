/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTOProducto;
import com.mycompany.entity.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 * Declaracion de la Interface
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Local
//Interface con las acciones a implementar
public interface ProductoFacadeLocal {

    void create(Producto producto);

    void edit(Producto producto);

    void remove(Producto producto);

    Producto find(Object id);

    List<Producto> findAll();

    List<Producto> findRange(int[] range);

    int count();
    
    void crearProducto(DTOProducto producto);
    
    public List<DTOProducto> obtenerProductos();
    
    boolean obtenerStockProducto(DTOProducto producto);
    
    void eliminarDelCarrito(DTOProducto producto);
    
    void agregarVenta(List<DTOProducto> listaProductos, int idUsuario);
    
}
