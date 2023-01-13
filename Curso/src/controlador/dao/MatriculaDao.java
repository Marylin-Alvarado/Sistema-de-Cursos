/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import modelo.Matricula;

/**
 *
 * @author SONY VAIO
 */
public class MatriculaDao extends AdaptadorDao<Matricula>{
    private Matricula matricula;

    public MatriculaDao() {
        super(Matricula.class);
    }
    
    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    public boolean guardar() throws Exception {
        this.matricula.setIdMatricula(generarId());
        guardar(this.matricula);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.matricula, pos);
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
