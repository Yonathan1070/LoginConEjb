/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOProducto;
import com.mycompany.interfaces.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Declaracion de la Clase CarritoController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Named
@RequestScoped
public class CarritoController implements Serializable{
    //Declaracion de los atributos privados de la Clase
    private double total;
    private List<DTOProducto> listaProductos;
    private DTOProducto productoSeleccionado;
    //Implementacion de la Interface ProductoFacadeLocal del paquete de interfaces del ejb
    @EJB
    ProductoFacadeLocal productoCon;
    
    @Inject
    private BeanSesion sesion;
    /**
     * Creacion de una nueva instancia de CarritoController
     */
    //Constructor que convierte la lista en un ArrayList
    public CarritoController() {
        listaProductos = new ArrayList();
    }
    //getter y setter de los atributos de la Clase
    public BeanSesion getSesion() {
        return sesion;
    }

    public void setSesion(BeanSesion sesion) {
        this.sesion = sesion;
    }

    public DTOProducto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(DTOProducto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public List<DTOProducto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<DTOProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    //Metodo que elimina Productos del carrito de compras
    public void eliminarDelCarrito(){
        DTOProducto producto = productoSeleccionado;
        sesion.getListaProductos().remove(producto);
        productoCon.eliminarDelCarrito(producto);
        FacesContext faces = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado",
                        "Producto eliminado del Carrito.");
                faces.addMessage(null, msg);
    }
    //Metodo que finaliza la compra 
    public void finalizarCompra(){
        productoCon.agregarVenta(sesion.getListaProductos(), sesion.getUser().getId());
        sesion.getListaProductos().clear();
        FacesContext faces = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado",
                        "Productos comprados.");
                faces.addMessage(null, msg);
    }
    //Metodo que obtiene el valor total de los productos de la compra
    public double obtenerTotal(){
        listaProductos = sesion.getListaProductos();
        total=0;
        for (DTOProducto producto : listaProductos) {
            total = (total+producto.getTotal());
        }
        return total;
    }
    public boolean visible(){
        if(total!=0){
            return true;
        }else{
            return false;
        }
    }
}
