/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Declaracion de la Clase CuentaDos
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-19 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar en la BD
@Entity
@Table(name = "cuentados")
public class CuentaDos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "INVERSOR_ID")
    //@OneToOne
    //@MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inversor_id")
    private InversorDos inversor;
    //Constructor vacio de la clase
    public CuentaDos() {
    }
    //Constructor de los atributos de la clase
    public CuentaDos(int id, String numeroCuenta, InversorDos inversor) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.inversor = inversor;
    }
    //gettter y setter de los atributos de la clase
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

    public InversorDos getInversor() {
        return inversor;
    }

    public void setInversor(InversorDos inversor) {
        this.inversor = inversor;
    }
}
