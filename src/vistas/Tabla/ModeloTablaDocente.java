/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Docente;

/**
 *
 * @author DEEPIN
 */
public class ModeloTablaDocente extends AbstractTableModel {

    private ListaEnlazada<Docente> lista = new ListaEnlazada<>();

    public ListaEnlazada<Docente> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Docente> lista) {
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
                return "Asignatura";
            case 7:
                return "Fecha";
            case 8:
                return "Titulo";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Docente d = null;
        try {
            d = lista.obtener(rowIndex);
        } catch (Exception e) {
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (d != null) ? d.getUsuario().toString() : "NO DEFINIDO";
            case 2:
                return (d != null) ? d.getIndetifiacion().toString() : "NO DEFINIDO";
            case 3:
                return (d != null) ? (d.getApellidos() + " " + d.getNombres()) : "NO DEFINIDO";
            case 4:
                return (d != null) ? d.getDireccion() : "NO DEFINIDO";
            case 5:
                return (d != null) ? d.getCorreo() : "NO DEFINIDO";
            case 6:
                return (d != null) ? d.getAsignatura(): "NO DEFINIDO";
            case 7: 
                return (d != null) ? d.getFechaNacimiento(): "NO DEFINIDO";
            case 8:
                return (d != null) ? d.getTituloCuartoNivel(): "NO DEFINIDO";
            
            default:
            
                return null;
        }
    }

}
