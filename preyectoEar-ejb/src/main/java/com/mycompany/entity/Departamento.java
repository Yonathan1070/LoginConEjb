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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Declaracion de la Clase Departamento
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar en la BD
@Entity
@Table
public class Departamento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Empleado> listaEmpleados;
    //Constructor vacio de la Clase
    public Departamento() {
    }
    //Constructor de los atributos de la Clase
    public Departamento(String nombre, List<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.listaEmpleados = listaEmpleados;
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

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
    
}
