/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Cuenta;
import vista.Utilidades.Utilidades;

/**
 *
 * @author David Campoverde
 */
public class DialogAlumno extends javax.swing.JDialog {

    private Alumno alumno;

    /**
     * Creates new form DialogAlumno
     */
    public DialogAlumno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarCombo();
        setLocationRelativeTo(this);
    }

    public DialogAlumno(java.awt.Frame parent, boolean modal, Alumno alumno) {
        super(parent, modal);
        this.alumno = alumno;
        initComponents();
        cargarCombo();
        cargarDatos();
        setLocationRelativeTo(this);
    }

    public void cargarCombo() {
        Utilidades.cargarComboGenero(cbxGeneroAlumno);
    }

    public void cargarCampoFecha() {
        if (txtFechaNacimientoAlumno.getText().equals("dd/mm/aaaa")) {
            txtFechaNacimientoAlumno.setText("");
            txtFechaNacimientoAlumno.setForeground(Color.black);
        }
    }

    public Alumno crearAlumno() {
        Alumno a = new Alumno();
        if (txtNombresAlumno.getText().isEmpty() || txtApellidosAlumno.getText().isEmpty()
                || txtIdentificacionAlumno.getText().isEmpty() || txtDireccionAlumno.getText().isEmpty()
                || txtTelefonoAlumno.getText().isEmpty() || txtFechaNacimientoAlumno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            a.setNombres(txtNombresAlumno.getText());
            a.setApellidos(txtApellidosAlumno.getText());
            a.setIdentificacion(txtIdentificacionAlumno.getText());
            a.setDireccion(txtDireccionAlumno.getText());
            a.setTelefono(txtTelefonoAlumno.getText());
            a.setCiudad(txtCiudadAlumno.getText());
            a.setFechaNacimiento(txtFechaNacimientoAlumno.getText());
            a.setGenero(Utilidades.getComboGenero(cbxGeneroAlumno));

        }
        return a;
    }

    public void modificarAlumno() {
        if (txtNombresAlumno.getText().isEmpty() || txtApellidosAlumno.getText().isEmpty()
                || txtIdentificacionAlumno.getText().isEmpty() || txtDireccionAlumno.getText().isEmpty()
                || txtTelefonoAlumno.getText().isEmpty() || txtFechaNacimientoAlumno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            alumno.setNombres(txtNombresAlumno.getText());
            alumno.setApellidos(txtApellidosAlumno.getText());
            alumno.setIdentificacion(txtIdentificacionAlumno.getText());
            alumno.setDireccion(txtDireccionAlumno.getText());
            alumno.setTelefono(txtTelefonoAlumno.getText());
            alumno.setCiudad(txtCiudadAlumno.getText());
            alumno.setFechaNacimiento(txtFechaNacimientoAlumno.getText());
            alumno.setGenero(Utilidades.getComboGenero(cbxGeneroAlumno));

        }
    }

    public void generarCuenta(Alumno alumno) {
        Cuenta c = new Cuenta();
        c.setEstado(false);
        c.setTipoUser("Alumno");
        c.setId(Utilidades.listarCuentas().getSize() + 1);
        alumno.setCuenta(c);
        Utilidades.generarUsuario(alumno);
        Utilidades.generarContrasenia(alumno);
        Utilidades.guardarCuentas(c);
    }
    
    public void cargarDatos(){
        txtNombresAlumno.setText(alumno.getNombres());
        txtApellidosAlumno.setText(alumno.getApellidos());
        txtIdentificacionAlumno.setText(alumno.getIdentificacion());
        txtDireccionAlumno.setText(alumno.getDireccion());
        txtTelefonoAlumno.setText(alumno.getTelefono());
        txtCiudadAlumno.setText(alumno.getCiudad());
        txtFechaNacimientoAlumno.setText(alumno.getFechaNacimiento());
        
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombresAlumno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidosAlumno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdentificacionAlumno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccionAlumno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefonoAlumno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCiudadAlumno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaNacimientoAlumno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxGeneroAlumno = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Alumno"));

        jLabel1.setText("Nombres");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Identificacion");

        jLabel4.setText("Direccion");

        jLabel5.setText("Telefono");

        jLabel6.setText("Ciudad");

        jLabel7.setText("Fecha de Nacimiento");

        txtFechaNacimientoAlumno.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaNacimientoAlumno.setText("dd/mm/aaaa");
        txtFechaNacimientoAlumno.setToolTipText("");
        txtFechaNacimientoAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaNacimientoAlumnoMousePressed(evt);
            }
        });
        txtFechaNacimientoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoAlumnoActionPerformed(evt);
            }
        });

        jLabel8.setText("Genero");

        cbxGeneroAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxGeneroAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentificacionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombresAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudadAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaNacimientoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombresAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdentificacionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccionAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefonoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCiudadAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFechaNacimientoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxGeneroAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaNacimientoAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaNacimientoAlumnoMousePressed
        cargarCampoFecha();
    }//GEN-LAST:event_txtFechaNacimientoAlumnoMousePressed

    private void txtFechaNacimientoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoAlumnoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (alumno == null) {
            alumno = crearAlumno();
            if (alumno.getNombres() != null || alumno.getIdentificacion() != null) {
                generarCuenta(alumno);
                JOptionPane.showMessageDialog(this, "Alumno ingresado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } else {
            modificarAlumno();
            JOptionPane.showMessageDialog(this, "Alumno modificado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAlumno dialog = new DialogAlumno(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox<String> cbxGeneroAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellidosAlumno;
    private javax.swing.JTextField txtCiudadAlumno;
    private javax.swing.JTextField txtDireccionAlumno;
    private javax.swing.JTextField txtFechaNacimientoAlumno;
    private javax.swing.JTextField txtIdentificacionAlumno;
    private javax.swing.JTextField txtNombresAlumno;
    private javax.swing.JTextField txtTelefonoAlumno;
    // End of variables declaration//GEN-END:variables
}