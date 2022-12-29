package vista.modelo;

import controlador.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Asignatura;

/**
 * fecha: 28/12/2022
 *
 * @author: CEAS
 */
public class ModeloTablaAsignatura extends AbstractTableModel {

    ListaEnlazada<Asignatura> lista = new ListaEnlazada<>();

    public ListaEnlazada<Asignatura> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Asignatura> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return 8;
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
                return "Paralelo";
            case 2:
                return "Unidad";
            case 3:
                return "Nombre Asignatura";
            case 4:
                return "Docente";
            case 5:
                return "Cursa";
            case 6:
                return "Estado Asignatura";
            case 7:
                return "Nro. Horas";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Asignatura asignatura = null;
        switch (fila) {
            case 0:
                return fila + 1;
            case 1:
                return asignatura != null ? asignatura.getParalelo() : "";
            case 2:
                return asignatura != null ? asignatura.getUnidad() : "";
            case 3:
                return asignatura != null ? asignatura.getNombreAsignatura() : "";
            case 4:
                return asignatura != null ? asignatura.getDocente().getNombres() : "";
            case 5:
                return asignatura != null ? asignatura.getCursa().getHorasAsistidas() : "";
            case 6:
                return asignatura != null ? asignatura.getEstadoAsignatura() : "";
            case 7:
                return asignatura != null ? asignatura.getNumeroHoras() : "";
            default:
                return null;
        }
    }

}
