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

    private ListaEnlazada<Alumno> lista = new ListaEnlazada<>();

    public ListaEnlazada<Alumno> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Alumno> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 8;
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
                return "Usuario";
            case 2:
                return "Identificacion";
            case 3:
                return "Nombre";
            case 4:
                return "Direccion";
            case 5:
                return "Correo";
            case 6:
                return "Matricula";
            case 7:
                return "Asistencia";
            case 8:
                return "Ciclo";
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
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (a != null) ? a.getCuenta().toString() : "NO DEFINIDO";
            case 2:
                return (a != null) ? a.getIdentificacion().toString() : "NO DEFINIDO";
            case 3:
                return (a != null) ? (a.getApellidos() + " " + a.getNombres()) : "NO DEFINIDO";
            case 4:
                return (a != null) ? a.getDireccion() : "NO DEFINIDO";
            case 5:
                return (a != null) ? a.getCorreo() : "NO DEFINIDO";
            case 6:
                return (a != null) ? a.getMatriculas() : "NO DEFINIDO";
            case 7: 
                return (a != null) ? a.getAsistencia() : "NO DEFINIDO";
            
            default:
            
                return null;
        }
    }

}
