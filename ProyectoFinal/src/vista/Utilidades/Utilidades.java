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
import modelo.Alumno;
import modelo.Asignatura;
import modelo.Carrera;
import modelo.Ciclo;
import modelo.Cuenta;
import modelo.Cursa;
import modelo.Docente;
import modelo.Malla;
import modelo.Matricula;
import modelo.Periodo;
import modelo.Persona;
import modelo.enums.Estado;
import modelo.enums.Generos;
import modelo.enums.Meses;
import modelo.enums.Seccion;
import modelo.enums.TipoIdentificacion;
import modelo.enums.Unidades;

/**
 *
 * @author David Campoverde
 */
public class Utilidades {
    
    public static void generarUsuario(Persona persona){
        persona.getCuenta().setUsuario(persona.getNombres()+"."+persona.getApellidos());
    }
    
    public static void generarContrasenia(Persona persona){
        persona.getCuenta().setContrasenia(persona.getIdentificacion());
    }
    // Aqui se van a implementar los metodos de guardar y listar
    /**
     * Metodo para cargar los generos que se encuentran en un enum dentro de un
     * JComboBox
     *
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
    
    public static Generos getComboGenero(JComboBox cbx) {
        return (Generos) cbx.getSelectedItem();
    }
    
    public static JComboBox cargarTipoIdentificacion(JComboBox cbx){
        cbx.removeAllItems();
        for(TipoIdentificacion identifiacion : TipoIdentificacion.values()){
            cbx.addItem(identifiacion);
        }
        return cbx;
    }
    
    /**
     * Metodo para cargar los estados que se encuentran dentro de un enum en un
     * JComboBox
     *
     * @param cbx
     * @return
     */
    public static JComboBox cargarEstados(JComboBox cbx) {
        cbx.removeAllItems();
        for (Estado estado : Estado.values()) {
            cbx.addItem(estado);
        }
        return cbx;
    }
    
    public static JComboBox cargarSecciones(JComboBox cbx){
        cbx.removeAllItems();
        for (Seccion seccion : Seccion.values()){
            cbx.addItem(seccion);
        }
        return cbx;
    }
    
    public static Seccion getComboSecciones(JComboBox cbx){
        return (Seccion) cbx.getSelectedItem();
    }
    
    public static JComboBox cargarMallas(JComboBox cbx, ListaEnlazada<Malla> malla) {
        cbx.removeAllItems();
        for(int i = 0; i < malla.getSize(); i++){
            try {
                cbx.addItem(malla.obtener(i));
            } catch (Exception e) {
            }
        }
        return cbx;
    }
    
    public static Malla getComboMallas(JComboBox cbx){
        return (Malla) cbx.getSelectedItem();
    }

    public static JComboBox cargarMeses(JComboBox cbx) {
        cbx.removeAllItems();
        for (Meses mes : Meses.values()) {
            cbx.addItem(mes);
        }
        return cbx;
    }

