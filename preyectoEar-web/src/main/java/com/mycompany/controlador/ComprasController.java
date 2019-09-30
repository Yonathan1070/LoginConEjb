/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOProducto;
import com.mycompany.dto.DTOVenta;
import com.mycompany.entity.Venta;
import com.mycompany.interfaces.ProductoFacadeLocal;
import com.mycompany.interfaces.VentaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Declaracion de la Clase ComprasController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Named
@RequestScoped
public class ComprasController implements Serializable{
    //Declaracion atributos privados de la Clase
    private Venta ventaSeleccionada;
    //Implementacion de la Interface VentaFacadeLocal del paquete interfaces del ejb
    @EJB
    VentaFacadeLocal ventaCon;
    
    @Inject
    BeanSesion sesion;
    
    private List<Venta> listaVentas;
    /**
     * Creacion nueva instancia de ComprasController
     */
    //Constructor que convierte la lista en un ArrayList
    public ComprasController() {
        listaVentas=new ArrayList();
    }
    
    @PostConstruct
    public void _init(){
        listaVentas=ventaCon.obtenerListaVentas(sesion.getUser().getId());
    }
    //getter y setter de los atributos privados de la Clase
    public List<Venta> getListaCompras() {
        return listaVentas;
    }

    public void setListaCompras(List<Venta> listaCompras) {
        this.listaVentas = listaCompras;
    }

    public Venta getVentaSeleccionada() {
        return ventaSeleccionada;
    }

    public void setVentaSeleccionada(Venta ventaSeleccionada) {
        this.ventaSeleccionada = ventaSeleccionada;
    }
    
    public void obtenerCompras(){
        listaVentas=ventaCon.obtenerListaVentas(sesion.getUser().getId());
    }
}
