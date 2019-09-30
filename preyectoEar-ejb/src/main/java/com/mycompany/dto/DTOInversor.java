/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;

/**
 * Declaracion de la Clase DTOInversor
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-19 1.0
 */
public class DTOInversor implements Serializable{
    //Declaracion de los atributos privados de la clase
    private int id;
    private String nombre;
    //Constructor vacio de la clase
    public DTOInversor() {
    }
    //getter y setter de los atributos de la clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
