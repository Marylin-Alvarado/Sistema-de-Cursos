/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Asignatura;
import modelo.Ciclo;
/**
 *
 * @author TecnoeXtrem
 */
public class CicloController {
    ListaEnlazada<Ciclo> cicloList;
    Ciclo ciclo;
    ListaEnlazada<Asignatura> asignaturaList;
    Asignatura asignatura;

    public CicloController(){
        cicloList = new ListaEnlazada<>();
        asignaturaList = new ListaEnlazada<>();
    }
    public ListaEnlazada<Ciclo> getCicloList() {
        return cicloList;
    }

    public void setCicloList(ListaEnlazada<Ciclo> cicloList) {
        this.cicloList = cicloList;
    }

    public Ciclo getCiclo() {
        if(ciclo == null){
            ciclo = new Ciclo();
        }
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public ListaEnlazada<Asignatura> getAsignaturaList() {
        return asignaturaList;
    }

    public void setAsignaturaList(ListaEnlazada<Asignatura> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    
    
}
