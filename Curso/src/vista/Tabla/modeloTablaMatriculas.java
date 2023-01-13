/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Matricula;

/**
 *
 * @author SONY VAIO
 */
public class modeloTablaMatriculas extends AbstractTableModel {
     private ListaEnlazada<Matricula> lista = new ListaEnlazada<>();

    public ListaEnlazada<Matricula> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Matricula> lista) {
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
                return "Tipo Identificacion";
            case 2:
                return "Fecha de emision";
            case 3:
                return "Alumno";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Matricula m = null;
        try {
            m = lista.obtener(rowIndex);
            System.out.println(m.getAlumno());
        } catch (Exception e) {
            System.out.println("Problema en getValueAt " + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (m != null) ? m.getIdMatricula() : "NO DEFINIDO";
            case 2:
                return (m != null) ? m.getFechaEmision() : "NO DEFINIDO";
            case 3:
                return (m != null) ? m.getAlumno() : "NO DEFINIDO";
            default:
                return null;
        }
    }
}
