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
 *
 * @author Yonathan
 */
@Named
@RequestScoped
public class CarritoController implements Serializable{

    private double total;
    private List<DTOProducto> listaProductos;
    private DTOProducto productoSeleccionado;
    
    @EJB
    ProductoFacadeLocal productoCon;
    
    @Inject
    private BeanSesion sesion;
    /**
     * Creates a new instance of CarritoController
     */
    public CarritoController() {
        listaProductos = new ArrayList();
    }

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
    
    
    public void eliminarDelCarrito(){
        DTOProducto producto = productoSeleccionado;
        sesion.getListaProductos().remove(producto);
        productoCon.eliminarDelCarrito(producto);
        FacesContext faces = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado",
                        "Producto eliminado del Carrito.");
                faces.addMessage(null, msg);
    }
    
    public void finalizarCompra(){
        productoCon.agregarVenta(sesion.getListaProductos(), sesion.getUser().getId());
        sesion.getListaProductos().clear();
        FacesContext faces = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado",
                        "Productos comprados.");
                faces.addMessage(null, msg);
    }
    
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
