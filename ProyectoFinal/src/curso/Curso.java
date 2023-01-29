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
import vista.Utilidades.Utilidades;

/**
 *
 * @author SONY VAIO
 */
public class Curso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < Utilidades.listarCuentas().getSize(); i++) {
            try {
                System.out.println(Utilidades.listarCuentas().obtener(i).getTipoUser());
            } catch (Exception e) {
            }
        }
        
    }
    
}
