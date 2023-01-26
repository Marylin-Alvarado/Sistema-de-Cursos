/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.listas.ListaEnlazada;

/**
 *
 * @author David Campoverde
 */
public class Docente extends Persona {
    private Integer idDocente;
    private String tituloTercerNivel;
    private String tituloCuartoNivel;
    private Integer aniosExpDocente;
    private Integer aniosExpLaboral;
    private ListaEnlazada<Asignatura> asignaturas;

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getTituloTercerNivel() {
        return tituloTercerNivel;
    }

    public void setTituloTercerNivel(String tituloTercerNivel) {
        this.tituloTercerNivel = tituloTercerNivel;
    }

    public String getTituloCuartoNivel() {
        return tituloCuartoNivel;
    }

    public void setTituloCuartoNivel(String tituloCuartoNivel) {
        this.tituloCuartoNivel = tituloCuartoNivel;
    }


    public Integer getAniosExpDocente() {
        return aniosExpDocente;
    }

    public void setAniosExpDocente(Integer aniosExpDocente) {
        this.aniosExpDocente = aniosExpDocente;
    }

    public Integer getAniosExpLaboral() {
        return aniosExpLaboral;
    }

    public void setAniosExpLaboral(Integer aniosExpLaboral) {
        this.aniosExpLaboral = aniosExpLaboral;
    }

    @Override
    public String toString() {
        return getNombres() + " " + getApellidos();
    }
    
    
    
    
}
