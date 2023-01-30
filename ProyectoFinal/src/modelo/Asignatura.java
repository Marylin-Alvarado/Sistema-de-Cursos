/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.listas.ListaEnlazada;
import modelo.enums.Estado;

/**
 *
 * @author Jhair Agila
 */
public class Asignatura {
    private Integer id;
    private String nombre;
    private Character paralelo;
    private String unidad;
    private Docente docente;
    private Cursa cursa;
    private Integer numeroHoras;
    
    public Asignatura(){
        
    }
    public Asignatura(String nombre, Estado estado, Integer numHoras){
        this.nombre = nombre;
        this.numeroHoras = numHoras;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Integer getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(Integer numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
}
