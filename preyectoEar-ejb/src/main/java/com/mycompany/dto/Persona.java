/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;


/**
 * Declaracion de la Clase Persona
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 22-09-19 1.0
 */
public class Persona implements Serializable{
    //Declaracion de los atributos privados de la clase
    private int id;
    private String nombres;
    private String username;
    private String password;
    private String rol;
    //Constructor de la clase
    public Persona(String nombres, String username, String password, String rol) {
        this.nombres = nombres;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Persona(int id, String nombres, String username, String password, String rol) {
        this.id = id;
        this.nombres = nombres;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
    //Constructor vacio de la clase
    public Persona() {
    }
    
    //getter y setter del atributo Id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //Metodo que obtiene el valor del atributo Nombres
    public String getNombres() {
        return nombres;
    }
    //Metodo que asigna el valor del atributo nombres al parametro nombres
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    //Metodo que obtiene el valor del atributo Username
    public String getUsername() {
        return username;
    }
    //Metodo que asigna el valor del atributo username al parametro username
    public void setUsername(String username) {
        this.username = username;
    }
    //Metodo que obtiene el valor del atributo Password
    public String getPassword() {
        return password;
    }
    //Metodo que asigna el valor del atributo password al parametro password
    public void setPassword(String password) {
        this.password = password;
    }
    //Metodo que obtiene el valor del atributo Rol
    public String getRol() {
        return rol;
    }
    //Metodo que asigna el valor del atributo rol al parametro rol
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
