/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.listas.ListaEnlazada;
import java.util.Date;

/**
 *
 * @author SONY VAIO
 */
public class Matricula {
    private Integer idMatricula;
    private Date fechaEmision;
    private Periodo periodo;
    private Alumno alumno;
    
    private ListaEnlazada<Cursa> cursa;
    private Float promedioGeneral;

    public Matricula(){
        cursa = new ListaEnlazada<>();
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ListaEnlazada<Cursa> getCursa() {
        return cursa;
    }

    public void setCursa(ListaEnlazada<Cursa> cursa) {
        this.cursa = cursa;
    }

    public Float getPromedioGeneral() {
        return promedioGeneral;
    }

    public void setPromedioGeneral(Float promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    @Override
    public String toString() {
        return idMatricula.toString();
    }
    
    
    
    
}
