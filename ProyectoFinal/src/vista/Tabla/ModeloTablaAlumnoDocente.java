/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Alumno;
import modelo.Cursa;

/**
 *
 * @author TecnoeXtrem
 */
public class ModeloTablaAlumnoDocente extends AbstractTableModel{
    ListaEnlazada<Alumno> alumnoList = new ListaEnlazada<>();
    ListaEnlazada<Cursa> cursaList = new ListaEnlazada<>();

    public ListaEnlazada<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(ListaEnlazada<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public ListaEnlazada<Cursa> getCursaList() {
        return cursaList;
    }

    public void setCursaList(ListaEnlazada<Cursa> cursaList) {
        this.cursaList = cursaList;
    }
    

    @Override
    public int getRowCount() {
        return alumnoList.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
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
            case 3:
                return "Nota";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno a = null;
        Cursa c = null;
        try {
            a = alumnoList.obtener(rowIndex);
            c = cursaList.obtener(rowIndex);
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
            case 3:
                return (c != null) ? c.getNotaFinal().getNotaTotal() : "No definido";
            default:
                return null;
        }    
    }
    
    
    
}
