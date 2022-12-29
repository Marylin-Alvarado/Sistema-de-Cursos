package vista;

import controlador.ControladorAsignatura;
import javax.swing.JOptionPane;

/**
 * fecha: 26/12/2022
 *
 * @author: CEAS
 */
public class FrmAsignatura extends javax.swing.JDialog {

    ControladorAsignatura controladorAsignatura = new ControladorAsignatura();

    public FrmAsignatura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void limpiar() {
        txtCursa.setText("");
        txtDocente.setText("");
        txtNombreAsignatura.setText("");
        txtNroHoras.setText("");
        txtUnidad.setText("");
        cbxParalelo.setSelectedItem(-1);
        txtEstadoAsignatura.setText("");
        controladorAsignatura.setAsignatura(null);
    }

    private void guardar() {
        if (txtNombreAsignatura.getText().trim().isEmpty() || txtDocente.getText().trim().isEmpty() || txtNombreAsignatura.getText().trim().isEmpty()
                || txtNroHoras.getText().trim().isEmpty() || txtUnidad.getText().trim().isEmpty()
                || cbxParalelo.getSelectedIndex() == -1 || txtEstadoAsignatura.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
            limpiar();
        } else {
            if (controladorAsignatura.guardar()) {
                JOptionPane.showMessageDialog(null, "Guardado con exito", "OK", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);

            }
            limpiar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        bntGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbxParalelo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCursa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNroHoras = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNombreAsignatura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEstadoAsignatura = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        btnBorrar.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/borrar.png"))); // NOI18N
        btnBorrar.setText("BORRAR");
        btnBorrar.setAlignmentX(0.5F);
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 160, -1));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/modificar.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 160, -1));

        bntGuardar.setBackground(new java.awt.Color(255, 255, 255));
        bntGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntGuardar.setForeground(new java.awt.Color(0, 0, 0));
        bntGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/guardar.png"))); // NOI18N
        bntGuardar.setText("GUARDAR");
        bntGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntGuardar.setHideActionText(true);
        bntGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bntGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bntGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(bntGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 160, 40));

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 730, 140));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Unidad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        cbxParalelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H" }));
        getContentPane().add(cbxParalelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Paralelo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtUnidad.setText(" ");
        getContentPane().add(txtUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Docente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtDocente.setText(" ");
        getContentPane().add(txtDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Cursa");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        txtCursa.setText(" ");
        getContentPane().add(txtCursa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Nro. Horas");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        txtNroHoras.setText(" ");
        getContentPane().add(txtNroHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 170, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Nombre asignatura");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        txtNombreAsignatura.setText(" ");
        getContentPane().add(txtNombreAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 170, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Estado asignatura");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        txtEstadoAsignatura.setText(" ");
        getContentPane().add(txtEstadoAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 170, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_bntGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmAsignatura dialog = new FrmAsignatura(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bntGuardar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JComboBox<String> cbxParalelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtCursa;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtEstadoAsignatura;
    private javax.swing.JTextField txtNombreAsignatura;
    private javax.swing.JTextField txtNroHoras;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables

}
