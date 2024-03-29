/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOEstudiante;
import com.mycompany.dto.DTOInfo;
import com.mycompany.entity.ClaseM;
import com.mycompany.entity.EstudianteClase;
import com.mycompany.entity.EstudianteM;
import com.mycompany.entity.Info;
import com.mycompany.interfaces.ClaseMFacadeLocal;
import com.mycompany.interfaces.EstudianteClaseFacadeLocal;
import com.mycompany.interfaces.EstudianteMFacadeLocal;
import com.mycompany.interfaces.InfoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 * Declaracion de la clase ClasesController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
@Named
@ViewScoped
public class ClasesManyController implements Serializable {
    //Declaracion de los atributos privados de la Clase
    @Inject
    private BeanSesion sesion;

    private String clase;
    private int duracion;
    private double cedula;
    private String nombre;
    private List<EstudianteM> listaEstudiantes;
    private int estudianteSeleccionado;
    private List<ClaseM> listaClases;
    private int claseSeleccionada;
    private List<DTOInfo> listaPorMaterias;
    private DTOEstudiante estudianteEliminar;
    private List<DTOInfo> listaInfo;
    private String nota;
    //Implementacion de la Interface ClaseMFacadeLocal del paquete interfaces del ejb
    @EJB
    ClaseMFacadeLocal claseCon;
    //Implementacion de la Interface EstudianteMFacadeLocal del paquete interfaces del ejb
    @EJB
    EstudianteMFacadeLocal estudianteCon;
    //Implementacion de la Interface InfoFacadeLocal del paquete interfaces del ejb
    @EJB
    InfoFacadeLocal infoCon;
    //Implementacion de la Interface EstudianteClaseFacadeLocal del paquete interfaces del ejb
    @EJB
    EstudianteClaseFacadeLocal ecCon;
    //Constructor que convierte las listas en ArrayList
    public ClasesManyController() {
        listaClases = new ArrayList();
        listaEstudiantes = new ArrayList();
        listaInfo = new ArrayList();
    }
    //Metodo de Inicializacion del bean
    @PostConstruct
    public void _ini() {
        listaEstudiantes = estudianteCon.findAll();
        listaClases = claseCon.findAll();
        listaPorMaterias = new ArrayList();
        listaInfo = infoCon.obtenerEstudiantesConStore(duracion);
    }
    //Metodo para agregar nuevas clases
    public void agregarClase() {
        ClaseM entClase = new ClaseM(clase, duracion);
        claseCon.create(entClase);
        obtenerClases();
        FacesMessage msg = new FacesMessage("Clase Agregada.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //Metodo para agregar nuevos estudiantes
    public void agregarEstudiante() {
        EstudianteM entEstudiante = new EstudianteM(cedula, nombre);
        estudianteCon.create(entEstudiante);
        obtenerEstudiantes();
        FacesMessage msg = new FacesMessage("Estudiante Agregado.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //Metodo para obtener las clases agregadas
    public void obtenerClases() {
        listaClases = claseCon.findAll();
    }
    //Metodo para obtener los estudiantes agregados
    public void obtenerEstudiantes() {
        listaEstudiantes = estudianteCon.findAll();
    }
    //Metodo que filtra a los estudiantes por materias
    public void filtroEstudiantes(ValueChangeEvent event) {
        if (event.getNewValue() != "0") {
            listaEstudiantes = estudianteCon.filtro((int) event.getNewValue());
            obtenerListaEstCompleta((int) event.getNewValue());
        } else {
            obtenerEstudiantes();
            listaPorMaterias.clear();
        }
    }
    //Metodo que obtiene la lista completa de estudiantes
    public void obtenerListaEstCompleta(int idMateria) {
        listaPorMaterias = infoCon.obtenerEstudiantesConStore(idMateria);
    }
    //Metodo para asignar una clase a un estudiante
    public void asignarClase() {
        ClaseM entClase = claseCon.find(claseSeleccionada);
        EstudianteM entEstudiante = estudianteCon.find(estudianteSeleccionado);
        /*EstudianteClase entEC = new EstudianteClase(entClase, entEstudiante, "-.-");
         entClase.getListaEstudiantes().add(entEC);
         entEstudiante.getListaClases().add(entEC);
         estudianteCon.edit(entEstudiante);*/
        EstudianteClase entEC = new EstudianteClase(entClase, entEstudiante, "-.-");
        ecCon.create(entEC);
        obtenerListaEstCompleta(claseSeleccionada);
        FacesMessage msg = new FacesMessage("Clase Asignada.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //Metodo de edicion
    public void onRowEdit(RowEditEvent event) {
        EstudianteM estudiante = estudianteCon.find(((DTOInfo) event.getObject()).getIdEstudiante());
        ClaseM clase = claseCon.find(claseSeleccionada);
        int id = ecCon.obtenerDatos(clase.getId(), estudiante.getId());
        EstudianteClase datos = ecCon.find(id);
        if (datos!=null) {
            datos.setNota(nota);
            ecCon.edit(datos);
        }
        obtenerListaEstCompleta(claseSeleccionada);
        FacesMessage msg = new FacesMessage("Nota Asignada", ((DTOInfo) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //Metodo de cancelacion
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Operación cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //getter y setter de los atributos de la clase
    public BeanSesion getSesion() {
        return sesion;
    }

    public void setSesion(BeanSesion sesion) {
        this.sesion = sesion;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EstudianteM> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<EstudianteM> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<ClaseM> getListaClases() {
        return listaClases;
    }

    public void setListaClases(List<ClaseM> listaClases) {
        this.listaClases = listaClases;
    }

    public int getEstudianteSeleccionado() {
        return estudianteSeleccionado;
    }

    public void setEstudianteSeleccionado(int estudianteSeleccionado) {
        this.estudianteSeleccionado = estudianteSeleccionado;
    }

    public int getClaseSeleccionada() {
        return claseSeleccionada;
    }

    public void setClaseSeleccionada(int claseSeleccionada) {
        this.claseSeleccionada = claseSeleccionada;
    }

    public List<DTOInfo> getListaPorMaterias() {
        return listaPorMaterias;
    }

    public void setListaPorMaterias(List<DTOInfo> listaPorMaterias) {
        this.listaPorMaterias = listaPorMaterias;
    }

    public DTOEstudiante getEstudianteEliminar() {
        return estudianteEliminar;
    }

    public void setEstudianteEliminar(DTOEstudiante estudianteEliminar) {
        this.estudianteEliminar = estudianteEliminar;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

}
