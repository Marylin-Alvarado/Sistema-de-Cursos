/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.enums.Unidades;

/**
 *
 * @author David Campoverde
 */
public class Unidad {
    private Unidades unidadNro;
    private Float aprendizajeA;
    private Float trabajoE;
    private Float acompanamientoD;
    private Float evaluacion;
    private Float notaUnidad;
    
    public void calcularNotaUnidad(){
        this.notaUnidad = ((this.acompanamientoD * 0.2f)+(this.trabajoE * 0.25f)+(this.aprendizajeA *0.2f)+(this.evaluacion * 0.35f));
    }

    public Float getAprendizajeA() {
        return aprendizajeA;
    }

    public void setAprendizajeA(Float aprendizajeA) {
        this.aprendizajeA = aprendizajeA;
    }

    public Float getTrabajoE() {
        return trabajoE;
    }

    public void setTrabajoE(Float trabajoE) {
        this.trabajoE = trabajoE;
    }

    public Float getAcompanamientoD() {
        return acompanamientoD;
    }

    public void setAcompanamientoD(Float acompanamientoD) {
        this.acompanamientoD = acompanamientoD;
    }

    public Float getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Float evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Float getNotaUnidad() {
        return notaUnidad;
    }

    public void setNotaUnidad(Float notaUnidad) {
        this.notaUnidad = notaUnidad;
    }

    public Unidades getUnidadNro() {
        return unidadNro;
    }

    public void setUnidadNro(Unidades unidadNro) {
        this.unidadNro = unidadNro;
    }

    @Override
    public String toString() {
        return unidadNro.toString();
    }
    
    
    
    
    
}
