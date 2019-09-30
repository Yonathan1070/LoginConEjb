/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOProducto;
import com.mycompany.dto.Persona;
import com.mycompany.entity.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Declaracion de la Clase BeanSesion
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-19 1.0
 */
@Named
@SessionScoped
public class BeanSesion implements Serializable{

    //Declaracion del atributo privado de la clase
    private Persona user;
    private List<DTOProducto> listaProductos;
    /**
     * Creacion nueva instancia de BeanSesion
     */
    public BeanSesion() {
        listaProductos=new ArrayList();
    }
    
    //Metodo de validacion de la sesion que valida permisos y datos correctos no nulos 
    public void valSes(String rol){
        try {
            FacesContext faces = FacesContext.getCurrentInstance();
            Persona usuario = (Persona) faces.getExternalContext().getSessionMap().get("usuario");
            if (usuario == null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Está tratando de ingresar violentamente al sitio.");
                faces.addMessage(null, msg);
                faces.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect("../login.xhtml");
            }
            else if(!usuario.getRol().equals(rol)){
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "No tiene permisos para ingresar a esta sección del sitio.");
                faces.addMessage(null, msg);
                context.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect("../"+usuario.getRol().toLowerCase()+"/inicio.xhtml");
            }
            user=usuario;
        } catch (Exception e) {

        }
    }
    
    //Metodo de cierre de sesion y redireccionamiento al index
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
    //Metodo que obtiene el valor del atributo User
    public Persona getUser() {
        return user;
    }
    //Metodo que asigna el valor del atributo user al parametro user
    public void setUser(Persona user) {
        this.user = user;
    }

    public List<DTOProducto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<DTOProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
}