    /**
     * Metodo para cargar los docentes dentro de un JComboBox
     *
     * @param cbx
     * @param docentes
     * @return
     */
    public static JComboBox cargarDocentes(JComboBox cbx, ListaEnlazada<Docente> docentes) {
        cbx.removeAllItems();
        for (int i = 0; i < docentes.getSize(); i++) {
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
    public static JComboBox cargarPeriodos(JComboBox cbx, ListaEnlazada<Periodo> periodos) {
        cbx.removeAllItems();
        for (int i = 0; i < periodos.getSize(); i++) {
            try {
                cbx.addItem(periodos.obtener(i));
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ListaNullException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cbx;
    }

        public static JComboBox cargarCiclos(JComboBox cbx, ListaEnlazada<Ciclo> ciclos) {
        cbx.removeAllItems();
        for (int i = 0; i < ciclos.getSize(); i++) {
            try {
                cbx.addItem(ciclos.obtener(i));
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ListaNullException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cbx;
    }
    /**
     * Metodo para cargar Alumnos en un archivo JSON
     * @param cbx
     * @param alumnos
     * @return 
     */   
    public static JComboBox cargarAlumnos(JComboBox cbx, ListaEnlazada alumnos) {
        cbx.removeAllItems();
        for (int i = 0; i < alumnos.getSize(); i++) {
            try {
                cbx.addItem(alumnos.obtener(i));
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ListaNullException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cbx;
    }

    public static JComboBox cargarAsignaturas(JComboBox cbx, ListaEnlazada asignaturas) {
        cbx.removeAllItems();
        for (int i = 0; i < asignaturas.getSize(); i++) {
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
     *
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
     * Metodo para guardar cursa dentro de un archivo JSON
     * @param cursa 
     */
    public static void guardarCursas(Cursa cursa) {
        ListaEnlazada<Cursa> lista = listarCursas();
        lista.insertar(cursa);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("cursas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    /**
     * Metodo para guardar Cuentas en un archivo JSON
     * @param cuenta 
     */
    public static void guardarCuentas(Cuenta cuenta) {
        ListaEnlazada<Cuenta> lista = listarCuentas();
        lista.insertar(cuenta);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("cuentas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    
    public static void guardarMatricula (Matricula matricula) {
        ListaEnlazada<Matricula> lista = listarMatriculas();
        lista.insertar(matricula);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("matriculas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    /**
     * Metodo para guardar alumno dentro de un archivo JSON
     * @param alumno 
     */
     public static void guardarAlumno(Alumno alumno) {
        ListaEnlazada<Alumno> lista = listarAlumnos();
        lista.insertar(alumno);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("alumnos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
     
     public static void modificarDocente(Docente docente, Integer posicion) throws PosicionNoEncontradaException {
        ListaEnlazada<Docente> lista = listarDocentes();
        lista.modificarPosicion(docente, posicion);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("docentes.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
     
     public static void modificarPeriodo(Periodo periodo, Integer posicion) throws PosicionNoEncontradaException {
        ListaEnlazada<Periodo> lista = listarPeriodos();
        lista.modificarPosicion(periodo, posicion);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("periodos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }

    /**
     * Metodo para modicar la asignatura dentro de un archivo JSON
     *
     * @param asignatura
     * @param posicion
     * @throws PosicionNoEncontradaException
     */
    public static void modificarAsignatura(Asignatura asignatura, Integer posicion) throws PosicionNoEncontradaException {
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

    public static void modificarCiclo(Ciclo ciclo, Integer posicion) throws PosicionNoEncontradaException {
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
     * Metodo para modificar Alumno dentro de un archivo JSON
     * @param alumno
     * @param posicion
     * @throws PosicionNoEncontradaException 
     */
    
    public static void modificarAlumno(Alumno alumno, Integer posicion) throws PosicionNoEncontradaException {
        ListaEnlazada<Alumno> lista = listarAlumnos();
        lista.modificarPosicion(alumno, posicion);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("alumnos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    public static void guardarDocente(Docente Docente) {
        ListaEnlazada<Docente> lista = listarDocentes();
        lista.insertar(Docente);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("docentes.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }

    /**
     * Metodo para guardar ciclo dentro de un archivo JSON
     *
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
    
    public static void guardarAlumnos(Alumno alumno) {
        ListaEnlazada<Alumno> lista = listarAlumnos();
        lista.insertar(alumno);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("alumnos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }

    public static void guardarPeriodo(Periodo periodo) {
        ListaEnlazada<Periodo> lista = listarPeriodos();
        lista.insertar(periodo);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("periodos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }

    public static ListaEnlazada<Docente> listarDocentes() {
        ListaEnlazada<Docente> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("docentes.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Docente>>() {
            }.getType();
//            System.out.println("Tipolist " + tipoLista);
//            List a = stringToArray(json, Persona[].class);
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
    
    public static ListaEnlazada<Cursa> listarCursas() {
        ListaEnlazada<Cursa> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("cursas.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Cursa>>() {
            }.getType();
//            System.out.println("Tipolist " + tipoLista);
//            List a = stringToArray(json, Persona[].class);
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
    
    
    public static ListaEnlazada<Cuenta> listarCuentas() {
        ListaEnlazada<Cuenta> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("cuentas.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Cuenta>>() {
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
     * Metodo para obtener la lista de ciclo de un archivo JSON
     *
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
    
    public static ListaEnlazada<Matricula> listarMatriculas() {
        ListaEnlazada<Matricula> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("matriculas.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Matricula>>() {
            }.getType();
//            System.out.println("Tipolist " + tipoLista);
//            List a = stringToArray(json, Persona[].class);
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
    
    
    
    public static ListaEnlazada<Periodo> listarPeriodos() {
        ListaEnlazada<Periodo> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("periodos.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Periodo>>() {
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
     * Metodo para listar Alumnos en un archivo JSON
     * @return 
     */
    
    public static ListaEnlazada<Alumno> listarAlumnos() {
        ListaEnlazada<Alumno> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("alumnos.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Alumno>>() {
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
     *
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

    public static void eliminarAsignatura(Integer posicion) throws PosicionNoEncontradaException, ListaVaciaException {
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

    public static void eliminarAsignaturaCiclo(Integer posicionCiclo, Integer posicionAsignatura) throws PosicionNoEncontradaException, ListaVaciaException, ListaNullException {
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

    public static void eliminarCiclo(Integer posicionCiclo) throws ListaVaciaException, PosicionNoEncontradaException {
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
    public static void eliminarPeriodo(Integer posicionPeriodo) throws ListaVaciaException, PosicionNoEncontradaException {
        ListaEnlazada<Periodo> lista = listarPeriodos();
        lista.eliminar(posicionPeriodo);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("periodos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
     public static void eliminarAlumno(Integer posicionAlumno) throws ListaVaciaException, PosicionNoEncontradaException {
        ListaEnlazada<Alumno> lista = listarAlumnos();
        lista.eliminar(posicionAlumno);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("alumnos.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
     public static void eliminarDocente(Integer posicionDocente) throws ListaVaciaException, PosicionNoEncontradaException {
        ListaEnlazada<Docente> lista = listarDocentes();
        lista.eliminar(posicionDocente);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("docentes.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
     
     public static void guardarMalla(Malla malla) {
        ListaEnlazada<Malla> lista = listarMallas();
        lista.insertar(malla);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("mallas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
     
    public static ListaEnlazada<Malla> listarMallas() {
        ListaEnlazada<Malla> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("mallas.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
            Type tipoLista = new TypeToken<ListaEnlazada<Malla>>() {
            }.getType();
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
     
    public static void guardarCarrera(Carrera carrera) {
        ListaEnlazada<Carrera> lista = listarCarreras();
        lista.insertar(carrera);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("carreras.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    public static ListaEnlazada<Carrera> listarCarreras() {
        ListaEnlazada<Carrera> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("carreras.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
            Type tipoLista = new TypeToken<ListaEnlazada<Carrera>>() {
            }.getType();
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
    
    
    
}