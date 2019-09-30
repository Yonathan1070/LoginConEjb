/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
//Entity donde se declara la tabla y columnas a utilizar en la BD
@Entity
@NamedQueries({
    @NamedQuery(name = "ventas", query = "FROM Venta v WHERE :idUsuario = v.idUsuario GROUP BY v.fecha")
})
public class Venta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "id_usuario")
    private int idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
    @Column
    private int cantidad;
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    //Constructor vacio de la Clase
    public Venta() {
    }
    //Constructor de los atributos privados de la Clase
    public Venta(int idUsuario, Producto producto, int cantidad, Date fecha) {
        this.idUsuario = idUsuario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    //getter y setter de los atributos de la Clase
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    
}
