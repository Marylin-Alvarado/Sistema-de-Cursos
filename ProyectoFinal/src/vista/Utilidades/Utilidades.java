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
import controlador.listas.excepciones.PosicionNoEncontradaException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public static JComboBox cargarComboGenero(JComboBox cbx) {
        cbx.removeAllItems();
        for (Generos genero : Generos.values()) {
            cbx.addItem(genero);
        }
        return cbx;
    }
    public static JComboBox cargarUnidades(JComboBox cbx){
        cbx.removeAllItems();
        for(Unidades unidad : Unidades.values()){
            cbx.addItem(unidad);
        }
        return cbx;
    }
    
    public static JComboBox cargarEstados(JComboBox cbx){
        cbx.removeAllItems();
        for(Estado estado : Estado.values()){
            cbx.addItem(estado);
        }
        return cbx;
    }
    
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

    public static void guardarAsignatura(Asignatura dato) {
        ListaEnlazada<Asignatura> lista = listarAsignaturas();
        lista.insertar(dato);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("asignaturas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    public static void guardarCiclo(Ciclo dato) {
        ListaEnlazada<Ciclo> lista = listarCiclos();
        lista.insertar(dato);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("ciclos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    
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

}
