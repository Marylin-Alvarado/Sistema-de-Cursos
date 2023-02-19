/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Nota;

/**
 *
 * @author TecnoeXtrem
 */
public class NotaController {
    private Nota nota;
    private ListaEnlazada<Nota> notaList = new ListaEnlazada<>();

    public Nota getNota() {
        if(nota == null){
            nota = new Nota();
        }
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public ListaEnlazada<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(ListaEnlazada<Nota> notaList) {
        this.notaList = notaList;
    }
    
    
}
