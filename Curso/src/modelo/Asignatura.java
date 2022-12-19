/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.listas.ListaEnlazada;
import modelo.enums.Unidades;

/**
 *
 * @author SONY VAIO
 */
public class Asignatura {
    private Integer id;
    private Unidades unidad;
    private String paralelo;
    private Docente docente;
    private ListaEnlazada<Cursa> cursa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ListaEnlazada<Cursa> getCursa() {
        return cursa;
    }

    public void setCursa(ListaEnlazada<Cursa> cursa) {
        this.cursa = cursa;
    }
    
    

    public Unidades getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidades unidad) {
        this.unidad = unidad;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    
}
