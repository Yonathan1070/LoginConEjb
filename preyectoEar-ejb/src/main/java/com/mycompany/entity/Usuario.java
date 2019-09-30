/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Declaracion de la Clase Usuario
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-19 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar en la BD
@Entity
@NamedQueries({
    @NamedQuery(name = "login", query = "FROM Usuario u WHERE u.usuario = :username and  u.contrasena = :contrasena")
})
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @Column
    private String usuario;
    @Column
    private String contrasena;
    @Column
    private String rol;
    //Constructor vacio de la Clase
    public Usuario() {
    }
    //Constructor de los atributos privados de la Clase
    public Usuario(String nombre, String usuario, String contrasena, String rol) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    
    
    // getter y setter de los atributos privados de la clase
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
