/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DEEPIN
 */
public class Matricula {
    
    private Integer id;
    private Date fechaEmision;
    private Periodo periodo;
    private Alumno alumno;
    private List<Cursa> cursa;
    private Integer numeroMaterias;
    private String estado;

    public Integer getId() {
        return id;
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

    public List<Cursa> getCursa() {
        return cursa;
    }

    public void setCursa(List<Cursa> cursa) {
        this.cursa = cursa;
    }

    public Integer getNumeroMaterias() {
        return numeroMaterias;
    }

    public void setNumeroMaterias(Integer numeroMaterias) {
        this.numeroMaterias = numeroMaterias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
   

   
}
