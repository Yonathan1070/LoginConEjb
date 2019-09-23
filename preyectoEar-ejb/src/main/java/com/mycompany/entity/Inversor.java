/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Declaracion de la Clase Inversor
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 22-09-19 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar en la BD
@Entity
@Table
public class Inversor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inversor", fetch = FetchType.LAZY)
    private Cuenta cuenta;
    //Constructor vacio de la clase
    public Inversor() {
    }
    //Constructor de las variables de la clase
    public Inversor(int id, String nombre, Cuenta cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.cuenta = cuenta;
    }
    //getter y setter de los atributos privados de la clase
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

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    
    
    
}
