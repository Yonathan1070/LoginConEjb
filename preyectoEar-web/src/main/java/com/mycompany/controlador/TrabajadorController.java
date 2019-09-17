/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.Persona;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 * Declaracion de la Clase TrabajadorController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 15-09-2019 1.0
 */
@Named
@RequestScoped
public class TrabajadorController implements Serializable{
    @Inject
    private BeanSesion sesion;
    /**
     * Creacion nueva TrabajadorController
     */
    //Constructor vacio de la clase
    public TrabajadorController() {
    }
    public BeanSesion getSesion() {
        return sesion;
    }

    public void setSesion(BeanSesion sesion) {
        this.sesion = sesion;
    }
}
