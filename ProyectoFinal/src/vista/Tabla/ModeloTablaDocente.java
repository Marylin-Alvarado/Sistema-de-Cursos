/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Docente;

/**
 *
 * @author David Campoverde
 */
public class ModeloTablaDocente extends AbstractTableModel {

    ListaEnlazada<Docente> docentes = new ListaEnlazada<>();

    @Override
    public int getRowCount() {
        return docentes.getSize();
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
        Docente d = null;
        try {
            d = docentes.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt : " + e);
        }
        switch (columnIndex) {
            case 0: return (rowIndex + 1);
            case 1: return (d != null) ? d.getNombres() : "No definido";
            case 2: return (d != null) ? d.getApellidos() : "No definido";
            case 3: return (d != null) ? d.getIdentificacion() : "No definido";
            case 4: return (d != null) ? d.getDireccion() : "No definido";
            case 5: return (d != null) ? d.getTelefono() : "No definido";
            case 6: return (d != null) ? d.getFechaNacimiento() : "No definido";
            default: return null;
        }    
    }

    public ListaEnlazada<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ListaEnlazada<Docente> docentes) {
        this.docentes = docentes;
    }
    
    
    
}
