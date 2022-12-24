/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author DEEPIN
 */
public class Ciclo {
    private Integer id;
    private String nombre;
    private List<Asignatura> asignatura;

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

    public List<Asignatura> getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(List<Asignatura> asignatura) {
        this.asignatura = asignatura;
    }

    
    
    
}
