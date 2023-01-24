/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Utilidades;

import javax.swing.JComboBox;
import modelo.enums.Generos;

/**
 *
 * @author David Campoverde
 */
public class Utilidades {
    
    public static JComboBox cargarComboGenero(JComboBox cbx){
        cbx.removeAllItems();
        for(Generos genero : Generos.values()){
            cbx.addItem(genero);
        }
        return cbx;
    }
    
}
