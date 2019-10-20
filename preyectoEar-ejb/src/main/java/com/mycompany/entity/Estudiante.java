/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Yonathan
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "consulta", query = "SELECT e FROM Estudiante e JOIN e.listaClases c WHERE c.id = :id_clase")
})
public class Estudiante implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private double cedula;
    @Column
    private String nombre;
    @JoinTable(name = "estudiante_clase", 
            joinColumns = @JoinColumn(name="clase_id", nullable=false),
            inverseJoinColumns = @JoinColumn(name="estudiante_id", nullable=false)
            )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Clase> listaClases;

    public Estudiante() {
    }

    public Estudiante(double cedula, String nombre) {
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

    public List<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(List<Clase> listaClases) {
        this.listaClases = listaClases;
    }
    
    
}
