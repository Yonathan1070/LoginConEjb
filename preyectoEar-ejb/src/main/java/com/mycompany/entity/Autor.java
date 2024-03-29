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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Declaracion de la Clase Autor
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar en la BD
@Entity
@Table
public class Autor implements Serializable{
    @Id
    private int id;
    @Column
    private String nombre;
    @ManyToMany(mappedBy = "listaAutores")
    private List<Libro> listaLibros;
    //Constructor vacio de la clase
    public Autor() {
    }
    //Constructor de los atributos de la clase
    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Autor(String nombre, List<Libro> listaLibros) {
        this.nombre = nombre;
        this.listaLibros = listaLibros;
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

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
    
    
}
