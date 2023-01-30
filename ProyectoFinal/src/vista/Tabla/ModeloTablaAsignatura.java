/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import javax.swing.table.AbstractTableModel;
import modelo.Asignatura;
import modelo.enums.Estado;

/**
 *
 * @author TecnoeXtrem
 */
public class ModeloTablaAsignatura extends AbstractTableModel{

    ListaEnlazada<Asignatura> listaAsignaturas = new ListaEnlazada<>();

    public ListaEnlazada<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(ListaEnlazada<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }
    
    public Asignatura leerAsignatura(int fila){
        try {
            return listaAsignaturas.obtener(fila);
        } catch (PosicionNoEncontradaException ex) {
            System.out.println("Error " + ex );
        } catch (ListaNullException ex) {
            System.out.println("Error 2 " + ex);
        }
        return null;
    }
    
    @Override
    public int getRowCount() {
        return listaAsignaturas.getSize();
    }

    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Nombre";
            case 2:
                return "Numero de horas";
            default:
                return null;
        }        
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Asignatura a = null;
        try {
            a = listaAsignaturas.obtener(rowIndex);

        } catch (Exception e) {
            System.out.println("Error en getValueAt : " + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (a != null) ? a.getNombre(): "No definido";
            case 2:
                return (a != null) ? a.getNumeroHoras() : "No definido";
            default:
                return null;
        }
    }

    
}