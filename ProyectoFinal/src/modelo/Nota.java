/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author David Campoverde
 */
public class Nota {
    private Float aprendizajeA;
    private Float trabajoE;
    private Float acompanamientoD;
    private Float evaluacion;
    private Float notaTotal;
    
    public void calcularNota(){
        this.notaTotal = ((this.acompanamientoD * 0.2f)+(this.trabajoE * 0.25f)+(this.aprendizajeA *0.2f)+(this.evaluacion * 0.35f));
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

    public Float getNotaTotal() {
        return notaTotal;
    }

    public void setNotaTotal(Float notaTotal) {
        this.notaTotal = notaTotal;
    }
    
    
}
