/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;

/**
 *
 * @author Yonathan
 */
public class DTOProducto implements Serializable{
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double valor;
    private String foto;
    private int cantSeleccionada;
    private double total;

    public DTOProducto() {
    }

    public DTOProducto(String nombre, String descripcion, int cantidad, double valor, String foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.foto = foto;
    }

    public DTOProducto(int id, int cantSeleccionada) {
        this.id = id;
        this.cantSeleccionada = cantSeleccionada;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getCantSeleccionada() {
        return cantSeleccionada;
    }

    public void setCantSeleccionada(int cantSeleccionada) {
        this.cantSeleccionada = cantSeleccionada;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    
    
}
