/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Asignatura;

/**
 *
 * @author SONY VAIO
 */
public class modeloTablaAsignaturas extends AbstractTableModel {
    private ListaEnlazada<Asignatura> lista = new ListaEnlazada<>();

    public ListaEnlazada<Asignatura> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Asignatura> lista) {
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
                return "Nombre";
            case 2:
                return "Unidad";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Asignatura a = null;
        try {
            a = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Problema en getValueAt " + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (a != null) ? a.getNombre() : "NO DEFINIDO";
            case 2:
                return (a != null) ? a.getUnidad() : "NO DEFINIDO";
            default:
                return null;
        }
    }

}
