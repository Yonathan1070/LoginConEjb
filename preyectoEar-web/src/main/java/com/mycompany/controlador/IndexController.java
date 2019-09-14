/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.Persona;
import com.mycompany.interfaces.IDatosUsuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Yonathan
 */
@Named
@RequestScoped
public class IndexController implements Serializable {

    private List<Persona> listaUsuarios;
    private String username;
    private String password;
    @EJB
    IDatosUsuarios usuarios;

    /**
     * Creates a new instance of IndexController
     */
    public IndexController() {
        listaUsuarios = new ArrayList();
    }

    public String obtenerUsuarios() {
        Persona usuario;
        usuarios.agregarUsuarios();
        usuario  = usuarios.obtenerUsuario(username, password);
        if (usuario!=null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            return usuario.getRol().toLowerCase()+"?faces-redirect=true";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Credenciales Incorrectas"));
            return "index";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
