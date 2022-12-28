/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.listas.excepciones.PosicionNoEncontradaException;
import modelo.Alumno;

/**
 *
 * @author DEEPIN
 */
public class AlumnoDao extends AdaptadorDao<Alumno> {

    private Alumno alumno;

    public AlumnoDao() {
        super(Alumno.class);
    }

    public Alumno getPersona() {
        if (alumno == null){
            alumno = new Alumno();
        }
        return alumno;
    }

    public void setPersona(Alumno alumno) {
        this.alumno = alumno;
    }

    public boolean guardar() throws Exception {
        this.alumno.setId(generarId());
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
