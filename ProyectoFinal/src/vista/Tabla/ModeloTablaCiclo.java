/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.CicloController;
import controlador.listas.ListaEnlazada;
import java.util.concurrent.LinkedTransferQueue;
import javax.swing.table.AbstractTableModel;
import modelo.Ciclo;

/**
 *
 * @author TecnoeXtrem
 */
public class ModeloTablaCiclo extends AbstractTableModel{

    private ListaEnlazada<Ciclo> listaCiclo = new ListaEnlazada<>();

    public ListaEnlazada<Ciclo> getListaCiclo() {
        return listaCiclo;
    }

    public void setListaCiclo(ListaEnlazada<Ciclo> listaCiclo) {
        this.listaCiclo = listaCiclo;
    }
    
    
    
    @Override
    public int getRowCount() {
        return listaCiclo.getSize();
    }

    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Nombre";
            case 2:
                return "Numero de asignaturas";           
            default:
                return null;
        }
    }
    
    @Override
    public int getColumnCount(){
        return 3;
    }    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ciclo c = null;
        try {
            c = listaCiclo.obtener(rowIndex);
            Object aLista = listaCiclo.obtener(rowIndex);  
            
            //TODO FALTA OBTENER EL NUM DE ASIGNATURAS
        } catch (Exception e) {
            System.out.println("Error en lista " + e);
        }
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (c != null) ? c.getNombre() : "No definido";
            case 2: 
                return (c != null) ? c.getAsignaturas().getSize() : "No definido";                     
            default:
                return null;
        }
    }
    
}
