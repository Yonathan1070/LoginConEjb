/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utilitarios;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Declaracion de la Clase ObtenerSesion
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 15-09-2019 1.0
 */
public class ObtenerSesion {
    //Metodo que obtiene la Session del usuario
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
    //Metodo que obtiene el Request del usuario
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
    //Metodo que obtiene el UserName del usuario
    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }
    //Metodo que obtiene el UserId del usuario
    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("userid");
        } else {
            return null;
        }
    }
}
