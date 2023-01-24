/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Tabla;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Asignatura;

/**
 *
 * @author DEEPIN
 */
public class ModeloTablaAsignatura extends AbstractTableModel {

    private ListaEnlazada<Asignatura> lista = new ListaEnlazada<>();

    public ListaEnlazada<Asignatura> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Asignatura> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 5;
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
                return "Asignatura";
            case 2:
                return "Nombre";
            case 3:
                return "Carrera";
            case 4:
                return "Ciclo";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Asignatura asg = null;
        try {
            asg = lista.obtener(rowIndex);
        } catch (Exception e) {
        }
//        switch (columnIndex) {
//            case 0:
//                return (rowIndex + 1);
//            case 1:
//                return (asg != null) ? asg.getEstadoAsignatura().toString() : "NO DEFINIDO";
//            case 2:
//                return (asg != null) ? (asg.getApellidos() + " " + asg.getNombre()) : "NO DEFINIDO";
//            case 3:
//                return (asg != null) ? asg.getCarrera() : "NO DEFINIDO";
//            case 4:
//                return (asg != null) ? asg.getCiclo() : "NO DEFINIDO";
//           
//            default:
//            
                return null;
        //}
    }

}
