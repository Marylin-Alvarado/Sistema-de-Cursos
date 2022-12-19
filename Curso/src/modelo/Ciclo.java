/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.listas.ListaEnlazada;

/**
 *
 * @author SONY VAIO
 */
class Ciclo {
    private Integer id;
    private String nombre;
    private ListaEnlazada<Asignatura> asignaturas;

    public Ciclo(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazada<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ListaEnlazada<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    
}
