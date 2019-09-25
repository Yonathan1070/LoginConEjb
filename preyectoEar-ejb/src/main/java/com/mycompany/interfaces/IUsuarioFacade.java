/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.Persona;
import com.mycompany.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 22-09-19 1.0
 */
@Local
//Interface con las acciones a implementar
public interface IUsuarioFacade {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
    Persona login(String username, String password);
    
    void guardarUsuario(Persona usuario);
    
}
