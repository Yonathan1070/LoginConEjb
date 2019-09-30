/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOProducto;
import com.mycompany.interfaces.ProductoFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * Declaracion de la Clase ProductosController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Named
@ViewScoped
public class ProductosController implements Serializable {
    //Declaracion atributos privados de la Clase
    private UploadedFile file;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double valor;
    private List<DTOProducto> listaProductos;
    //Implementacion de la interface ProductFacadeLocal del paquete de interfaces del ejb
    @EJB
    ProductoFacadeLocal productoCon;

    /**
     * Creacion una nueva instancia de ProductosController
     */
    public ProductosController() {
        listaProductos = new ArrayList();
    }
    
    @PostConstruct
    public void _init(){
        listaProductos = productoCon.obtenerProductos();
    }
    //getter y setter de los atributos de la Clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<DTOProducto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<DTOProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void upload(FileUploadEvent event) {
        if (event != null) {
            file = event.getFile();
        }
    }
    //Metodo de guardado de Productos
    public void guardar() {
        try {
            if (file != null) {
                String foto = copyFile(file.getFileName(), file.getInputstream());
                DTOProducto producto = new DTOProducto(nombre, descripcion, cantidad, valor, foto);
                productoCon.crearProducto(producto);
                obtenerProductos();
                FacesMessage msg = new FacesMessage("Producto Agregado.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No hay archivos cargados.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    //Metodo de Guardado de la Imagen del Producto
    public String copyFile(String fileName, InputStream in) {
        String nombreA = "";
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext scontext = (ServletContext) context.getExternalContext().getContext();
            System.out.println("Ruta Path: " + scontext.getRealPath("/"));
            String ruta = scontext.getRealPath("\\") + "/resources/images/";
            try (OutputStream out = new FileOutputStream(new File(ruta + fileName))) {
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.flush();
            }
            System.out.println("El archivo se ha creado con éxito!");

            DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
            Date date = new Date();
            String ruta1 = ruta + fileName;
            System.err.println("Ruta Inicial: " + ruta1);
            String ruta2 = ruta + dateFormat.format(date) + fileName;
            System.out.println("Archivo: " + ruta1 + "\nRenombrado a: " + ruta2);
            File archivo = new File(ruta1);
            archivo.renameTo(new File(ruta2));
            nombreA = dateFormat.format(date) + fileName;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return nombreA;
    }
    //Metodo para Obtener Productos
    public void obtenerProductos(){
        listaProductos = productoCon.obtenerProductos();
    }
}
