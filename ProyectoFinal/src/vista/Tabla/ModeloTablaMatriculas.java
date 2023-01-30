/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Asignatura;
import modelo.Matricula;

/**
 *
 * @author TecnoeXtrem
 */
public class ModeloTablaMatriculas extends AbstractTableModel {

    private ListaEnlazada<Matricula> matriculaList = new ListaEnlazada<>();

    public ListaEnlazada<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(ListaEnlazada<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }
    
    
    @Override
    public int getRowCount() {
        return matriculaList.getSize();
    }

    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Alumno";
            case 2:
                return "Fecha de emision";
            case 3:
                return "Periodo";
            default:
                return null;
        }        
    }
    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Matricula m = null;
        try {
            m = matriculaList.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt : " + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (m != null) ? m.getAlumno() : "No definido";
            case 2:
                return (m != null) ? m.getFechaEmision() : "No definido";
            case 3:
                return (m != null) ? m.getPeriodo().getMesInicio() + "-" + m.getPeriodo().getMesFin() : "No definido";
            default:
                return null;
        }    
    }
    
}
