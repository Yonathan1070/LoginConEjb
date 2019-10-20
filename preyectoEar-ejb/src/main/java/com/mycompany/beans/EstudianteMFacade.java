/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.EstudianteMFacadeLocal;
import com.mycompany.entity.EstudianteM;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Admin
 */
@Stateless
public class EstudianteMFacade extends AbstractFacade<EstudianteM> implements EstudianteMFacadeLocal {
    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteMFacade() {
        super(EstudianteM.class);
    }
    
    @Override
    public List<EstudianteM> filtro(int id_clase) {
        List<EstudianteM> listaCompleta = findAll();
        //TypedQuery<EstudianteM> consulta = em.createNamedQuery("consulta", EstudianteM.class);
        //consulta.setParameter("id_clase", id_clase);
        Query q = em.createNativeQuery("select e.* from estudiante e join estudiante_clase ec on ec.estudiante_id = e.id join clase c on c.id = ec.clase_id where c.id = ?1");
        q.setParameter(1, id_clase);
        List<EstudianteM> listaPorMaterias = q.getResultList();
        List<EstudianteM> listaTemp = new ArrayList();
        Iterator itr = listaPorMaterias.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            EstudianteM est = find(Integer.parseInt(String.valueOf(obj[0])));
            listaTemp.add(est);
        }
        List<EstudianteM> lisTemporal = new ArrayList();
        if (listaCompleta.size() > listaTemp.size()) {
            for (EstudianteM general : listaCompleta) {
                if (!listaTemp.contains(general)) {
                    lisTemporal.add(general);
                }
            }
        } else {
            for (EstudianteM xMaterias : listaTemp) {
                if (!listaCompleta.contains(xMaterias)) {
                    lisTemporal.add(xMaterias);
                }
            }
        }
        return lisTemporal;
    }
    
}
