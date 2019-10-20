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
 *
 * @author Admin
 */
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

    public EstudianteM() {
    }

    public EstudianteM(double cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public EstudianteM(int id, double cedula, String nombre) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
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
