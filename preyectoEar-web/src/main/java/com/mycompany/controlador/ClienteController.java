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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Declaracion de la Clase ClienteController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Named
@RequestScoped
public class ClienteController implements Serializable{
    //Declaracion de los atributos privados de la Clase
    private List<DTOProducto> listaProductos;
    private DTOProducto productoSeleccionado;
    //Implementacion de la Interface ProductoFacadeLocal del paquete interfaces del ejb
    @EJB
    ProductoFacadeLocal productoCon;
    
    @Inject
    private BeanSesion sesion;
    /**
     * Creacion nueva instancia de  ClienteController
     */
    //Constructor que convierte la lista en un ArrayList
    public ClienteController() {
        listaProductos = new ArrayList();
    }
    
    @PostConstruct
    public void _init(){
        listaProductos = productoCon.obtenerProductos();
    }
    
    //get y set de la variable privada de la clase
    public BeanSesion getSesion() {
        return sesion;
    }

    public void setSesion(BeanSesion sesion) {
        this.sesion = sesion;
    }
    
    public List<DTOProducto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<DTOProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public DTOProducto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(DTOProducto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
    
    public void obtenerProductos(){
        listaProductos = productoCon.obtenerProductos();
    }
    //Metodo para agregar producto al carrito de compras
    public void agregarCarrito(){
        //DTOProducto producto = new DTOProducto(productoSeleccionado.getId(), productoSeleccionado.getCantSeleccionada());
        DTOProducto producto = productoSeleccionado;
        producto.setTotal(productoSeleccionado.getValor()*productoSeleccionado.getCantSeleccionada());
        boolean respuesta = productoCon.obtenerStockProducto(producto);
        if(!respuesta){
            FacesContext faces = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "No puede superar la cantidad en stock");
                faces.addMessage(null, msg);
        }else{
            sesion.getListaProductos().add(producto);
            obtenerProductos();
            FacesContext faces = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado",
                        "Producto agregado al Carrito.");
                faces.addMessage(null, msg);
        }
    }
}
