/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Marylin
 */
public class Docente extends Persona{
    private Integer id;
    private String tituloTercerNivel;
    private String tituloCuartoNivel;
    private List<Asignatura> asignatura;
    private Integer aniosExpDocente;
    private Integer aniosExpLaboral;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Asignatura> getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(List<Asignatura> asignatura) {
        this.asignatura = asignatura;
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
    
    
    
}
