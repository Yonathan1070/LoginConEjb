/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.entity.ClaseM;
import com.mycompany.interfaces.EstudianteClaseFacadeLocal;
import com.mycompany.entity.EstudianteClase;
import com.mycompany.entity.EstudianteM;
import com.mycompany.entity.Info;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Admin
 */
@Stateless
public class EstudianteClaseFacade extends AbstractFacade<EstudianteClase> implements EstudianteClaseFacadeLocal {
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteClaseFacade() {
        super(EstudianteClase.class);
    }
    
    @Override
    public int obtenerDatos(int id_clase, int id_estudiante){
        Query q = em.createNativeQuery("select ec.id from estudiante_clase ec where ec.clase_id = ?1 and ec.estudiante_id=?2");
        q.setParameter(1, id_clase);
        q.setParameter(2, id_estudiante);
        Object obj = (Object) q.getSingleResult();
        return Integer.parseInt(String.valueOf(obj));
    }
}
