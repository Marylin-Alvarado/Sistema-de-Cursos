/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.AlumnoController;
import controlador.AsignaturaController;
import controlador.CursaController;
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
import modelo.Asignatura;
import modelo.Matricula;
import vista.Tabla.ModeloTablaCompanieroEstudiante;
import vista.Tabla.ModeloTablaMatriculas;
import vista.Utilidades.Utilidades;

/**
 *
 * @author SONY VAIO
 */
public class FrmEstidiante extends javax.swing.JDialog {

    private FondoPanel fondo = new FondoPanel();
    private ModeloTablaMatriculas mtm = new ModeloTablaMatriculas();
    private ModeloTablaCompanieroEstudiante mtce = new ModeloTablaCompanieroEstudiante();
    private MatriculaController mC = new MatriculaController();
    private AlumnoController aC = new AlumnoController();
    private AsignaturaController asigC = new AsignaturaController();
    private CursaController cursaControler = new CursaController();

    /**
     * Creates new form FrmEstidiantee
     */
    public FrmEstidiante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setContentPane(fondo);
        initComponents();
        cargarCombos();
        obtenerUltimaMatricula();
        this.setLocationRelativeTo(this);

//        cargarTabla();
    }

    public FrmEstidiante(java.awt.Frame parent, boolean modal, Alumno alumno) {
        super(parent, modal);
        this.setContentPane(fondo);
        aC.setAlumno(alumno);
        obtenerUltimaMatricula();
        initComponents();
        cargarCombos();
        cargarEstudiante();
        this.setLocationRelativeTo(this);
    }

    public void calcularNotaEstudiante() {
        Asignatura a = (Asignatura) cbxAsignaturas.getSelectedItem();
        try {
            for (int i = 0; i < mC.getMatricula().getCursa().getSize(); i++) {
                if (mC.getMatricula().getCursa().obtener(i).getAsignatura().getNombre() == a.getNombre()) {
                    lblNotaFinal.setText(String.valueOf(mC.getMatricula().getCursa().obtener(i).getNotaFinal().getNotaTotal()));
                }
            }
        } catch (Exception e) {
            System.out.println("Error en " + e);
        }
    }

    public void cargarEstudiante() {
        lblNombreEstudiatnte.setText(aC.getAlumno().getNombres() + " " + aC.getAlumno().getApellidos());
        calcularNotaEstudiante();
    }
//    public void cargarTabla() {
//        tblInicial.updateUI();
//    }

    /**
     * Metodo para cargar los comboBox del Dialog por medio de las utilidades
     * del proyecto
     */
    public void cargarCombos() {
        obtenerAsignaturas();
        Utilidades.cargarAsignaturas(cbxAsignaturas, asigC.getAsignatursList());
    }

    public void obtenerAsignaturas() {
        try {
            System.out.println("Size de cursa " + mC.getMatricula().getCursa().getSize());
            for (int i = 0; i < mC.getMatricula().getCursa().getSize(); i++) {
                asigC.getAsignatursList().insertar(mC.getMatricula().getCursa().obtener(i).getAsignatura());
            }
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaNullException ex) {
            Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
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
            }
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaNullException ex) {
            Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para cargar la tabla con las matriculas realizadas
     */
    public void cargarTablaMatriculas() {
        mC.setMatriculaList(Utilidades.listarMatriculas());
        ListaEnlazada<Matricula> matriculaList = new ListaEnlazada<>();
        for (int i = 0; i < mC.getMatriculaList().getSize(); i++) {
            try {
                if (mC.getMatriculaList().obtener(i).getAlumno().getId() == aC.getAlumno().getId()) {
                    matriculaList.insertar(mC.getMatriculaList().obtener(i));
                }
            } catch (PosicionNoEncontradaException ex) {
                Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ListaNullException ex) {
                Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (matriculaList.getSize() > 0) {
            mtm.setMatriculaList(matriculaList);
        } else {
            JOptionPane.showMessageDialog(null, "El alumno no tiene matriculas");
        }
        tblInicial.setModel(mtm);
        tblInicial.updateUI();
    }

    public void cargarTablaCompanieros() {
        calcularAsignaturas();
        mtce.setAlumnoList(aC.getAlumnoList());
        aC.setAlumnoList(aC.getAlumnoList());
        tblInicial.setModel(mtce);
        tblInicial.updateUI();
    }

    public void calcularAsignaturas() {
        mC.setMatriculaList(obtenerMatriculas());
        System.out.println("Mc size " + mC.getMatriculaList().getSize());
        Asignatura a = (Asignatura) cbxAsignaturas.getSelectedItem();
        System.out.println("nombre " + a.getNombre());
        try {

            for (int i = 0; i < mC.getMatriculaList().getSize(); i++) {
                for (int j = 0; j < mC.getMatriculaList().obtener(i).getCursa().getSize(); j++) {
//                    System.out.println("FOR " + mC.getMatriculaList().obtener(i).getCursa().obtener(j).getAsignatura().getNombre());
                    System.out.println("j " + j);
                    if (a.getNombre().equals(mC.getMatriculaList().obtener(i).getCursa().obtener(j).getAsignatura().getNombre())) {
                        aC.getAlumnoList().insertar(mC.getMatriculaList().obtener(i).getAlumno());
                        System.out.println("Estudiante " + j);
                    }
                }
            }
            System.out.println("mC " + aC.getAlumnoList().getSize());

        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ListaNullException ex) {
            Logger.getLogger(FrmEstidiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ListaEnlazada<Matricula> obtenerMatriculas() {
        mC.setMatriculaList(Utilidades.listarMatriculas());
        ListaEnlazada<Matricula> matriculaList = new ListaEnlazada<>();
        Matricula matricula = null;
        try {
            for (int i = 0; i < mC.getMatriculaList().getSize(); i++) {
                matricula = null;
                for (int j = 0; j < mC.getMatriculaList().getSize(); j++) {
                    if (mC.getMatriculaList().obtener(i).getAlumno().getId() == mC.getMatriculaList().obtener(j).getAlumno().getId()) {
                        System.out.println("dentro de ifff");
                        if (matricula == null) {
                            matricula = new Matricula();
                            matricula = mC.getMatriculaList().obtener(j);
                        } else if (mC.getMatriculaList().obtener(j).getFechaEmision().after(matricula.getFechaEmision())) {
                            matricula = mC.getMatriculaList().obtener(j);
                        }
                    }
                }
                matriculaList.insertar(matricula);
            }
            for (int i = 0; i < matriculaList.getSize(); i++) {
                for (int j = 0; j < matriculaList.getSize(); j++) {
                    if (matriculaList.obtener(i).getAlumno().getId() == matriculaList.obtener(j).getAlumno().getId() && i != j) {
                        matriculaList.eliminar(j);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en obtenerMatriculas " + e);
        }
        return matriculaList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jSpinner1 = new javax.swing.JSpinner();
        lblNombreEstudiatnte = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxAsignaturas = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInicial = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lblNotaFinal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnParticipantes = new javax.swing.JButton();
        btnAsistencia = new javax.swing.JButton();
        btnMatriculas = new javax.swing.JButton();
        txtPerfil = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombreEstudiatnte.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        lblNombreEstudiatnte.setText("Nombre del estudiante");

        jLabel2.setText("Asgnaturas");

        cbxAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxAsignaturasMouseClicked(evt);
            }
        });
        cbxAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAsignaturasActionPerformed(evt);
            }
        });

        tblInicial.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblInicial);

        jLabel5.setText("Nota: ");

        lblNotaFinal.setEnabled(false);

        btnParticipantes.setText("Participantes");
        btnParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticipantesActionPerformed(evt);
            }
        });

        btnAsistencia.setText("Asistencia");
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });

        btnMatriculas.setText("Matriculas");
        btnMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnParticipantes)
                .addGap(18, 18, 18)
                .addComponent(btnAsistencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMatriculas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAsistencia)
                            .addComponent(btnMatriculas))))
                .addContainerGap())
        );

        txtPerfil.setText("Perfil");
        txtPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPerfilActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(lblNombreEstudiatnte, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPerfil))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1)))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNotaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreEstudiatnte, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNotaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsistenciaActionPerformed

    private void btnMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculasActionPerformed
        // TODO add your handling code here:
        cargarTablaMatriculas();
    }//GEN-LAST:event_btnMatriculasActionPerformed

    private void btnParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticipantesActionPerformed
        // TODO add your handling code here:
        aC.setAlumnoList(new ListaEnlazada<>());
        cargarTablaCompanieros();
    }//GEN-LAST:event_btnParticipantesActionPerformed

    private void cbxAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxAsignaturasMouseClicked
        // TODO add your handling code here:
