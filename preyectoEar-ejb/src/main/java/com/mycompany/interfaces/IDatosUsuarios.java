/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.Persona;
import javax.ejb.Local;

/**
 * Declaracion de la Interface IDatosUsuarios
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 15-09-2019 1.0
 */

//interface de conexion local y sus metodos  
@Local
public interface IDatosUsuarios {
    public void agregarUsuarios();
    public Persona obtenerUsuario(String username, String password);
}
