/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package curso;

import controlador.CursaController;
import modelo.Asignatura;
import modelo.Cursa;
import modelo.Matricula;

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
        asi1.setNumeroHoras(120);
        ma1.setIdMatricula(1);
        
        asi1.setId(1);
        Cursa cu1 = new Cursa();
        cu1.setHorasAsistidas(99);
        cu1.setAsignatura(asi1);
        cu1.setMatricula(ma1);
        cc.setCursa(cu1);
        cc.porcentajeHorasAsistidas();
        
        System.out.println(cu1);
        ma1.getCursa().insertar(cu1);
        ma1.getCursa().imprimir();
        
    }
    
}
