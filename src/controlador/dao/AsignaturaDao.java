/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.listas.excepciones.PosicionNoEncontradaException;
import modelo.Asignatura;

/**
 *
 * @author DEEPIN
 */
public class AsignaturaDao extends AdaptadorDao<Asignatura> {

    private Asignatura asignatura;

    public AsignaturaDao() {
        super(Asignatura.class);
    }

    public Asignatura getPersona() {
        if (asignatura == null){
            asignatura = new Asignatura();
        }
        return asignatura;
    }

    public void setPersona(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public boolean guardar() throws Exception {
        this.asignatura.setId(generarId());
        guardar(this.asignatura);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.asignatura, pos);
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
