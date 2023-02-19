/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.AlumnoController;
import controlador.DocentesController;
import controlador.MatriculaController;
import controlador.listas.ListaEnlazada;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Alumno;
import modelo.Docente;
import modelo.Matricula;
import modelo.enums.Generos;
import vista.Utilidades.Utilidades;

/**
 *
 * @author SONY VAIO
 */
public class VistaPerfilEstudiante extends javax.swing.JDialog {

    private FondoPanel fondo = new FondoPanel();
    private AlumnoController aC = new AlumnoController();
    private DocentesController dC = new DocentesController();
    private MatriculaController mC= new MatriculaController();


    /**
     * Creates new form PerfilEstudiante
     */
    public VistaPerfilEstudiante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setContentPane(fondo);
        initComponents();
        cargarCombos();
        this.setLocationRelativeTo(this);
    }
    
    public VistaPerfilEstudiante(java.awt.Frame parent, boolean modal, Alumno alumno, Docente docente) {
        super(parent, modal);
        this.setContentPane(fondo);
        aC.setAlumno(alumno);
        dC.setDocente(docente);
        initComponents();
        cargarCombos();
        cargarAlumno();
        this.setLocationRelativeTo(this);
    }

    public void cargarCombos() {
        Utilidades.cargarComboGenero(cbxGenero);
    }
    public void cargarAlumno() {
        if (this.aC.getAlumno() != null) {
            lblNombresApellidos.setText(this.aC.getAlumno().getNombres() + " " + this.aC.getAlumno().getApellidos());
            txtNombres.setText(this.aC.getAlumno().getNombres());
            txtApellidos.setText(this.aC.getAlumno().getApellidos());
            txtIdentificacion.setText(this.aC.getAlumno().getIdentificacion());
            calcularNumeroAsignaturas();
            txtTipoIdentificacion.setText(String.valueOf(this.aC.getAlumno().getTipoIdentificacion()));
            txtDireccion.setText(this.aC.getAlumno().getDireccion());
            txtTelefono.setText(this.aC.getAlumno().getTelefono());
            txtCiudad.setText(this.aC.getAlumno().getCiudad());
            txtCorreo.setText(this.aC.getAlumno().getCorreo());
            txtCorreoInstitucional.setText(this.aC.getAlumno().getCuenta().getUsuario());
            txtContraseniaInstitucional.setText(this.aC.getAlumno().getCuenta().getContrasenia());
            
        } else {
            JOptionPane.showMessageDialog(null, "Datos incompletos");
        }
    }
    
    public void calcularNumeroAsignaturas(){
        obtenerUltimaMatricula();
        try{
        for(int i =0 ;i < mC.getMatriculaList().getSize(); i++){
            if(mC.getMatriculaList().obtener(i).getAlumno().getId() == aC.getAlumno().getId()){
                txtNumeroMaterias.setText(String.valueOf(mC.getMatriculaList().obtener(i).getCursa().getSize()));
            }
        }
        }catch(Exception e){
            System.out.println("Error en calcular el numero de asignaturas" + e);
        }
    }
    
    public void obtenerUltimaMatricula() {
        mC.setMatriculaList(Utilidades.listarMatriculas());
        ListaEnlazada<Matricula> matriculaList = new ListaEnlazada<>();
        try {
            System.out.println("lista 1 : " + aC.getAlumno().getId());
            for (int i = 0; i < mC.getMatriculaList().getSize(); i++) {
                System.out.println("lista " + mC.getMatriculaList().obtener(i).getAlumno().getNombres());
                if (mC.getMatriculaList().obtener(i).getAlumno().getId() == aC.getAlumno().getId()) {
                    matriculaList.insertar(mC.getMatriculaList().obtener(i));
                }

            }
            System.out.println("SIZE DE matriculaList " + matriculaList.getSize());
            if (matriculaList.getSize() > 1) {
                for (int i = 1; i < matriculaList.getSize(); i++) {
                    if (matriculaList.obtener(i - 1).getFechaEmision().after(matriculaList.obtener(i).getFechaEmision())) {
                        mC.setMatricula(matriculaList.obtener(i - 1));
                    } else {
                        mC.setMatricula(matriculaList.obtener(i));
                    }
                }
            } else {
                mC.setMatricula(matriculaList.obtener(0));
                System.out.println("ID DE MATRUCULA " + mC.getMatricula().getIdMatricula());
            }
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaNullException ex) {
            Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para cargar el fondo del Dialog
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxTipoIdentif = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtContraseniaInstitucional = new javax.swing.JTextField();
        cbxGenero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCorreoInstitucional = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtTipoIdentificacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNumeroMaterias = new javax.swing.JTextField();
        lblNombresApellidos = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);

        cbxTipoIdentif.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setText("Telefono:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel8.setText("Direccion: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel13.setText("Genero:");

        txtNombres.setEnabled(false);

        txtApellidos.setEnabled(false);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        txtDireccion.setEnabled(false);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtCiudad.setEnabled(false);

        txtTelefono.setEnabled(false);

        txtContraseniaInstitucional.setEnabled(false);
        txtContraseniaInstitucional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaInstitucionalActionPerformed(evt);
            }
        });

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxGenero.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setText("Identificación: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel7.setText("Tipo de identificación: ");

        txtIdentificacion.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel9.setText("Ciudad");

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel18.setText("Correo institucional: ");

        txtCorreoInstitucional.setEnabled(false);
        txtCorreoInstitucional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoInstitucionalActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel19.setText("Contraseña:");

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel14.setText("Correo:");

        txtCorreo.setEnabled(false);
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        txtTipoIdentificacion.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel10.setText("Materias");

        txtNumeroMaterias.setEnabled(false);

        javax.swing.GroupLayout cbxTipoIdentifLayout = new javax.swing.GroupLayout(cbxTipoIdentif);
        cbxTipoIdentif.setLayout(cbxTipoIdentifLayout);
        cbxTipoIdentifLayout.setHorizontalGroup(
            cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                                    .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cbxTipoIdentifLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtIdentificacion))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cbxTipoIdentifLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(10, 10, 10))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cbxTipoIdentifLayout.createSequentialGroup()
                                    .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipoIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                            .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))
                    .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumeroMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(54, 54, 54)
                .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCorreoInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtContraseniaInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        cbxTipoIdentifLayout.setVerticalGroup(
            cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreoInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cbxTipoIdentifLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(cbxTipoIdentifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContraseniaInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        lblNombresApellidos.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblNombresApellidos.setText("Nombres y apellidos");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(765, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbxTipoIdentif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(324, 324, 324)
                            .addComponent(lblNombresApellidos)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(331, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(lblNombresApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cbxTipoIdentif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtContraseniaInstitucionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaInstitucionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseniaInstitucionalActionPerformed

    private void txtCorreoInstitucionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoInstitucionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoInstitucionalActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        FrmDocente frmDocente = new FrmDocente(null, true, dC.getDocente() );
        this.setVisible(false);
        frmDocente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    public void guardarAlumno() {
        if (!txtNombres.getText().equals(aC.getAlumno().getNombres()) || !txtApellidos.getText().equals(aC.getAlumno().getApellidos())
                || !txtDireccion.getText().equals(aC.getAlumno().getDireccion()) || !txtTelefono.getText().equals(aC.getAlumno().getTelefono())
                || !txtTelefono.getText().equals(aC.getAlumno().getTelefono()) || !txtCiudad.getText().equals(aC.getAlumno().getCiudad())
                || !cbxGenero.getSelectedItem().equals(aC.getAlumno().getGenero()) || !txtCorreo.getText().equals(aC.getAlumno().getCorreo())
                || !txtContraseniaInstitucional.getText().equals(aC.getAlumno().getCuenta().getContrasenia())) {
            aC.getAlumno().setNombres(txtNombres.getText());
            aC.getAlumno().setApellidos(txtApellidos.getText());
            aC.getAlumno().setDireccion(txtDireccion.getText());
            aC.getAlumno().setTelefono(txtTelefono.getText());
            aC.getAlumno().setCiudad(txtCiudad.getText());
            aC.getAlumno().setGenero((Generos) cbxGenero.getSelectedItem());
            aC.getAlumno().setCorreo(txtCorreo.getText());
            aC.getAlumno().getCuenta().setContrasenia(txtContraseniaInstitucional.getText());

            aC.setAlumnoList(Utilidades.listarAlumnos());
            for (int i = 0; i < aC.getAlumnoList().getSize(); i++) {
                try {
                    if (aC.getAlumnoList().obtener(i).getIdAlumno() == aC.getAlumno().getIdAlumno()) {
                        try {
                            Utilidades.modificarAlumno(aC.getAlumno(), i);
                        } catch (PosicionNoEncontradaException ex) {
                            Logger.getLogger(VistaPerfilEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(null, "No ha modificado el alumno correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido modificar ");
                    }
                } catch (PosicionNoEncontradaException ex) {
                    Logger.getLogger(VistaPerfilEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ListaNullException ex) {
                    Logger.getLogger(VistaPerfilEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    class FondoPanel extends JPanel {

        private Image image;

        /**
         * Metodo para pintar los graficos de los grafos en la pantalla
         *
         * @param g
         */
        @Override
        public void paint(Graphics g) {
            image = new ImageIcon(getClass().getResource("../img/fondoBlanco.jpg")).getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

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
            java.util.logging.Logger.getLogger(VistaPerfilEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPerfilEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPerfilEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPerfilEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaPerfilEstudiante dialog = new VistaPerfilEstudiante(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JPanel cbxTipoIdentif;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblNombresApellidos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtContraseniaInstitucional;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreoInstitucional;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumeroMaterias;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoIdentificacion;
    // End of variables declaration//GEN-END:variables
}
