/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.listas.ListaEnlazada;
import modelo.enums.Estado;

/**
 *
 * @author SONY VAIO
 */
public class Cursa {
    private Matricula matricula;
    private Asignatura asignatura;
    private Integer horasAsistidas;
    private Nota notaFinal;
    private Integer porcentajeHorasAsistidas;
    private Estado estadoAsignatura;

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Integer getHorasAsistidas() {
        return horasAsistidas;
    }

    public void setHorasAsistidas(Integer horasAsistidas) {
        this.horasAsistidas = horasAsistidas;
    }

    public Nota getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Nota notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Integer getPorcentajeHorasAsistidas() {
        return porcentajeHorasAsistidas;
    }

    public void setPorcentajeHorasAsistidas(Integer porcentajeHorasAsistidas) {
        this.porcentajeHorasAsistidas = porcentajeHorasAsistidas;
    }

    public Estado getEstadoAsignatura() {
        return estadoAsignatura;
    }

    public void setEstadoAsignatura(Estado estadoAsignatura) {
        this.estadoAsignatura = estadoAsignatura;
    }
    
    @Override
    public String toString() {
        return "Asignatura: "+asignatura+" - HorasAsistidas: " +horasAsistidas+ " - Matricula: " + matricula;
    }
    
    
    
}
