/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.listas.ListaEnlazada;
import java.util.Date;
import modelo.enums.DescripcionPeriodo;

/**
 *
 * @author SONY VAIO
 */
class Matricula {
    private Integer id;
    private Date fechaEmision;
    private Periodo periodo;
    private Alumno alumno;
    private ListaEnlazada<Cursa> cursa;

    public Matricula(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public ListaEnlazada<Cursa> getCursa() {
        return cursa;
    }

    public void setCursa(ListaEnlazada<Cursa> cursa) {
        this.cursa = cursa;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    
}
