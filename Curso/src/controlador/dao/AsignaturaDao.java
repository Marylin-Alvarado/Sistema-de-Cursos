/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.Asignatura;

/**
 *
 * @author SONY VAIO
 */
public class AsignaturaDao extends AdaptadorDao<Asignatura>{
    private Asignatura asignatura;

    public AsignaturaDao() {
        super(Asignatura.class);
    }

    
    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
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
