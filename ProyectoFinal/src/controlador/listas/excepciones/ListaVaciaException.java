/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas.excepciones;

/**
 *
 * @author TecnoeXtrem
 */
public class ListaVaciaException extends Exception {
    public ListaVaciaException(String msg){
        super(msg);
    }
    
    public ListaVaciaException(){
        super("La lista esta vacia");
    }
}
