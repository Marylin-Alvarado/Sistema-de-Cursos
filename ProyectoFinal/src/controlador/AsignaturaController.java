/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Asignatura;
import modelo.enums.Estado;

/**
 *
 * @author TecnoeXtrem
 */
public class AsignaturaController {
    private ListaEnlazada<Asignatura> asignatursList;
    private Asignatura asignatura;

    public AsignaturaController(){
        asignatursList = new ListaEnlazada<>();
    }

    public Asignatura getAsignatura() {
        if(asignatura == null){
            asignatura = new Asignatura();
        }
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    
    
    public ListaEnlazada<Asignatura> getAsignatursList() {
        return asignatursList;
    }

    public void setAsignatursList(ListaEnlazada<Asignatura> asignatursList) {
        this.asignatursList = asignatursList;
    }
    
    public void generarId(){
        
    }
    
    
}
