/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Periodo;

/**
 *
 * @author TecnoeXtrem
 */
public class ModeloTablaPeriodo extends AbstractTableModel{

    private ListaEnlazada<Periodo> periodoList = new ListaEnlazada<>();
    

    public ListaEnlazada<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(ListaEnlazada<Periodo> periodoList) {
        this.periodoList = periodoList;
    }
    
    
    @Override
    public int getRowCount() {
        return periodoList.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Mes inicio";
            case 2:
                return "Mes final";
            case 3:
                return "Descripcion";
            default:
                return null;
        }        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Periodo p = null;
        try {
            p = periodoList.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt");
        }
        
        switch (columnIndex) {
            case 0:
                return (rowIndex + 1);
            case 1:
                return (p != null) ? p.getMesInicio(): "No definido";
            case 2:
                return (p != null) ? p.getMesFin(): "No definido";
            case 3:
                return (p != null) ? p.getEspecificacion() : "No definido";
            
            default:
                throw new AssertionError();
        }
        
    }
    
}
