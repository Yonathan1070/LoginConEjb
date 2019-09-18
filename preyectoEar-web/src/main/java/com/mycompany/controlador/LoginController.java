/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.interfaces.IUsuarioFacade;
import com.mycompany.dto.Persona;
import com.mycompany.entity.Cuenta;
import com.mycompany.entity.Inversor;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.CuentaFacadeLocal;
import com.mycompany.interfaces.IDatosUsuarios;
import com.mycompany.interfaces.InversorFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private Persona usuario;
    private String username;
    private String password;
    //Implementacion de la Interface IDatosUsuarios
    @EJB
    IDatosUsuarios usuarios;

    @EJB
    IUsuarioFacade usuarioCon;
    
    @EJB
    CuentaFacadeLocal cuentaCon;
    
    @EJB
    InversorFacadeLocal inversorCon;
    /**
     * Creacion nueva instancia de IndexController
     */
    //Metodo que convierte nuestra lista en un ArrayList
    public LoginController() {
        listaUsuarios = new ArrayList();
    }
    
    //Metodo que obtiene el usuario y valida datos correctos de inicio de sesion
    public String obtenerUsuarios() {
        //Login con BD Mapeada
        String redireccion=null;
        try{
            Persona p = usuarioCon.login(username, password);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", p);
            return p.getRol().toLowerCase()+"/inicio?faces-redirect=true";
        }catch(Exception e){
            System.err.println("Error: "+e);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Credenciales Incorrectas"));
        }
        return redireccion;
        
        
        //Login Quemado
        /*Persona usuario;
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
        }*/
        
        //Insert Usuario Mapeo
        /*Usuario user = new Usuario();
        user.setNombre("Yonathan");
        user.setContrasena("1070");
        user.setUsuario("yonny");
        usuarioCon.create(user);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success",
                    "Usuario Creado"));*/
        
        //One to One
        /*Inversor inversor = new Inversor();
        inversor.setNombre("Yonathan");
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123456-AB");
        inversor.setCuenta(cuenta);
        cuenta.setInversor(inversor);
        //cuentaCon.create(cuenta);
        inversorCon.create(inversor);
        System.out.println("Finalizado...");*/
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
