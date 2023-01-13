/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package curso;

import controlador.CursaController;
import controlador.MatriculaController;
import modelo.Asignatura;
import modelo.Cursa;
import modelo.Matricula;
import modelo.Unidad;
import modelo.enums.Unidades;

/**
 *
 * @author SONY VAIO
 */
public class Curso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CursaController cc = new CursaController();
        Asignatura asi1 = new Asignatura();
        Matricula ma1 = new Matricula();
        Unidad uni1 = new Unidad();
        Unidad uni2 = new Unidad();
        Unidad uni3 = new Unidad();
        MatriculaController mc = new MatriculaController();
        asi1.setNumeroHoras(120);
        ma1.setIdMatricula(1);
        uni1.setUnidadNro(Unidades.I);
        
        asi1.setId(1);
        Cursa cu1 = new Cursa();
        cu1.setHorasAsistidas(99);
        cu1.setAsignatura(asi1);
        cu1.setMatricula(ma1);
        cc.setCursa(cu1);
        cu1.getUnidades().insertar(uni1);
        cu1.getUnidades().insertar(uni2);
        cu1.getUnidades().insertar(uni3);
        cc.porcentajeHorasAsistidas();
        uni1.setAcompanamientoD(9f);
        uni1.setAprendizajeA(9.5f);
        uni1.setTrabajoE(7.8f);
        uni1.setEvaluacion(5f);
        
        uni2.setAcompanamientoD(8f);
        uni2.setAprendizajeA(10f);
        uni2.setTrabajoE(9.6f);
        uni2.setEvaluacion(7.5f);
        
        uni3.setAcompanamientoD(9.5f);
        uni3.setAprendizajeA(10f);
        uni3.setTrabajoE(8f);
        uni3.setEvaluacion(7f);
        
        
        ma1.getCursa().insertar(cu1);
        ma1.getCursa().imprimir();
        uni1.calcularNotaUnidad();
        uni2.calcularNotaUnidad();
        uni3.calcularNotaUnidad();
        cc.calcularNotaFinal();
        System.out.println(uni1.getNotaUnidad()+"\n"+uni2.getNotaUnidad()+"\n"+uni3.getNotaUnidad());
        System.out.println(cu1.getNotaFinal());
        
        mc.setMatricula(ma1);
        mc.calcularPromedioGeneral();
        System.out.println("\n\n"+ma1.getPromedioGeneral());
        
    }
    
}
