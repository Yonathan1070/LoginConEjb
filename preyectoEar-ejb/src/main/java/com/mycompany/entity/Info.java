/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Declaracion de la Clase Info
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
//Entity donde se declara la vista y columnas a utilizar
@Entity
@Table(name = "vista_info")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "obtenerEst_Sp", procedureName = "obtenerEstudiantes", resultClasses = {Info.class},
            parameters = {
                @StoredProcedureParameter(name = "idClase", mode = ParameterMode.IN, type = Integer.class)
            })
})
public class Info implements Serializable {

    @Id
    @Column(name = "id_clase")
    private int id;
    @Column(name = "clase")
    private String clase;
    @Column(name = "id_estudiante")
    private int idEstudiante;
    @Column
    private double cedula;
    @Column(name = "estudiante")
    private String nombre;
    @Column
    private String nota;
    //Constructor vacio de la clase
    public Info() {
    }
    //Constructor de los atributos de la clase
    public Info(int id, String clase, int idEstudiante, double cedula, String nombre, String nota) {
        this.id = id;
        this.clase = clase;
        this.idEstudiante = idEstudiante;
        this.cedula = cedula;
        this.nombre = nombre;
        this.nota = nota;
    }
    //getter y setter de los atributos de la clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
}
