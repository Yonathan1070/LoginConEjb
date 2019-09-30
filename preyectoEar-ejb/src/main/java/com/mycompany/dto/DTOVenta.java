/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Declaracion de la Clase DTOVenta
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
public class DTOVenta implements Serializable{
    //Declaracion de los atributos privados de la Clase
    private int id;
    private int idUsuario;
    private int cantidad;
    private Date fecha;
    //Constrcutor vacio de la Clase
    public DTOVenta() {
    }
    //Constructor de los atributos privados de la Clase
    public DTOVenta(int id, int idUsuario, int cantidad, Date fecha) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    //getter y setter de los atributos privados de la Clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
