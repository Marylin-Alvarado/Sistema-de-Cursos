/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Periodo;

/**
 *
 * @author TecnoeXtrem
 */
public class PeriodoController {
    private Periodo periodo;
    private ListaEnlazada<Periodo> periodoList = new ListaEnlazada<>();

    public Periodo getPeriodo() {
        if(periodo == null){
            periodo = new Periodo();
        }
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public ListaEnlazada<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(ListaEnlazada<Periodo> periodoList) {
        this.periodoList = periodoList;
    }
    
    
}
