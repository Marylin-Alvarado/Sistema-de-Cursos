/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.Utilidades;

import javax.swing.JComboBox;
import modelo.enums.TipoIdentificacion;
import modelo.enums.TipoRol;

/**
 *
 * @author DEEPIN
 */
public class Utilidades {

    public static void cargarTipoIndentificacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoIdentificacion tipo : TipoIdentificacion.values()) {
            cbx.addItem(tipo);
        }
    }

    public static TipoIdentificacion obtenerTipoIdentificacion(JComboBox cbx) {
        return (TipoIdentificacion) cbx.getSelectedItem();
    }
    
    public static void cargarTipoRol(JComboBox cbxt) {
        cbxt.removeAllItems();
        for (TipoRol tipo : TipoRol.values()) {
            cbxt.addItem(tipo);
        }
    }

    public static TipoRol obtenerRol(JComboBox cbxt) {
        return(TipoRol) cbxt.getSelectedItem();
    }


}
