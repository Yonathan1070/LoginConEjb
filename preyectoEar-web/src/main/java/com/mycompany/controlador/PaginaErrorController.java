/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 * Declaracion de la Clase PaginaErrorController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 15-09-2019 1.0
 */
@Named
@SessionScoped
public class PaginaErrorController implements Serializable {

    /**
     * Creacion nueva instancia de PaginaErrorController
     */
    //Constructor vacio de la clase
    public PaginaErrorController() {
    }
    //Declaracion atributo privado
    private String message;
    //Metodo que obtiene el valor del atributo message
    public String getMessage() {
        return message;
    }
    //Metodo que asigna el valor del atributo message al parametro message
    public void setMessage(String message) {
        this.message = message;
    }

    public String navigate() {
        System.out.println(10 / 0);
        return "login";
    }
}
