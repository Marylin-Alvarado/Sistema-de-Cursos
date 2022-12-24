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
    
    public void calcularNotaFinal(){
        Float aux = 0f;
        for (int i = 0; i < cursa.getUnidades().getSize();i++){
            try {
                aux = aux + cursa.getUnidades().obtener(i).getNotaUnidad();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        cursa.setNotaFinal((aux)/cursa.getUnidades().getSize());
    }
    
    public Cursa getCursa() {
        return cursa;
    }

    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }
    
    
}
