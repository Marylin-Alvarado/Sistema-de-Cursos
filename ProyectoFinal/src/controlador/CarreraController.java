/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Carrera;


/**
 *
 * @author TecnoeXtrem
 */
public class CarreraController {
    
    private ListaEnlazada<Carrera> carreraList;

    public CarreraController(){
        carreraList = new ListaEnlazada<>();
    }
    
    
    
    public ListaEnlazada<Carrera> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(ListaEnlazada<Carrera> carreraList) {
        this.carreraList = carreraList;
    }
    
}
