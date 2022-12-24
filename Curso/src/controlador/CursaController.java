/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Cursa;

/**
 *
 * @author David Campoverde
 */
public class CursaController {
    private Cursa cursa;
    
    public void porcentajeHorasAsistidas(){
        cursa.getMatricula().setPorcentajeHorasAsistidas((cursa.getHorasAsistidas() * 100) / cursa.getAsignatura().getNumeroHoras());
    }
    
    public Cursa getCursa() {
        return cursa;
    }

    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }
    
    
}
