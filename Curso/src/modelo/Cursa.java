package modelo;

import controlador.listas.ListaEnlazada;

/**
 *
 * @author SONY VAIO
 */
public class Cursa {
    private Matricula matricula;
    private Asignatura asignatura;
    private Integer horasAsistidas;
    private Float notaFinal;
    private ListaEnlazada<Unidad> unidades;
    
    public Cursa(){
        unidades = new ListaEnlazada<>();
    }

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

    public Float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public ListaEnlazada<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(ListaEnlazada<Unidad> unidades) {
        this.unidades = unidades;
    }
    
    @Override
    public String toString() {
        return "Asignatura: "+asignatura+" - HorasAsistidas: " +horasAsistidas+ " - Matricula: " + matricula;
    }
    
    
    
}
