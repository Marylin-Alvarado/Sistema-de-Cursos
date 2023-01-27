/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Alumno;

/**
 *
 * @author TecnoeXtrem
 */
public class ModeloTablaCompanieroEstudiante extends AbstractTableModel{
    ListaEnlazada<Alumno> alumnoList = new ListaEnlazada<>();

    public ListaEnlazada<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(ListaEnlazada<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @Override
    public int getRowCount() {
        return alumnoList.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Nombres";
            case 2:
                return "Apellidos";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno a = null;
        try {
            a = alumnoList.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt : " + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (a != null) ? a.getNombres(): "No definido";
            case 2:
                return (a != null) ? a.getApellidos() : "No definido";
            default:
                return null;
        }    
    }
    
}
