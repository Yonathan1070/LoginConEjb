/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.interfaces.InversorDosFacadeLocal;
import com.mycompany.dto.DTOCuenta;
import com.mycompany.dto.DTOInversor;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Declaracion de la Clase JoinColumnController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-19 1.0
 */
@Named
@RequestScoped
public class JoinColumnController implements Serializable{
    //Declaracion atributos privados de la clase
    private String nombre;
    private String cuenta;
    //implementacion del Entity InversorDosFacadeLocal
    @EJB
    InversorDosFacadeLocal inversorCon;
    /**
     * Creacion nueva instancia de JoinColumnController
     */
    //Constructor vacion de la clase
    public JoinColumnController() {
    }
    //Metodo de agregar datos de nombre  y numero de cuenta mediante el metodo JoinColumn
    public void agregarJoinColumn(){
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
