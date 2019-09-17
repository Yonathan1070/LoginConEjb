/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.IUsuarioFacade;
import com.mycompany.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yonathan
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements IUsuarioFacade {

    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Usuario login(String username, String password) {
        Usuario user = null;
        try {
            Query consulta = em.createQuery("FROM Usuario u WHERE u.usuario = ?1 and  u.contrasena = ?2");
            consulta.setParameter(1, username);
            consulta.setParameter(2, password);
            List<Usuario> lista = consulta.getResultList();
            if(!lista.isEmpty())
                user = lista.get(0);
        } catch (Exception e) {
            throw e;
        }

        return user;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

}
