/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Matricula;


/**
 *
 * @author David Campoverde
 */
public class MatriculaController {
    private Matricula matricula;
    private ListaEnlazada<Matricula> matriculaList = new ListaEnlazada<>();
    /**
     * Método para calcular el promedio general de todas las asignaturas de una matrícula
     */
    
    public void calcularPromedioGeneral(){
        Float aux = 0f;
        for(int i = 0; i < matricula.getCursa().getSize(); i++){
            try {
                aux = aux + matricula.getCursa().obtener(i).getNotaFinal().getNotaTotal();
            } catch (Exception e) {
            }
        }
        matricula.setPromedioGeneral(aux/matricula.getCursa().getSize());
    }

    public Matricula getMatricula() {
        if(matricula == null){
            matricula = new Matricula();
        }
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public ListaEnlazada<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(ListaEnlazada<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }
    
    
    
    
}

