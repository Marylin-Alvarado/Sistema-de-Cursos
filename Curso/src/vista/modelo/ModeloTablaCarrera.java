package vista.modelo;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Carrera;

/**
 * fecha: 28/12/2022
 *
 * @author: CEAS
 */
public class ModeloTablaCarrera extends AbstractTableModel {

    ListaEnlazada<Carrera> lista = new ListaEnlazada<>();

    public ListaEnlazada<Carrera> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Carrera> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return 4;
    }

    @Override
    public int getColumnCount() {
        return lista.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Nombre Carrera";
            case 2:
                return "Seccion";
            case 3:
                return "Ciclos";

            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Carrera carrera = null;
        switch (fila) {
            case 0:
                return fila + 1;
            case 1:
                return carrera != null ? carrera.getNombre() : "";
            case 2:
                return carrera != null ? carrera.getSeccion() : "";
            case 3:
                return carrera != null ? carrera.getCiclos(): "";
            default:
                return null;
        }
    }

}
