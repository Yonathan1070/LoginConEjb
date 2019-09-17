/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Declaracion de la Clase AdministradorController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 15-09-2019 1.0
 */
@Named
@RequestScoped
public class AdministradorController implements Serializable {
    
    @Inject
    private BeanSesion sesion;
    /**
     * Creacion nueva instancia AdministradorController
     */
    //Constructor vacio de la clase
    public AdministradorController() {
    }

    public BeanSesion getSesion() {
        return sesion;
    }

    public void setSesion(BeanSesion sesion) {
        this.sesion = sesion;
    }
    
    
    
    
}
