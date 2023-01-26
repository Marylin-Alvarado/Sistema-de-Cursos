/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controlador.listas.ListaEnlazada;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.ListaVaciaException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import modelo.Asignatura;
import modelo.Ciclo;
import modelo.Docente;
import modelo.enums.Estado;
import modelo.enums.Generos;
import modelo.enums.Unidades;

/**
 *
 * @author David Campoverde
 */
public class Utilidades {
    
    // Aqui se van a implementar los metodos de guardar y listar

    /**
     * Metodo para cargar los generos que se encuentran en un enum dentro de un JComboBox
     * @param cbx
     * @return 
     */
    public static JComboBox cargarComboGenero(JComboBox cbx) {
        cbx.removeAllItems();
        for (Generos genero : Generos.values()) {
            cbx.addItem(genero);
        }
        return cbx;
    }
    
    public static Generos getComboGenero(JComboBox cbx){
        return (Generos) cbx.getSelectedItem();
    }
    
    /**
     * Metodo para cargar los estados que se encuentran dentro de un enum en un JComboBox
     * @param cbx
     * @return 
     */
    public static JComboBox cargarEstados(JComboBox cbx){
        cbx.removeAllItems();
        for(Estado estado : Estado.values()){
            cbx.addItem(estado);
        }
        return cbx;
    }
    
    /**
     * Metodo para cargar los docentes dentro de un JComboBox
     * @param cbx
     * @param docentes
     * @return 
     */
    public static JComboBox cargarDocentes(JComboBox cbx, ListaEnlazada docentes){
        cbx.removeAllItems();
        for(int i = 0; i < docentes.getSize() ; i++){
            try {
                cbx.addItem(docentes.obtener(i));
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ListaNullException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cbx;
    }
    
    public static JComboBox cargarAsignaturas(JComboBox cbx, ListaEnlazada asignaturas){
        cbx.removeAllItems();
        for(int i = 0; i < asignaturas.getSize(); i++){
            try {
                cbx.addItem(asignaturas.obtener(i));
            } catch (PosicionNoEncontradaException | ListaNullException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cbx;
    }

    /**
     * Metodo para guardar un tipo de dato Asignatura dentro de un archivo JSON
     * @param asignatura 
     */
    public static void guardarAsignatura(Asignatura asignatura) {
        ListaEnlazada<Asignatura> lista = listarAsignaturas();
        lista.insertar(asignatura);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("asignaturas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    
    /**
     * Metodo para modicar la asignatura dentro de un archivo JSON
     * @param asignatura
     * @param posicion
     * @throws PosicionNoEncontradaException 
     */
    public static void modificarAsignatura(Asignatura asignatura, Integer posicion) throws PosicionNoEncontradaException{
        ListaEnlazada<Asignatura> lista = listarAsignaturas();
        lista.modificarPosicion(asignatura, posicion);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("asignaturas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }    
    
    public static void modificarCiclo(Ciclo ciclo, Integer posicion) throws PosicionNoEncontradaException{
        ListaEnlazada<Ciclo> lista = listarCiclos();
        lista.modificarPosicion(ciclo, posicion);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("ciclos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    } 
    
    /**
     * Metodo para guardar ciclo dentro de un archivo JSON
     * @param ciclo 
     */
    public static void guardarCiclo(Ciclo ciclo) {
        ListaEnlazada<Ciclo> lista = listarCiclos();
        lista.insertar(ciclo);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("ciclos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    /**
     * Metodo para obtener la lista de ciclo de un archivo JSON 
     * @return 
     */
    
    public static ListaEnlazada<Ciclo> listarCiclos() {
        ListaEnlazada<Ciclo> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("ciclos.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Ciclo>>() {
            }.getType();
//            System.out.println("Tipolist " + tipoLista);
//            List a = stringToArray(json, Persona[].class);
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
    
    /**
     * Metodo para obtener la lista de asignaturas desde un archivo JSON
     * @return 
     */
    public static ListaEnlazada<Asignatura> listarAsignaturas() {
        ListaEnlazada<Asignatura> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("asignaturas.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Asignatura>>() {
            }.getType();
//            System.out.println("Tipolist " + tipoLista);
//            List a = stringToArray(json, Persona[].class);
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
    /**
     * Eliinar Asignatura
     */
    
    public static void eliminarAsignatura(Integer posicion) throws PosicionNoEncontradaException, ListaVaciaException{
        ListaEnlazada<Asignatura> lista = listarAsignaturas();
        lista.eliminar(posicion);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("asignaturas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    public static void eliminarAsignaturaCiclo(Integer posicionCiclo, Integer posicionAsignatura) throws PosicionNoEncontradaException, ListaVaciaException, ListaNullException{
        ListaEnlazada<Ciclo> lista = listarCiclos();
        Ciclo ciclo = lista.obtener(posicionCiclo);
        ListaEnlazada cicloAsignaturas = ciclo.getAsignaturas();
        cicloAsignaturas.eliminar(posicionAsignatura);
        ciclo.setAsignaturas(cicloAsignaturas);
        lista.modificarPosicion(ciclo, posicionCiclo);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("ciclos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    public static void eliminarCiclo(Integer posicionCiclo) throws ListaVaciaException, PosicionNoEncontradaException{
        ListaEnlazada<Ciclo> lista = listarCiclos();
        lista.eliminar(posicionCiclo);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("ciclos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
}
