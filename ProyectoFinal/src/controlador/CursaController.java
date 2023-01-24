/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Cursa;

/**
 *
 * @author David Campoverde
 */
public class CursaController {
    private ListaEnlazada<Cursa> cursa;
    
    public CursaController(){
        cursa = new ListaEnlazada<>();
    }
    
    public void porcentajeHorasAsistidas(){
        for(int i = 0; i <= cursa.getSize();i++){
            try {
                Cursa cursaAux = cursa.obtener(i);
                cursaAux.setPorcentajeHorasAsistidas((cursaAux.getHorasAsistidas() * 100) / cursaAux.getAsignatura().getNumeroHoras());
            } catch (Exception e) {
            }
        }
//        cursa.setPorcentajeHorasAsistidas((cursa.getHorasAsistidas() * 100) / cursa.getAsignatura().getNumeroHoras());
    }

    public ListaEnlazada<Cursa> getCursa() {
        return cursa;
    }

    public void setCursa(ListaEnlazada<Cursa> cursa) {
        this.cursa = cursa;
    }
    
    
    
    
}
