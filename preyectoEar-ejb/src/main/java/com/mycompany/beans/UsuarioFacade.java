/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.Persona;
import com.mycompany.interfaces.IUsuarioFacade;
import com.mycompany.entity.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Declaracion de la Clase UsuarioFacade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements IUsuarioFacade {
    //Implementacion donde se llama a la unidad de persistencia
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    //Metodo donde se hace la consulta para validacion de los datos en el momento del Login
    public Persona login(String username, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashText = number.toString(16);
            while(hashText.length()<32){
                hashText = "0"+hashText;
            }
            password = hashText;
            
        } catch (NoSuchAlgorithmException ex) {

        }
        Persona dtoPersona = null;
        Usuario user = null;
        try {
            TypedQuery<Usuario> consulta = em.createNamedQuery("login", Usuario.class);
            consulta.setParameter("username", username);
            consulta.setParameter("contrasena", password);
            List<Usuario> lista = consulta.getResultList();
            if(!lista.isEmpty()){
                user = lista.get(0);
                dtoPersona = new Persona(user.getId(), user.getNombre(), user.getUsuario(), user.getContrasena(), user.getRol());
            }
        } catch (Exception e) {
            System.err.println("Error EJB: "+e.getCause());
        }

        return dtoPersona;
    }
    
    @Override
    //Metodo donde se Guarda el usuario
    public void guardarUsuario(Persona usuario){
        Usuario entUsuario = new Usuario(usuario.getNombres(), usuario.getUsername(), usuario.getPassword(), usuario.getRol());
        create(entUsuario);
    }
    //Constructor de la clase
    public UsuarioFacade() {
        super(Usuario.class);
    }

}
