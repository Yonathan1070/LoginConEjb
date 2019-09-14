/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.Persona;
import com.mycompany.interfaces.IDatosUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Yonathan
 */
@Stateful
public class DatosUsuarios implements IDatosUsuarios {

    private Persona usuario1;
    private Persona usuario2;
    private Persona usuario3;
    private List<Persona> listaPersonas;

    public DatosUsuarios() {
        listaPersonas  = new ArrayList();
    }
    
    
    
    @Override
    public void agregarUsuarios(){
        usuario1 = new Persona("Yonathan Bohorquez", "yonny", "1070", "Administrador");
        
        usuario2 = new Persona("Jose Bohorquez", "joma", "1234", "Supervisor");
        
        usuario3 = new Persona("Edison Mendez", "edimen", "2668", "Trabajador");
        listaPersonas.add(usuario1);
        listaPersonas.add(usuario2);
        listaPersonas.add(usuario3);
    }
    
    @Override
    public Persona obtenerUsuario(String username, String password){
        for (Persona usuario : listaPersonas) {
            if(usuario.getUsername().equals(username) && usuario.getPassword().equals(password)){
                return usuario;
            }
        }
        return null;
    }
}
