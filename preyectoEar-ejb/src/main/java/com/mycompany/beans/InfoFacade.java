/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOInfo;
import com.mycompany.interfaces.InfoFacadeLocal;
import com.mycompany.entity.Info;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 * Declaracion InfoFcade
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
@Stateless
public class InfoFacade extends AbstractFacade<Info> implements InfoFacadeLocal {

    @PersistenceContext(unitName = "linea_UN")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InfoFacade() {
        super(Info.class);
    }

    @Override
    //Metodo para obtener estudiantes filtrado por materia
    public List<DTOInfo> obtenerEstudiantesConStore(Integer id) {
        Query q = em.createNativeQuery("select c.id, c.nombre, e.id, e.cedula, e.nombre, ec.nota from estudiante e join estudiante_clase ec on ec.estudiante_id = e.id join clase c on c.id = ec.clase_id where c.id = ?1");
        q.setParameter(1, id);
        List<Info> listaEnt = (List<Info>) q.getResultList();
        List<Info> listaGeneral = new ArrayList();
        Iterator itr = listaEnt.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            Info inf = new Info(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]), Integer.parseInt(String.valueOf(obj[2])), Double.parseDouble(String.valueOf(obj[3])), String.valueOf(obj[4]), String.valueOf(obj[5]));
            listaGeneral.add(inf);
        }
        ModelMapper mp = new ModelMapper();
        Type listType = new TypeToken<List<DTOInfo>>() {}.getType();
        List<DTOInfo> listaDto = mp.map(listaGeneral, listType);
        return listaDto;
    }
}
