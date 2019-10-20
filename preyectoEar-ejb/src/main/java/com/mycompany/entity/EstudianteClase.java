/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "estudiante_clase")
public class EstudianteClase implements Serializable{
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "clase_id", nullable = false)
    private ClaseM clase;
    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private EstudianteM estudiante;
    @Column
    private String nota;

    public EstudianteClase() {
    }

    public EstudianteClase(ClaseM clase, EstudianteM estudiante, String nota) {
        this.clase = clase;
        this.estudiante = estudiante;
        this.nota = nota;
    }

    public EstudianteClase(String nota) {
        this.nota = nota;
    }

    public ClaseM getClase() {
        return clase;
    }

    public void setClase(ClaseM clase) {
        this.clase = clase;
    }

    public EstudianteM getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteM estudiante) {
        this.estudiante = estudiante;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
