/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Yonathan
 */
@Named
@RequestScoped
public class ClienteController implements Serializable{

    @Inject
    private BeanSesion sesion;
    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
    }
    
    //get y set de la variable privada de la clase
    public BeanSesion getSesion() {
        return sesion;
    }

    public void setSesion(BeanSesion sesion) {
        this.sesion = sesion;
    }
    
}
