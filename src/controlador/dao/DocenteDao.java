/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.listas.excepciones.PosicionNoEncontradaException;
import modelo.Docente;

/**
 *
 * @author DEEPIN
 */
public class DocenteDao extends AdaptadorDao<Docente> {

    private Docente docente;

    public DocenteDao() {
        super(Docente.class);
    }

    public Docente getPersona() {
        if (docente == null){
            docente = new Docente();
        }
        return docente;
    }

    public void setPersona(Docente persona) {
        this.docente = persona;
    }

    public boolean guardar() throws Exception {
        this.docente.setId(generarId());
        guardar(this.docente);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.docente, pos);
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
