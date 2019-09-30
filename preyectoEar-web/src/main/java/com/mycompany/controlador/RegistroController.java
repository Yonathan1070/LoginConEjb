/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.Persona;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Declaracion de la Clase RegistroController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Named
@RequestScoped
public class RegistroController implements Serializable{
    //Declaracion de los atributos privados de la Clase
    private String nombre;
    private String username;
    private String password;
    //Implementacion de la interface IUsuarioFacade del paquete de interfaces del ejb
    @EJB
    IUsuarioFacade usuarioCon;
    /**
     * Creacion de una nueva instancia de  RegistroController
     */
    //Constructor vacio de la Clase
    public RegistroController() {
    }
    //getter y setter de los atributos de la Clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    //Metodo de Registro de usuario como Rol Cliente
    public void registrarUsuario(){
        try {
            Persona user = new Persona();
            user.setNombres(nombre);
            user.setRol("Cliente");
            user.setUsername(username);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashText = number.toString(16);
            while(hashText.length()<32){
                hashText = "0"+hashText;
            }
            user.setPassword(hashText);
            usuarioCon.guardarUsuario(user);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado",
                    "Registro satisfactorio."));
            
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error: "+ex);
        }
    }
}
