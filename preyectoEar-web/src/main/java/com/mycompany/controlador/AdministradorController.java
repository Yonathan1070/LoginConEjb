/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.entity.Departamento;
import com.mycompany.entity.Empleado;
import com.mycompany.entity.Inversor;
import com.mycompany.interfaces.DepartamentoFacadeLocal;
import com.mycompany.interfaces.EmpleadoFacadeLocal;
import com.mycompany.interfaces.InversorFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Declaracion de la Clase AdministradorController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 29-09-2019 1.0
 */
@Named
@RequestScoped
public class AdministradorController implements Serializable {
    
    @Inject
    private BeanSesion sesion;
    //implementacion de la Interface InversorFacadeLocal del paquete interfaces del ejb
    @EJB
    InversorFacadeLocal inversorCon;
    //Implementacion de la Interface DepartamentoFacadeLocal del paquete interfaces del ejb
    @EJB
    DepartamentoFacadeLocal depCon;
    //Implementacion de la Interface EmpleadoFacadeLocal del paquete interfaces del ejb
    @EJB
    EmpleadoFacadeLocal empCon;
    /**
     * Creacion nueva instancia AdministradorController
     */
    //Constructor vacio de la clase
    public AdministradorController() {
    }
    
    public void consultaJoin(){
        /*List<Inversor> listaInversores = new ArrayList();
        listaInversores = inversorCon.obtenerConJoin("Yonathan", "123456-AB");
        for (Inversor inv : listaInversores) {
            System.out.println("Nombre: "+inv.getNombre());
            if(inv.getCuenta()!= null){
                System.out.println("Cuenta: "+inv.getCuenta().getNumeroCuenta());
            }
            System.out.println("--------------------------------------------");
        }*/
    }
    //Metodo donde se Crea el Departamento
    public void crearDepartamento(){
        Departamento dep = new Departamento("Talento Humano", null);
        depCon.create(dep);
    }
    //Metodo donde se Crea el Cliente
    public void crearCliente(){
        Departamento depto = depCon.find(1);
        Empleado emp1 = new Empleado("Yonathan", 22, depto);
        Empleado emp2 = new Empleado("Maria", 48, depto);
        
        depto.getListaEmpleados().add(emp1);
        depto.getListaEmpleados().add(emp2);
        
        depCon.edit(depto);
    }
    //get y set de la variable privada de la clase
    public BeanSesion getSesion() {
        return sesion;
    }

    public void setSesion(BeanSesion sesion) {
        this.sesion = sesion;
    }
    
    
    
    
}
