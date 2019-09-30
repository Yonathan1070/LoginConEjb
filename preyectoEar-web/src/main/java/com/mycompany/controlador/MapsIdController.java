/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOCuenta;
import com.mycompany.dto.DTOInversor;
import com.mycompany.interfaces.InversorFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Declaracion de la Clase MapsIdController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Named
@RequestScoped
public class MapsIdController implements Serializable{
    //Declaracion de los atributos privados de la clase
    private String nombre;
    private String cuenta;
    //Implementacion de EJB InversorFacadeLocal del paquete de interfaces
    @EJB
    InversorFacadeLocal inversorCon;
    /**
     * Creacion una nueva instancia de MapsIdController
     */
    //Constructor vacio de la clase
    public MapsIdController() {
    }
    //Metodo que agrega los datos de nombre y numero de cuenta mediante el metodo MapsId
    public void agregarMapsId(){
        DTOInversor dtoInversor = new DTOInversor();
        DTOCuenta dtoCuenta = new DTOCuenta();
        dtoInversor.setNombre(nombre);
        dtoCuenta.setNumeroCuenta(cuenta);
        inversorCon.crearInversor(dtoInversor, dtoCuenta);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado",
                    "Inversor "+nombre+" agregado satisfactoriamente"));
    }
    //getter y setter de los atributos de la clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    
}
