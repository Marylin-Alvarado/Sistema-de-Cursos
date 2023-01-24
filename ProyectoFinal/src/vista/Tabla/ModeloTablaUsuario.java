/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Cuenta;
import modelo.Persona;

/**
 *
 * @author DEEPIN
 */
public class ModeloTablaUsuario extends AbstractTableModel {

    private ListaEnlazada<Cuenta> lista = new ListaEnlazada<>();

    public ListaEnlazada<Cuenta> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Cuenta> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 3;
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
                return "Correo";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta c = null;
        try {
            c = lista.obtener(rowIndex);
        } catch (Exception e) {
        }
//        switch (columnIndex) {
//            case 0:
//                return (rowIndex + 1);
//            case 1:
//                return (c != null) ? c.getUsuario().toString() : "NO DEFINIDO";
//            case 2:
//                return (c != null) ? c.getCorreo() : "NO DEFINIDO";
//            
//            default:
//            
                return null;
//        }
    }

}