//        diriguirseMaterias();
//        cambiarNota();
        calcularNotaEstudiante();
    }//GEN-LAST:event_cbxAsignaturasMouseClicked

//    public void cambiarNota() {
//        Asignatura a = (Asignatura) cbxAsignaturas.getSelectedItem();
//        try {
//            for (int i = 0; i < mC.getMatriculaList().getSize(); i++) {
//                for (int j = 0; j < mC.getMatriculaList().obtener(i).getCursa().getSize(); j++) {
//                    cursaControler.setCursaList(mC.getMatriculaList().obtener(i).getCursa());
//                    if (mC.getMatriculaList().obtener(i).getAlumno().getId() == aC.getAlumno().getId()
//                            && a.getNombre().equals(mC.getMatriculaList().obtener(i).getCursa().obtener(j).getAsignatura().getNombre())) {
////                        cursaControler.calcularNotaFinal();
//                        System.out.println("Dentro de cambiar nota  " + mC.getMatriculaList().obtener(i).getAlumno() + " " + mC.getMatriculaList().obtener(i).getCursa().obtener(j).getNotaFinal().getNotaTotal());
//                        lblNotaFinal.setText(String.valueOf(cursaControler.getCursaList().obtener(j).getNotaFinal().getNotaTotal()));
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error en cambiarNota " + e);
//        }
//    }
    private void cbxAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAsignaturasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAsignaturasActionPerformed

    private void txtPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPerfilActionPerformed
        // TODO add your handling code here:
        PerfilEstudiante pE = new PerfilEstudiante(null, true, aC.getAlumno());
        this.setVisible(false);
        pE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtPerfilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DialogoAdmLogin diaLogin = new DialogoAdmLogin(null, true);
        this.setVisible(false);
        diaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Metodo para cargar el fondo de pantalla del JDialog
     */
    class FondoPanel extends JPanel {

        private Image image;

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
            java.util.logging.Logger.getLogger(FrmEstidiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstidiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstidiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstidiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmEstidiante dialog = new FrmEstidiante(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnMatriculas;
    private javax.swing.JButton btnParticipantes;
    private javax.swing.JComboBox<String> cbxAsignaturas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblNombreEstudiatnte;
    private javax.swing.JTextField lblNotaFinal;
    private javax.swing.JTable tblInicial;
    private javax.swing.JButton txtPerfil;
    // End of variables declaration//GEN-END:variables
}
