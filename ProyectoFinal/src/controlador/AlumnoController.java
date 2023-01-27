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

    public ListaEnlazada<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(ListaEnlazada<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }
    
    
   
}