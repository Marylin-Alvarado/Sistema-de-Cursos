/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Cuenta;

/**
 *
 * @author David Campoverde
 */
public class ModeloTablaCuentas extends AbstractTableModel{
    ListaEnlazada<Cuenta> cuentas = new ListaEnlazada<>();
    
    @Override
    public int getRowCount() {
        return cuentas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Usuario";
            case 2: return "Tipo de Cuenta";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta c = null;
        try {
            c = cuentas.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error en getValueAt : " + e);
        }
        switch (columnIndex) {
            case 0: return (rowIndex + 1);
            case 1: return (c != null) ? c.getUsuario() : "No definido";
            case 2: return (c != null) ? c.getTipoUser() : "No definido";
            default: return null;
        }    
    }
    
    public ListaEnlazada<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ListaEnlazada<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    
}
