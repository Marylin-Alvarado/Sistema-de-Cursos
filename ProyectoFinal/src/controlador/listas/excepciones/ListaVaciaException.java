/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.listas.excepciones;

/**
 *
 * @author Marylin Alvardo
 */
public class ListaVaciaException extends Exception {
    
    public ListaVaciaException(String msg){
        super(msg);
    }
    
    public ListaVaciaException(){
        super("La lista esta vacia");
    }
    
    
}
