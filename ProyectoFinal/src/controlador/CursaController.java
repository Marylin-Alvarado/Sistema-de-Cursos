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

    private ListaEnlazada<Cursa> cursaList = new ListaEnlazada<>();
    private Cursa cursa;

    public Cursa getCursa() {
        return cursa;
    }

    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }

    public CursaController() {
        cursaList = new ListaEnlazada<>();
    }

    /**
     * Método para calcular el porcentaje de horas asistidas en una asignatura
     * de una determinada matrícula
     */
    public void calcularPorcentajeHorasAsistidas() {
//        for (int i = 0; i <= cursaList.getSize(); i++) {
        try {
//                Cursa cursaAux = cursaList.obtener(i);
//            cursaAux.setPorcentajeHorasAsistidas((cursaAux.getHorasAsistidas() * 100) / cursaAux.getAsignatura().getNumeroHoras());
            cursa.setPorcentajeHorasAsistidas((cursa.getHorasAsistidas()*100) / cursa.getAsignatura().getNumeroHoras());
            System.out.println("porcentaje de siscencia en controler" + cursa.getPorcentajeHorasAsistidas());
            
        } catch (Exception e) {
        }
//        }
    }

    /**
     * Método para calcular la nota final de una matrícula en determinada
     * asignatura
     *
     * @param nota
     */
    public void calcularNotaFinalPueba() {
        for (int i = 0; i <= cursaList.getSize(); i++) {
            try {
                Cursa cursaAux = cursaList.obtener(i);
                Nota nota = cursaAux.getNotaFinal();
                nota.setNotaTotal((nota.getAcompanamientoD() * 0.2f) + (nota.getTrabajoE() * 0.25f) + (nota.getAprendizajeA() * 0.2f) + (nota.getEvaluacion() * 0.35f));
                cursaList.obtener(i).getNotaFinal().setNotaTotal((float) 7.0);

                cursaList.obtener(i).setEstadoAsignatura(determinarEstadoAsignaturaObjeto(cursaList.obtener(i)));

            } catch (Exception e) {
            }
        }
    }

    public void calcularNotaFinal(Nota nota) {
        try {
            nota.setNotaTotal((nota.getAcompanamientoD() * 0.2f) + (nota.getTrabajoE() * 0.25f) + (nota.getAprendizajeA() * 0.2f) + (nota.getEvaluacion() * 0.35f));
            cursaList.obtener(0).setNotaFinal(nota);
            cursaList.obtener(0).setEstadoAsignatura(determinarEstadoAsignaturaObjeto(cursaList.obtener(0)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para determinar, en base la nota final, si una matrícula aprobó o
     * no determinada asignatura
     *
     * @param cursa
     */
    public void determinarEstadoAsignatura(Cursa cursa) {
        if (cursa.getNotaFinal().getNotaTotal() >= 7) {
            cursa.setEstadoAsignatura(Estado.APROBADA);
        } else {
            cursa.setEstadoAsignatura(Estado.REPROBADA);
        }
    }

    public Estado determinarEstadoAsignaturaObjeto(Cursa cursa) {
        if (cursa.getNotaFinal().getNotaTotal() >= 7) {
            return Estado.APROBADA;
        } else {
            return Estado.REPROBADA;
        }
    }

    public ListaEnlazada<Cursa> getCursaList() {
        return cursaList;
    }

    public void setCursaList(ListaEnlazada<Cursa> cursaList) {
        this.cursaList = cursaList;
    }

}
