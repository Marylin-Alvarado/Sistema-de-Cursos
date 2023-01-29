/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Docente;

/**
 *
 * @author Victor
 */
public class DocentesController {
    private Docente docente;
    private ListaEnlazada<Docente> docenteList;

    public Docente getDocente() {
        if(docente == null){
            docente = new Docente();
        }
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public ListaEnlazada<Docente> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(ListaEnlazada<Docente> docenteList) {
        this.docenteList = docenteList;
    }
    
    
}
