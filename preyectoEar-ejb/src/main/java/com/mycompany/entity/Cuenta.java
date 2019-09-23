/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Declaracion de la Clase Cuenta
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 22-09-19 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar en la BD
@Entity
@Table
public class Cuenta implements Serializable{
    @Id
    @Column(name = "inversor_id")
    private int id;
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    @OneToOne
    @MapsId
    private Inversor inversor;
    //Constructor vacio de la clase
    public Cuenta() {
    }
    //Constructor de los atributos de la clase
    public Cuenta(int id, String numeroCuenta, Inversor inversor) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.inversor = inversor;
    }
    //getter y setter de los atributos de la clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Inversor getInversor() {
        return inversor;
    }

    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }
    
    
}
