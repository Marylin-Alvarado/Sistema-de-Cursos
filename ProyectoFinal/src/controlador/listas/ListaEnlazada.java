/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.listas;

import controlador.Utilidades.Utilidades;
import controlador.listas.excepciones.AtributoException;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.ListaVaciaException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Date;

/**
 *
 * @author SONY VAIO
 */
public class ListaEnlazada<E> {
    
    private NodoLista<E> cabecera;
    private Integer size;
    private final Integer ascendente = 1;
    private final Integer descendente = 2;
    
    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }
    /**
     * Método para verificar si una lista está vacia
     * @return 
     */
    public Boolean estaVacia() {
        return cabecera == null;
    }
    
    /**
     * Método para insertar un dato a la lista
     * @param dato 
     */
    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            this.cabecera = nodo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
    }
    
    /**
     * Método para insertar un dato al comienzo de la lista
     * @param dato 
     */
    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }
    
    /**
     * Método para modiifar un dato de la lista en la posición dada
     * @param dato
     * @param pos
     * @throws PosicionNoEncontradaException 
     */
    public void modificar(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (!estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }
        } else {
            throw new PosicionNoEncontradaException();
        }
    }
    
    /**
     * Método para eliminar un elemento de la lista
     * @param pos
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException 
     */
    public E eliminar(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;

                } else {
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }

                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }

            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaException();
        }

    }    
    /**
     * Método para imprimir por consola la lista
     */
    public void imprimir() {
        System.out.println("--------------LISTA ENLAZADA------------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        System.out.println("\n--------------------------------------");
    }
    
    /**
     * Método para obtener el elemento de la lista en la posición dada
     * @param pos
     * @return
     * @throws PosicionNoEncontradaException
     * @throws ListaNullException 
     */
    public E obtener(Integer pos) throws PosicionNoEncontradaException, ListaNullException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaNullException();
        }
    }
    
    /**
     * Método para pasar una lista enlazada a un arreglo
     * @return 
     */
    public E[] toArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }
    
    /**
     * Método para pasar un arreglo a una lista enlazada
     * @param matriz
     * @return 
     */
    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }
    
    /**
     * Método para vaciar una lista enlazada
     */
    public void vaciar() {
        this.cabecera = null;
        this.size = 0;
    }
    
    /**
     * Método para ordenar la lista por el método Shell
     * @param atributo
     * @param tipoOrdenacion
     * @return 
     */
    public ListaEnlazada<E> ordenarShell(String atributo, Integer tipoOrdenacion) {
        E[] arreglo = toArray();
        Class<E> clazz = null;

        if (size > 0) {
            Integer intervalo, i, j, k;
            Integer n = arreglo.length;
            intervalo = n / 2;
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);

            while (intervalo > 0) {
                for (i = intervalo; i < n; i++) {
                    j = i - intervalo;
                    while (j >= 0) {
                        k = j + intervalo;
                        if (isObject) {

                            try {
                                compararAtributoShell(arreglo, j, k, tipoOrdenacion, atributo, clazz);
                            } catch (Exception e) {
                                System.out.println("error: " + e.getMessage() + "\nLinea:" + e.getStackTrace()[0].getLineNumber() + e.getStackTrace()[0].getClassName());
                            }

                        } else {
                            intercambioDatoShell(arreglo, j, k, tipoOrdenacion);
                        }
                        j -= intervalo;
                    }
                }
                intervalo = intervalo / 2;
            }
        }
        if (arreglo != null) {
            toList(arreglo);
        }
        return this;
    }
    
    /**
     * Método que permite hacer el intercambio de un dato primitivo
     * @param arreglo
     * @param j
     * @param k
     * @param tipoOrdenacion 
     */
    public void intercambioDatoShell(E[] arreglo, Integer j, Integer k, Integer tipoOrdenacion) {
        Class clazz = arreglo[0].getClass();
        Object aux;

        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == descendente) {
                if (((Number) arreglo[j]).doubleValue() > ((Number) arreglo[k]).doubleValue()) {
                    j = -1;
                } else {
                    aux = (Number) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (((Number) arreglo[j]).doubleValue() < ((Number) arreglo[k]).doubleValue()) {
                    j = -1;
                } else {
                    aux = (Number) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
        if (Utilidades.isString(clazz)) {
            if (tipoOrdenacion == descendente) {
                if (arreglo[j].toString().toLowerCase().compareTo(arreglo[k].toString().toLowerCase()) > 0) {
                    j = -1;
                } else {
                    aux = (String) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (arreglo[j].toString().toLowerCase().compareTo(arreglo[k].toString().toLowerCase()) < 0) {
                    j = -1;
                } else {
                    aux = (String) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
        if(Utilidades.isDate(clazz)){
            if(tipoOrdenacion == descendente){
                if ( ((Date)arreglo[j]).getYear() > ((Date)arreglo[k]).getYear() ) {
                    j = -1;
                } else {
                    aux = (Date) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                    
                }
            }else{
                if ( ((Date)arreglo[j]).getYear() < ((Date)arreglo[k]).getYear() ) {
                    j = -1;
                } else {
                    aux = (Date) arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
        
        
    }
    
    /**
     * Método que permite obtener el dato del atributo que se va a comparar de un objeto
     * @param arreglo
     * @param j
     * @param k
     * @param tipoOrdenacion
     * @param atributo
     * @param clazz
     * @throws Exception 
     */
    public void compararAtributoShell(E[] arreglo, Integer j, Integer k, Integer tipoOrdenacion, String atributo, Class clazz) throws Exception {
        E auxJ = arreglo[j];
        E auxK = arreglo[k];
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            Object a = field.get(auxJ);
            Object b = field.get(auxK);

            intercambioObjetoShell(arreglo, a, b, j, k, tipoOrdenacion, atributo);
        }
    }
    
    /**
     * Método que hace el intercambio de objetos
     * @param arreglo
     * @param auxJ
     * @param auxK
     * @param j
     * @param k
     * @param tipoOrdenacion
     * @param atributo 
     */
    public void intercambioObjetoShell(E[] arreglo, Object auxJ, Object auxK, Integer j, Integer k, Integer tipoOrdenacion, String atributo) {
        Class clazz = auxJ.getClass();
        Object aux;
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == descendente) {
                if (((Number) auxJ).doubleValue() > ((Number) auxK).doubleValue()) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (((Number) auxJ).doubleValue() < ((Number) auxK).doubleValue()) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }

        }
        if (Utilidades.isString(clazz)) {
            if (tipoOrdenacion == descendente) {
                if (auxJ.toString().toLowerCase().compareTo(auxK.toString().toLowerCase()) > 0) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            } else {
                if (auxJ.toString().toLowerCase().compareTo(auxK.toString().toLowerCase()) < 0) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = (E) aux;
                }
            }
        }
    }
    
    /**
     * Método de búsqueda secuencial
     * @param atributo
     * @param dato
     * @return
     * @throws Exception 
     */
    public ListaEnlazada<E> buscar(String atributo, Object dato) throws Exception{
        Class<E> clazz = null;
        ListaEnlazada<E> result = new ListaEnlazada<>();
        if (size > 0) {
            E[] matriz = toArray();
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);

            for (int i = 0; i < matriz.length; i++) {
                if (isObject) {
                    Boolean band = evaluarBusquedaObjeto(matriz[i], dato, clazz, atributo);
                    if(band){
                        result.insertar(matriz[i]);
                    }
                    
                } else {
                    Boolean band = buscarPosicion(matriz[i], dato);
                    if (band) {
                        result.insertar(matriz[i]);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Método para buscar la posición de un dato primitivo
     * @param datoMatriz
     * @param busqueda
     * @return 
     */
    private Boolean buscarPosicion(Object datoMatriz, Object busqueda) {
        if (Utilidades.isNumber(busqueda.getClass())) {
            if ((((Number) datoMatriz)).doubleValue() == (((Number) busqueda)).doubleValue()) {
                return true;
            }
        } else if (Utilidades.isString(busqueda.getClass())){
            if(datoMatriz.toString().toLowerCase().startsWith(busqueda.toString().toLowerCase())
                || datoMatriz.toString().toLowerCase().endsWith(busqueda.toString().toLowerCase())
                || datoMatriz.toString().toLowerCase().equalsIgnoreCase(busqueda.toString().toLowerCase())
                || datoMatriz.toString().toLowerCase().contains(busqueda.toString().toLowerCase())) {
                return true;
            }
            
        }

        return false;
    }
      
    
   public void modificarPosicion(E dato, Integer pos) throws PosicionNoEncontradaException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {

                NodoLista<E> aux = cabecera;

                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }

        } else {
            throw new PosicionNoEncontradaException();
        }
    }
   
    /**
     * Método para buscar un objeto
     * @param aux
     * @param dato
     * @param clazz
     * @param atributo
     * @return
     * @throws AtributoException
     * @throws Exception 
     */
    private Boolean evaluarBusquedaObjeto(E aux, Object dato, Class clazz, String atributo) throws AtributoException, Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            Object a = field.get(aux);
            return buscarPosicion(a, dato);
        }

    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
