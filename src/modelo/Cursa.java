/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Marylin
 */
public class Cursa extends Matricula{
    
    private Matricula matricula;
    private Asignatura asignatura;
    private Integer horasAsistidas;

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Integer getHorasAsistidas() {
        return horasAsistidas;
    }

    public void setHorasAsistidas(Integer horasAsistidas) {
        this.horasAsistidas = horasAsistidas;
    }
    
    
    
}
