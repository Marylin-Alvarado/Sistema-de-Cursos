/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.listas.ListaEnlazada;
import modelo.Cuenta;

/**
 *
 * @author TecnoeXtrem
 */
public class CuentaController {
    private ListaEnlazada<Cuenta> cuentaList;
    private Cuenta cuenta;

    public ListaEnlazada<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(ListaEnlazada<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    
}
