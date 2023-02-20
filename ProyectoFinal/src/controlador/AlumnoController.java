/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Alumno;

/**
 * Controlador de Alumno
 * 
 * @author TecnoeXtrem
 */
public class AlumnoController {
    ListaEnlazada<Alumno> alumnoList = new ListaEnlazada<>();
    Alumno alumno = new Alumno();

    public ListaEnlazada<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(ListaEnlazada<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    /*
    Metodo ara generar un usaurio al momento de registrarse
    */
    public void generarUsuario(){
        getAlumno().getCuenta().setUsuario(getAlumno().getNombres() + "." + getAlumno().getApellidos());
    }
    /**
     * Metodo para generar constrasenia al momento de registrarse
     */
    public void generarContrasenia(){
        getAlumno().getCuenta().setContrasenia(getAlumno().getNombres() + "-" + getAlumno().getApellidos() + "password" );
    }
    
    
}
