package vista.utilidades;

import javax.swing.JComboBox;
import modelo.enums.Estado;
import modelo.enums.Seccion;

/**
 * fecha: 28/12/2022
 * @author: CEAS 
 */
public class Utilidades {
    public static void cargarComboBoxEstado(JComboBox cbx){
        cbx.removeAllItems();
        for (Estado estado : Estado.values()) {
            cbx.addItem(estado);
        }
    }
    public static Estado obtenerEstado(JComboBox cbx){
           return (Estado)cbx.getSelectedItem();
    }
    public static void cargarComboBoxSeccion(JComboBox cbx){
        cbx.removeAllItems();
        for (Seccion seccion : Seccion.values()) {
            cbx.addItem(seccion);
        }
    }
    
    public static Seccion obtenerSeccion(JComboBox cbx){
           return (Seccion)cbx.getSelectedItem();
    }
}
