/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.listas.excepciones.PosicionNoEncontradaException;
import modelo.Cursa;

/**
 *
 * @author DEEPIN
 */
public class AsistenciaDao extends AdaptadorDao<Cursa> {

    private Cursa asistencia;

    public AsistenciaDao() {
        super(Cursa.class);
    }

    public Cursa getPersona() {
        if (asistencia == null){
            asistencia = new Cursa();
        }
        return asistencia;
    }

    public void setPersona(Cursa asistencia) {
        this.asistencia = asistencia;
    }

    public boolean guardar() throws Exception {
        this.asistencia.setId(generarId());
        guardar(this.asistencia);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.asistencia, pos);
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
