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
 * Declaracion de la Clase InversorDos
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 22-09-19 1.0
 */
//Entity donde se declara la tabla y columnas a utlizar en la BD
@Entity
@Table(name = "inversordos")
public class InversorDos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    //@OneToOne(mappedBy = "inversordos", cascade=CascadeType.ALL)
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "inversor", fetch = FetchType.LAZY)
    @OneToOne(mappedBy = "inversor", cascade = CascadeType.ALL,
              fetch = FetchType.LAZY, optional = false)
    private CuentaDos cuenta;
    
    public InversorDos() {
    }

    public InversorDos(int id, String nombre, CuentaDos cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

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

    public CuentaDos getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaDos cuenta) {
        this.cuenta = cuenta;
    }
}
