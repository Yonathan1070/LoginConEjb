/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Declaracion de la Clase Empleado
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar en la BD
@Entity
@Table
public class Empleado implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @Column
    private int edad;
    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamento departamento;
    //Constructor vacio de la Clase
    public Empleado() {
    }
    //Constructor de los atributos de la Clase
    public Empleado(String nombre, int edad, Departamento departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.departamento = departamento;
    }
    //getter y setter de los atributos de la Clase
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
}
