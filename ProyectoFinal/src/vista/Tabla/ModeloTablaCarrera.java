/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Carrera;
import modelo.Malla;

/**
 *
 * @author David Campoverde
 */
public class ModeloTablaCarrera extends AbstractTableModel{
    
    ListaEnlazada<Carrera> carreras = new ListaEnlazada<>();
    ListaEnlazada<Malla> mallas = new ListaEnlazada<>();
    @Override
    public int getRowCount() {
        return carreras.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Carrera";
            case 2: return "Seccion";
            case 3: return "Malla";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carrera c = null;
        Malla m = null;
        try {
            c = carreras.obtener(rowIndex);
            m = mallas.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt : " + e);
        }
        switch (columnIndex) {
            case 0: return (rowIndex + 1);
            case 1: return (c != null) ?c.getNombre() : "No definido";
            case 2: return (c != null) ? c.getSeccion() : "No definido";
            case 3: return (c != null) ? m.getRegimen() : "No definido";
            default: return null;
        }    
    }
    
    public ListaEnlazada<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ListaEnlazada<Carrera> carreras) {
        this.carreras = carreras;
    }

    public ListaEnlazada<Malla> getMallas() {
        return mallas;
    }

    public void setMallas(ListaEnlazada<Malla> mallas) {
        this.mallas = mallas;
    }
    
    
    
    
}
