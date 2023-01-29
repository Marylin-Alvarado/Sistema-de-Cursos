/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Alumno;

/**
 *
 * @author DEEPIN
 */
public class ModeloTablaAlumno extends AbstractTableModel {
    private ListaEnlazada<Alumno> alumnos = new ListaEnlazada<>();
    
    @Override
    public int getRowCount() {
        return alumnos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
     @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nombres";
            case 2: return "Apellidos";
            case 3: return "Identificacion";
            case 4: return "Direccion";
            case 5: return "Telefono";
            case 6: return "Fecha nacimiento";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno a = null;
        try {
            a = alumnos.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt : " + e);
        }
        switch (columnIndex) {
            case 0: return (rowIndex + 1);
            case 1: return (a != null) ? a.getNombres() : "No definido";
            case 2: return (a != null) ? a.getApellidos() : "No definido";
            case 3: return (a != null) ? a.getIdentificacion() : "No definido";
            case 4: return (a != null) ? a.getDireccion() : "No definido";
            case 5: return (a != null) ? a.getTelefono() : "No definido";
            case 6: return (a != null) ? a.getFechaNacimiento() : "No definido";
            default: return null;
        }    
    }

    public ListaEnlazada<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ListaEnlazada<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    
    
}
