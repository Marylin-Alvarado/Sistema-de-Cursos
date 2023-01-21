/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Cursa;
import modelo.Nota;
import modelo.enums.Estado;

/**
 *
 * @author David Campoverde
 */
public class CursaController {
    
    private ListaEnlazada<Cursa> cursa;
    
    public CursaController(){
        cursa = new ListaEnlazada<>();
    }
    
    /**
     * Método para calcular el porcentaje de horas asistidas en una asignatura de una determinada matrícula
     */
    public void porcentajeHorasAsistidas(){
        for(int i = 0; i <= cursa.getSize();i++){
            try {
                Cursa cursaAux = cursa.obtener(i);
                cursaAux.setPorcentajeHorasAsistidas((cursaAux.getHorasAsistidas() * 100) / cursaAux.getAsignatura().getNumeroHoras());
            } catch (Exception e) {
            }
        }
    }
    
    /**
     * Método para calcular la nota final de una matrícula en determinada asignatura
     */
    public void calcularNotaFinal(){
        for(int i = 0; i <= cursa.getSize();i++){
            try {
                Cursa cursaAux = cursa.obtener(i);
                Nota nota = cursaAux.getNotaFinal();
                nota.setNotaTotal((nota.getAcompanamientoD() * 0.2f)+(nota.getTrabajoE() * 0.25f)+(nota.getAprendizajeA() *0.2f)+(nota.getEvaluacion() * 0.35f));
                determinarEstadoAsignatura(cursaAux);
            } catch (Exception e) {
            }
        }
    }
    
    /**
     * Método para determinar, en base la nota final, si una matrícula aprobó o no determinada asignatura
     * @param cursa 
     */
    private void determinarEstadoAsignatura(Cursa cursa){
        if (cursa.getNotaFinal().getNotaTotal() >= 7){
            cursa.setEstadoAsignatura(Estado.APROBADA);
        }else{
            cursa.setEstadoAsignatura(Estado.REPROBADA);
        }
    }

    public ListaEnlazada<Cursa> getCursa() {
        return cursa;
    }

    public void setCursa(ListaEnlazada<Cursa> cursa) {
        this.cursa = cursa;
    }
    
    
    
    
}
