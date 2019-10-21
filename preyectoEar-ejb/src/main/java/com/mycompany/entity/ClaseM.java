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
 * Declaracion de la Clase ClaseM
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
//Entity donde se declara la tabla y columna a utilizar en la BD con relacion uno a muchos 
@Entity
@Table(name = "clase")
public class ClaseM implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nombre;
    @Column
    private int duracion;
    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL)
    private Set<EstudianteClase> listaEstudiantes;
    //Constructor vacio de la clase
    public ClaseM() {
    }
    //Constructor de los atributos de la clase
    public ClaseM(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }
    //getter y setter de los atributos de la clase
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Set<EstudianteClase> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(Set<EstudianteClase> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

}
