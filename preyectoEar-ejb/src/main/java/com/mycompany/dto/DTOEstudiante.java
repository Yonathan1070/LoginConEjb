/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;

/**
 * Declaracion de la Clase DTOEstudiante
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
public class DTOEstudiante implements Serializable{
    //Declaracion de los atributos privados de la clase
    private int id;
    private double cedula;
    private String nombre;
    //Constructor vacio de la clase
    public DTOEstudiante() {
    }
    //Constructor de los atributos de la clase
    public DTOEstudiante(double cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    //getter y setter de los atributos de la clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
