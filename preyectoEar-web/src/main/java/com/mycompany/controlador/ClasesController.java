/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOEstudiante;
import com.mycompany.dto.DTOInfo;
import com.mycompany.interfaces.ClaseFacadeLocal;
import com.mycompany.entity.Clase;
import com.mycompany.entity.Estudiante;
import com.mycompany.interfaces.EstudianteFacadeLocal;
import com.mycompany.interfaces.InfoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.modelmapper.ModelMapper;

/**
 * Declaracion de la clase ClasesController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 20-10-19 1.0
 */
@Named
@ViewScoped
public class ClasesController implements Serializable {
    //Declaracion de los atributos privados de la Clase
    @Inject
    private BeanSesion sesion;

    private String clase;
    private int duracion;
    private double cedula;
    private String nombre;
    private List<Estudiante> listaEstudiantes;
    private int estudianteSeleccionado;
    private List<Clase> listaClases;
    private int claseSeleccionada;
    private List<DTOInfo> listaPorMaterias;
    private DTOEstudiante estudianteEliminar;
    private List<DTOInfo> listaInfo;
    //Implementacion de la Interface ClaseFacadeLocal del paquete interfaces del ejb
    @EJB
    ClaseFacadeLocal claseCon;
    //Implementacion de la Interface EstudianteFacadeLocal del paquete interfaces del ejb
    @EJB
    EstudianteFacadeLocal estudianteCon;
    //Implementacion de la Interface InfoFacadeLocal del paquete interfaces del ejb
    @EJB
    InfoFacadeLocal infoCon;

    /**
     * Creacion nueva instancia de ClasesController
     */
    //Constructor que convierte las listas en ArrayList
    public ClasesController() {
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
        Clase entClase = new Clase(clase, duracion);
        claseCon.create(entClase);
        obtenerClases();
        FacesMessage msg = new FacesMessage("Clase Agregada.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //Metodo para agregar nuevos estudiantes
    public void agregarEstudiante() {
        Estudiante entEstudiante = new Estudiante(cedula, nombre);
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
    //Metodos para obtener la lista de estudiantes completa
    public void obtenerListaEstCompleta(int idMateria) {
        listaPorMaterias = infoCon.obtenerEstudiantesConStore(idMateria);
    }
    //Metodo para asignar las clases a un estudiante
    public void asignarClase() {
        Clase entClase = claseCon.find(claseSeleccionada);
        Estudiante entEstudiante = estudianteCon.find(estudianteSeleccionado);
        entClase.getListaEstudiantes().add(entEstudiante);
        entEstudiante.getListaClases().add(entClase);
        estudianteCon.edit(entEstudiante);
        obtenerListaEstCompleta(claseSeleccionada);
        FacesMessage msg = new FacesMessage("Clase Asignada.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //Metodo para la realizacion del filtro por materias
    public void filtroEstudiantes(ValueChangeEvent event) {
        if (event.getNewValue() != "0") {
            listaEstudiantes = estudianteCon.filtro((int) event.getNewValue());
            obtenerListaEstCompleta((int) event.getNewValue());
        } else {
            obtenerEstudiantes();
            listaPorMaterias.clear();
        }
    }
    //Metodo para eliminar un curso ya agregado
    public void eliminarDelCurso() {
        Clase entClase = claseCon.find(claseSeleccionada);
        ModelMapper mp = new ModelMapper();
        Estudiante entEst = mp.map(estudianteEliminar, Estudiante.class);
        entClase.getListaEstudiantes().remove(entEst);
        entClase.setListaEstudiantes(entClase.getListaEstudiantes());
        entEst.setListaClases(entEst.getListaClases());
        estudianteCon.edit(entEst);
        //entEst.getListaClases().remove(entClase);
        //claseCon.edit(entClase);
        FacesContext faces = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado",
                "Estudiante eliminado del Curso");
        faces.addMessage(null, msg);
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

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(List<Clase> listaClases) {
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

}
