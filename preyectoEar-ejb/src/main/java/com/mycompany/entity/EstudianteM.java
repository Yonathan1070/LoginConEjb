/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * Declaracion de la Clase EstudianteM
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar
@Entity
@Table(name = "estudiante")
public class EstudianteM implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private double cedula;
    @Column
    private String nombre;
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private Set<EstudianteClase> listaClases = new HashSet();
    //Constructor vacio de la clase
    public EstudianteM() {
    }
    //Constructor de los atributos de la clase
    public EstudianteM(double cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public EstudianteM(int id, double cedula, String nombre) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
    }
    //getter y setter de los atributos de la clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<EstudianteClase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(Set<EstudianteClase> listaClases) {
        this.listaClases = listaClases;
    }
    
}
