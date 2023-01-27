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
import modelo.Nota;

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
        Asignatura asi2 = new Asignatura();
        Matricula ma1 = new Matricula();
        MatriculaController mc = new MatriculaController();
        Nota n1 = new Nota();
        Nota n2 = new Nota();
        Cursa cu1 = new Cursa();
        Cursa cu2 = new Cursa();
        asi1.setNumeroHoras(120);
        asi2.setNumeroHoras(100);
        ma1.setIdMatricula(1);
        n2.setNotaTotal(5f);
        cu2.setNotaFinal(n2);
        asi1.setId(1);
        cu2.setHorasAsistidas(50);
        cu1.setHorasAsistidas(100);
        cu1.setAsignatura(asi1);
        cu1.setMatricula(ma1);
        asi2.setId(2);
        cu1.setNotaFinal(n1);
        
        n1.setAcompanamientoD(10f);
        n1.setAprendizajeA(10f);
        n1.setEvaluacion(10f);
        n1.setTrabajoE(10f);
        cc.getCursaList().insertar(cu1);
        cc.getCursaList().insertar(cu2);
        ma1.getCursa().insertar(cu2);
        cu2.setAsignatura(asi2);
        cu2.setMatricula(ma1);
        
        n1.calcularNota();
        ma1.getCursa().insertar(cu1);
        ma1.getCursa().imprimir();
        cc.porcentajeHorasAsistidas();
        cc.porcentajeHorasAsistidas();
        System.out.println(cu1.getPorcentajeHorasAsistidas()+"%");
        System.out.println(cu2.getPorcentajeHorasAsistidas()+"%");
        System.out.println(cu1.getNotaFinal().getNotaTotal());
        
        mc.setMatricula(ma1);
        mc.calcularPromedioGeneral();
        System.out.println(ma1.getPromedioGeneral());
        
    }
    
}
