/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.beans.UsuarioFacadeLocal;
import com.mycompany.dto.Persona;
import com.mycompany.entity.Usuario;
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
 * Declaracion de la Clase LoginController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 15-09-2019 1.0
 */
@Named
@RequestScoped
public class LoginController implements Serializable {
    //Declaracion atributos privados de la clase
    private List<Persona> listaUsuarios;
    private String username;
    private String password;
    //Implementacion de la Interface IDatosUsuarios
    @EJB
    IDatosUsuarios usuarios;

    @EJB
    UsuarioFacadeLocal usuarioCon;
    /**
     * Creacion nueva instancia de IndexController
     */
    //Metodo que convierte nuestra lista en un ArrayList
    public LoginController() {
        listaUsuarios = new ArrayList();
    }
    //Metodo que obtiene el usuario y valida datos correctos de inicio de sesion
    public String obtenerUsuarios() {
        Persona usuario;
        usuarios.agregarUsuarios();
        usuario  = usuarios.obtenerUsuario(username, password);
        if (usuario!=null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            return usuario.getRol().toLowerCase()+"/inicio?faces-redirect=true";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Credenciales Incorrectas"));
            return "login";
        }
        /*Usuario user = new Usuario();
        user.setNombre("Yonathan");
        user.setContrasena("1070");
        user.setUsuario("yonny");
        usuarioCon.create(user);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success",
                    "Usuario Creado"));*/
    }
    //Metodo que obtiene el valor del atributo Username
    public String getUsername() {
        return username;
    }
    //Metodo que asigna el valor del atributo username al parametro username
    public void setUsername(String username) {
        this.username = username;
    }
    //Metodo que obtiene el valor del atributo password
    public String getPassword() {
        return password;
    }
    //Metodo que asigna el valor del atributo password al parametro password
    public void setPassword(String password) {
        this.password = password;
    }

}
