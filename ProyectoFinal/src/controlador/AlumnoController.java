/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Alumno;

/**
 *
 * @author Marylin
 */
public class AlumnoController {
    private ListaEnlazada<Alumno> alumnoList;
    private Alumno alumno;

    
    
    
    public ListaEnlazada<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(ListaEnlazada<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public Alumno getAlumno() {
        if(alumno == null){
            alumno = new Alumno();
        }
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
}
