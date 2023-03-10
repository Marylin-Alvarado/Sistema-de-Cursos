/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.CicloController;
import controlador.CursaController;
import controlador.MatriculaController;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.ListaVaciaException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Asignatura;
import modelo.Cursa;
import modelo.Nota;
import modelo.Periodo;
import modelo.enums.Estado;
import vista.Tabla.ModeloTablaAsignatura;
import vista.Tabla.ModeloTablaMatriculas;
import vista.Utilidades.Utilidades;

/**
 * Clase para matricular a estudiante
 * @author TecnoeXtrem
 */
public class DialogMatriculas extends javax.swing.JDialog {

    private ModeloTablaAsignatura mta = new ModeloTablaAsignatura();
    private MatriculaController mC = new MatriculaController();
    private ModeloTablaMatriculas mtm = new ModeloTablaMatriculas();
    private CicloController cC = new CicloController();
    private CursaController cursaC = new CursaController();

    /**
     * Creates new form DialogoMatricula
     */
    public DialogMatriculas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarCombos();
        this.setLocationRelativeTo(this);
    }

    /**
     * Metodo para cargar los comboBox con la informacion deseada La informacion
     * se extrae de enums o archivos JSON
     */
    public void cargarCombos() {
        Utilidades.cargarEstados(cbxEstadoMatricula);
        Utilidades.cargarAlumnos(cbxAlumos, Utilidades.listarAlumnos());
        Utilidades.cargarPeriodos(cbxPeriodo, Utilidades.listarPeriodos());
        Utilidades.cargarCiclos(cbxCiclo, Utilidades.listarCiclos());
    }

    /**
     * Metodo para cargar la tabla con las Asignaturas dispoinibles en el
     * archivo local json
     */
    public void cargatTablaAsignaturas() {
        try {
            cC.setCicloList(Utilidades.listarCiclos());
            cC.setCiclo(cC.getCicloList().obtener(cbxCiclo.getSelectedIndex()));
            cC.setAsignaturaList(cC.getCiclo().getAsignaturas());
            mta.setListaAsignaturas(cC.getAsignaturaList());
            tblPrincipal.setModel(mta);
            tblPrincipal.updateUI();
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(DialogMatriculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaNullException ex) {
            Logger.getLogger(DialogMatriculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para cargar la tabla con las matriculas disponibles en el archivo
     * local Json
     */
    public void cargarTablaMatriculas() {
        mtm.setMatriculaList(Utilidades.listarMatriculas());
        tblPrincipal.setModel(mtm);
        tblPrincipal.updateUI();
    }

    public void registrarAsignatura() {
        try {
//            Boolean verificarMatricula = false;
            Asignatura asignatura = new Asignatura();
            Cursa cursa = new Cursa();
            mC.getMatricula().setAlumno((Alumno) cbxAlumos.getSelectedItem());
            mC.setMatriculaList(Utilidades.listarMatriculas());
            System.out.println("Size " + mC.getMatriculaList().getSize());
            int matRep = 0;

            for (int i = 0; i < mC.getMatriculaList().getSize(); i++) {
                if (mC.getMatriculaList().obtener(i).getAlumno().getId() == mC.getMatricula().getAlumno().getId()) {
//                    verificarMatricula = true;
                    for (int j = 0; j < mC.getMatriculaList().obtener(i).getCursa().getSize()
                            && mC.getMatricula().getCursa().getSize() < 5; j++) { //2
                        cursaC.setCursaList(mC.getMatriculaList().obtener(i).getCursa());
//                        cursaC.calcularNotaFinal();
                        if (cursaC.getCursaList().obtener(j).getEstadoAsignatura() == Estado.REPROBADA) {
                            System.out.println("I " + i + " J " + j);
                            cursa = new Cursa();
                            asignatura = cursaC.getCursaList().obtener(j).getAsignatura();
                            System.out.println("nombre > " + asignatura.getNombre());
                            cursa.setAsignatura(asignatura);
                            cursa.setEstadoAsignatura(Estado.REPROBADA);
                            cursa.setHorasAsistidas(0);
                            cursa.setMatricula(null);
                            cursa.setNotaFinal(new Nota());
                            cursa.setHorasAsistidas(0);

                            mC.getMatricula().getCursa().insertar(cursa);
                            matRep = mC.getMatricula().getCursa().getSize();

                        }
                    }
                }
            }
            lblNumeroMateriasReprobadas.setText("Materias reprobadas: " + mC.getMatricula().getCursa().getSize());
            int index = 0;
            while (mC.getMatricula().getCursa().getSize() < 5
                    && cC.getAsignaturaList().getSize() > index) {
                System.out.println("sizze " + cC.getAsignaturaList().getSize());
                System.out.println("index " + index);
                cursa = new Cursa();
                cursa.setAsignatura(cC.getAsignaturaList().obtener(index));
                System.out.println("nombre >> " + cursa.getAsignatura().getNombre());
                cursa.setEstadoAsignatura(Estado.REPROBADA);
                cursa.setHorasAsistidas(0);
                cursa.setMatricula(null);
                cursa.setNotaFinal(new Nota());
                cursa.setHorasAsistidas(0);
                mC.getMatricula().getCursa().insertar(cursa);
                index++;
            }
            
            for(int i = 0; i < mC.getMatricula().getCursa().getSize(); i++){
                System.out.println("cursa en registrar" + mC.getMatricula().getCursa().obtener(i).getAsignatura().getNombre());
            }
            lblNumeroMateriasNuevas.setText("Numero de materias nuevas: " + (mC.getMatricula().getCursa().getSize() - matRep));
        } catch (Exception e) {
            System.out.println("Error en " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        cbxPeriodo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        lblNumeroMateriasReprobadas = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostrar1 = new javax.swing.JButton();
        btnCrearPeriodo = new javax.swing.JButton();
        btnMostrar2 = new javax.swing.JButton();
        btnMostrarMatriculas = new javax.swing.JButton();
        lblNumeroMaterias1 = new javax.swing.JLabel();
        cbxEstadoMatricula = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrincipal = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbxAlumos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbxCiclo = new javax.swing.JComboBox<>();
        lblNumeroMateriasNuevas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoBlanco.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Matriculaci??n");

        cbxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPeriodoActionPerformed(evt);
            }
        });

        jLabel5.setText("Materias");

        btnCrear.setText("Matricular");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        lblNumeroMateriasReprobadas.setText("Materias Reprobadas:");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnMostrar1.setText("+");
        btnMostrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrar1ActionPerformed(evt);
            }
        });

        btnCrearPeriodo.setText("+");
        btnCrearPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPeriodoActionPerformed(evt);
            }
        });

        btnMostrar2.setText("-");

        btnMostrarMatriculas.setText("Mostrar matriculas");
        btnMostrarMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarMatriculasActionPerformed(evt);
            }
        });

        lblNumeroMaterias1.setText("Estado:");

        cbxEstadoMatricula.setToolTipText("");

        tblPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPrincipal);

        jLabel3.setText("Periodo:");

        cbxAlumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlumosActionPerformed(evt);
            }
        });

        jLabel4.setText("Alumno: ");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel6.setText("Ciclo:");

        cbxCiclo.setToolTipText("");
        cbxCiclo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxCicloMouseClicked(evt);
            }
        });

        lblNumeroMateriasNuevas.setText("Materias nuevas:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCrear)
                        .addGap(26, 26, 26)
                        .addComponent(btnModificar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnMostrar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrar2)
                        .addGap(68, 68, 68))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cbxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCrearPeriodo))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lblNumeroMateriasReprobadas)
                                .addGap(135, 135, 135)
                                .addComponent(lblNumeroMateriasNuevas))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lblNumeroMaterias1)
                                .addGap(18, 18, 18)
                                .addComponent(cbxEstadoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarMatriculas)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(cbxAlumos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(429, Short.MAX_VALUE)))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCrearPeriodo)
                                    .addComponent(cbxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(31, 31, 31)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(btnMostrar)
                                    .addComponent(btnMostrar1)
                                    .addComponent(btnMostrar2)
                                    .addComponent(cbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNumeroMateriasNuevas)
                                    .addComponent(lblNumeroMateriasReprobadas))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumeroMaterias1)
                            .addComponent(cbxEstadoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostrarMatriculas)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar)
                            .addComponent(btnCrear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbxAlumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(398, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPeriodoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            // TODO add your handling code here:
            crearMatricula();
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(DialogMatriculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaNullException ex) {
            Logger.getLogger(DialogMatriculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:

        cargatTablaAsignaturas();
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnMostrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrar1ActionPerformed
        // TODO add your handling code here:
        registrarAsignatura();
    }//GEN-LAST:event_btnMostrar1ActionPerformed

    private void btnCrearPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPeriodoActionPerformed
        // TODO add your handling code here:
        new DialogPeriodo(null, true).setVisible(true);
    }//GEN-LAST:event_btnCrearPeriodoActionPerformed

    private void btnMostrarMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarMatriculasActionPerformed
        // TODO add your handling code here:
        cargarTablaMatriculas();
    }//GEN-LAST:event_btnMostrarMatriculasActionPerformed

    private void cbxAlumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlumosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAlumosActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        DialogAdministradorInicio inicio = new DialogAdministradorInicio();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarMatricula();
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Metodo para eliminar la metricula escojida
     */
    public void eliminarMatricula(){
        if(tblPrincipal.getSelectedRow() >= 0 ){
            try {
                Utilidades.eliminarMatricula(tblPrincipal.getSelectedRow());
                cargarTablaMatriculas();
            } catch (ListaVaciaException ex) {
                Logger.getLogger(DialogMatriculas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(DialogMatriculas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void cbxCicloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCicloMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxCicloMouseClicked

    /**
     * Metodo para crear y guardar una matrcula en el repositorio local, con
     * extension Json
     *
     * @throws PosicionNoEncontradaException
     * @throws ListaNullException
     */
    public void crearMatricula() throws PosicionNoEncontradaException, ListaNullException {

        if (mC.getMatricula().getCursa().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "Datos incompletos");
        } else {
            mC.getMatricula().setAlumno((Alumno) cbxAlumos.getSelectedItem());
            mC.getMatricula().setFechaEmision(new Date());
            mC.getMatricula().setPeriodo((Periodo) cbxPeriodo.getSelectedItem());
            mC.getMatricula().setPromedioGeneral((float) 0.00);
            mC.getMatricula().setIdMatricula(Utilidades.listarMatriculas().getSize() + 1);
            for(int i = 0; i < mC.getMatricula().getCursa().getSize(); i++){
                System.out.println("cursa en matricular: " + mC.getMatricula().getCursa().obtener(i).getAsignatura().getNombre());
            }
            Utilidades.guardarMatricula(mC.getMatricula());
            JOptionPane.showMessageDialog(null, "Se ha guardado matricula");
//            for (int i = 0; i < mC.getMatricula().getCursa().getSize(); i++) {
//                mC.getMatricula().getCursa().obtener(i).setMatricula(mC.getMatricula());
//                System.out.println(mC.getMatricula().getFechaEmision());
//                Utilidades.guardarCursas(mC.getMatricula().getCursa().obtener(i));
//            }

            mC.setMatricula(null);
            mC.setMatriculaList(null);
//        }
        }
    }

    /**
     * Metodo para registrar la asignatura presente en la matricula del
     * estudiante, ademas de la creacion del cursa para que ambos puedan tener
     * relacion
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogMatriculas dialog = new DialogMatriculas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnCrearPeriodo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnMostrar1;
    private javax.swing.JButton btnMostrar2;
    private javax.swing.JButton btnMostrarMatriculas;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxAlumos;
    private javax.swing.JComboBox<String> cbxCiclo;
    private javax.swing.JComboBox<String> cbxEstadoMatricula;
    private javax.swing.JComboBox<String> cbxPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumeroMaterias1;
    private javax.swing.JLabel lblNumeroMateriasNuevas;
    private javax.swing.JLabel lblNumeroMateriasReprobadas;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblPrincipal;
    // End of variables declaration//GEN-END:variables
}
