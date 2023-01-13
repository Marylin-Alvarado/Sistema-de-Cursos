/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.Alumno;

/**
 *
 * @author SONY VAIO
 */
public class AlumnoDao extends AdaptadorDao<Alumno> {
    private Alumno alumno;

    public AlumnoDao(){
        super(Alumno.class);
    }
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    public boolean guardar() throws Exception {
        this.alumno.setIdAlumno(generarId());
        guardar(this.alumno);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.alumno, pos);
        return true;
    }
    
    
//    public boolean modificar(E dato, Integer pos) throws Exception{
//        try {
//            lista.modificarDato(pos, dato);
//            return true;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return false;
//    }
    
    private Integer generarId(){
        return listar().getSize()+1;
    }
    
}
