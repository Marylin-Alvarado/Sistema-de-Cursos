/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Alumno;

/**
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
   
}
