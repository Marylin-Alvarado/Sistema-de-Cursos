/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.listas.ListaEnlazada;

/**
 *
 * @author SONY VAIO
 */
public class Alumno extends Persona {
    private Integer idAlumno;
    private Integer numMaterias;
    private String asistencia;
    private ListaEnlazada<Matricula> matriculas;
    public Alumno(){
        
    }
    
    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public ListaEnlazada<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(ListaEnlazada<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    

    public Integer getNumMaterias() {
        return numMaterias;
    }

    public void setNumMaterias(Integer numMaterias) {
        this.numMaterias = numMaterias;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }
    
    
}
