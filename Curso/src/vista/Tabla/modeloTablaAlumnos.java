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
 * @author SONY VAIO
 */
public class modeloTablaAlumnos extends AbstractTableModel {
    ListaEnlazada<Alumno> lista = new ListaEnlazada<>();

    public ListaEnlazada<Alumno> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Alumno> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
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
                return "Genero";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno a = null;
        try {
            a = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Problema en getValueAt " + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (a != null) ? a.getNombres(): "NO DEFINIDO";
            case 2:
                return (a != null) ? a.getApellidos(): "NO DEFINIDO";
            case 3:
                return (a != null) ? a.getGenero() : "NO DEFINIDO"; 
            default:
                return null;
        }
    }
    
}
