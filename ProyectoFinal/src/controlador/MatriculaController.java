/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Matricula;


/**
 *
 * @author David Campoverde
 */
public class MatriculaController {
    private Matricula matricula;
    
    public void calcularPromedioGeneral(){
        Float aux = 0f;
        for(int i = 0; i < matricula.getCursa().getSize(); i++){
            try {
                aux = aux + matricula.getCursa().obtener(i).getNotaFinal().getNotaTotal();
            } catch (Exception e) {
//                System.out.println(e.getMessage());
            }
        }
        matricula.setPromedioGeneral(aux/matricula.getCursa().getSize());
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
    
}
