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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Declaracion de la Clase Libro
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar en la BD
@Entity
@Table
public class Libro implements Serializable{
    @Id
    private int id;
    @Column
    private String nombre;
    @JoinTable(name = "autor_libro", 
            joinColumns = @JoinColumn(name="id_libro", nullable=false),
            inverseJoinColumns = @JoinColumn(name="id_autor", nullable=false)
            )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Autor> listaAutores;
    //Constructor vacio de la Clase
    public Libro() {
    }
    //Constructor de los atributos de la clase
    public Libro(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Libro(String nombre, List<Autor> listaAutores) {
        this.nombre = nombre;
        this.listaAutores = listaAutores;
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

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(List<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }
    
    
}
