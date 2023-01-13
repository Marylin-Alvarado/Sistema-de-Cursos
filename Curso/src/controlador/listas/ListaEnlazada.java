package controlador.listas;

import controlador.listas.excepciones.AtributoException;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import controlador.utiles.Utilidades;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Objects;
import modelo.Persona;

/**
 *
 * @author SONY VAIO
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size;

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }

    //Metdo de bsqueda del estudiante
    public ListaEnlazada busquedaLinealBinaria(String campo, String dato) throws Exception {
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        long inicioEjecucion = System.nanoTime();
        if (size > 0) {
            System.out.println("dentro de size");
            E[] arreglo = toArray();
            Class<E> clazz = (Class<E>) cabecera.getDato().getClass();
            System.out.println("despes de clazz");
            boolean isObject = Utilidades.isObject(clazz);
            Integer inicio = 0;
            Integer fin = arreglo.length - 1;
            Integer posicion = 0;
            Float numeroBuscado = (float) Float.parseFloat(dato);
            Field field = null;
            Object valor = null;
            if (campo != null) {
                field = Utilidades.obtenerAtributo(clazz, campo);
                if (field == null) {
                    throw new AtributoException();
                }
                field.setAccessible(true);
            }
            while (inicio <= fin) {
                posicion = (inicio + fin) / 2;
                if (isObject) {
                    valor = field.get(arreglo[posicion]);
                    if (valor.equals(dato)) {
                        resultado.insertar(arreglo[posicion]);
                        return resultado;
                    } else if ((arreglo[posicion]).toString().compareTo(dato) < 0) {
                        inicio = posicion + 1;
                    } else {
                        fin = posicion - 1;
                    }
                } else {
                    Float numeroArreglo = (float) arreglo[posicion];
                    if (Objects.equals(numeroBuscado, numeroArreglo)) {
                        resultado.insertar(arreglo[posicion]);
                        return resultado;
                    } else if (numeroArreglo < numeroBuscado) {
                        inicio = posicion + 1;
                    } else {
                        fin = posicion - 1;
                    }
                }
            }
        }
        long finEjecucion = System.nanoTime();
        System.out.println("Tiempo de ejecicion en ordenmiento lineal " + (finEjecucion - inicioEjecucion));
        return resultado;
    }

    public ListaEnlazada<E> buscar(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> result = new ListaEnlazada<>();
        if (size > 0) {
            //opcional pueden ordenar
            E[] array = toArray();
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);

            for (int i = 0; i < array.length; i++) { //Verificar si esta bien
                if (isObject) {
                    //cuando es objeto
                    Boolean band = evaluarBusquedaObjeto(array[i], dato, clazz, atributo);
                    if (band) {
                        result.insertar(array[i]);
                    }
                } else {
                    //cuando son datos primitivos
                    Boolean band = buscarPosicion(array[i], dato);
                    if (band) {
                        result.insertar(array[i]);
                    }

                }
            }
        }
        return result;
    }

    private Boolean buscarPosicion(Object datoMatriz, Object busqueda) {
        //TODO 
        //FALTA IMPLEMENTAR MAS FATOS --- ENUMS
        if (Utilidades.isNumber(busqueda.getClass())) {
            if (((Number) datoMatriz).doubleValue() == ((Number) busqueda).doubleValue()) {
                return true;
            }
        } else if (Utilidades.isString(busqueda.getClass())) {
            if (datoMatriz.toString().toLowerCase().startsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().endsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().equalsIgnoreCase(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().contains(busqueda.toString().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private Boolean evaluarBusquedaObjeto(E aux, Object dato, Class clazz, String atributo) throws Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo); // Agregar el parametro atributo, y completar el metodo obtener atributo
        if (field == null) {
            throw new AtributoException();
        }
        field.setAccessible(true);
        Object a = field.get(aux);
        return buscarPosicion(a, dato);
    }

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

    public void imprimir() {
        System.out.println("--------------LISTA ENLAZADA------------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        System.out.println("\n--------------------------------------");
    }

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

    //Convertir a arreglo
    public E[] toArray() {
        //Class<E> clazz = null;
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

    //Convertir a alista
    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    public void vaciar() {
        this.cabecera = null;
        this.size = 0;
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
