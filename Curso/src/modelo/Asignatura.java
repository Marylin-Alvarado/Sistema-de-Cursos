/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.listas.ListaEnlazada;
import modelo.enums.Estado;
import modelo.enums.Unidades;

/**
 *
 * @author SONY VAIO
 */
public class Asignatura {
    private Integer id;
    private Character paralelo;
    private String unidad;
    private Docente docente;
    private Cursa cursa;
    private Estado estadoAsignatura;
    private Integer numeroHoras;
    private Float notaFinal;
    private ListaEnlazada<Unidad> unidades; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getParalelo() {
        return paralelo;
    }

    public void setParalelo(Character paralelo) {
        this.paralelo = paralelo;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    public Cursa getCursa() {
        return cursa;
    }

    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }

    public Estado getEstadoAsignatura() {
        return estadoAsignatura;
    }

    public void setEstadoAsignatura(Estado estadoAsignatura) {
        this.estadoAsignatura = estadoAsignatura;
    }

    public Integer getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(Integer numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public Float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public ListaEnlazada<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(ListaEnlazada<Unidad> unidades) {
        this.unidades = unidades;
    }
    
    
    
    
}
