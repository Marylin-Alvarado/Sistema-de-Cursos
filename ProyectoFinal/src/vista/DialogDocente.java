/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.listas.ListaEnlazada;
import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.Cuenta;
import modelo.Docente;
import modelo.enums.Generos;
import vista.Utilidades.Utilidades;

/**
 *
 * @author David Campoverde
 */
public class DialogDocente extends java.awt.Dialog {

    private Docente docente;

    /**
     * Creates new form DialogDocente
     */
    public DialogDocente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarCombo();
        setLocationRelativeTo(this);
    }

    public DialogDocente(java.awt.Frame parent, boolean modal, Docente docente) {
        super(parent, modal);
        this.docente = docente;
        initComponents();
        cargarCombo();
        cargarDatos();
        setLocationRelativeTo(this);
    }

    public void cargarCombo() {
        Utilidades.cargarComboGenero(cbxGeneroDocente);
    }

    public Docente crearDocente() {
        Docente d = new Docente();
        if (txtNombresDocente.getText().isEmpty() || txtApellidosDocente.getText().isEmpty()
                || txtIdentificacionDocente.getText().isEmpty() || txtDireccionDocente.getText().isEmpty()
                || txtTelefonoDocente.getText().isEmpty() || txtFechaNacimientoDocente.getText().isEmpty()
                || txtAniosExpDocente.getText().isEmpty() || txtAniosExpLaboralDocente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            d.setNombres(txtNombresDocente.getText());
            d.setApellidos(txtApellidosDocente.getText());
            d.setIdentificacion(txtIdentificacionDocente.getText());
            d.setDireccion(txtDireccionDocente.getText());
            d.setTelefono(txtTelefonoDocente.getText());
            d.setCiudad(txtCiudadDocente.getText());
            d.setFechaNacimiento(txtFechaNacimientoDocente.getText());
            d.setGenero(Utilidades.getComboGenero(cbxGeneroDocente));
            d.setTituloTercerNivel(txtTTercerNivelDocente.getText());
            d.setTituloCuartoNivel(txtTTCuartoNivelDocente.getText());
            d.setAniosExpDocente(Integer.parseInt(txtAniosExpDocente.getText()));
            d.setAniosExpLaboral(Integer.parseInt(txtAniosExpLaboralDocente.getText()));
            d.setAsignaturas(new ListaEnlazada<>());
        }
        return d;

    }

    public void modificarDocente() {
        if (txtNombresDocente.getText().isEmpty() || txtApellidosDocente.getText().isEmpty()
                || txtIdentificacionDocente.getText().isEmpty() || txtDireccionDocente.getText().isEmpty()
                || txtTelefonoDocente.getText().isEmpty() || txtFechaNacimientoDocente.getText().isEmpty()
                || txtAniosExpDocente.getText().isEmpty() || txtAniosExpLaboralDocente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            docente.setNombres(txtNombresDocente.getText());
            docente.setApellidos(txtApellidosDocente.getText());
            docente.setIdentificacion(txtIdentificacionDocente.getText());
            docente.setDireccion(txtDireccionDocente.getText());
            docente.setTelefono(txtTelefonoDocente.getText());
            docente.setCiudad(txtCiudadDocente.getText());
            docente.setFechaNacimiento(txtFechaNacimientoDocente.getText());
            docente.setGenero((Generos) cbxGeneroDocente.getSelectedItem());
            docente.setTituloTercerNivel(txtTTercerNivelDocente.getText());
            docente.setTituloCuartoNivel(txtTTCuartoNivelDocente.getText());
            docente.setAniosExpDocente(Integer.parseInt(txtAniosExpDocente.getText()));
            docente.setAniosExpLaboral(Integer.parseInt(txtAniosExpLaboralDocente.getText()));
        }
    }

    public void cargarDatos() {
        txtNombresDocente.setText(docente.getNombres());
        txtApellidosDocente.setText(docente.getApellidos());
        txtIdentificacionDocente.setText(docente.getIdentificacion());
        txtDireccionDocente.setText(docente.getDireccion());
        txtTelefonoDocente.setText(docente.getTelefono());
        txtCiudadDocente.setText(docente.getCiudad());
        txtFechaNacimientoDocente.setText(docente.getFechaNacimiento());
        cbxGeneroDocente.setSelectedItem(docente.getGenero());
        txtTTercerNivelDocente.setText(docente.getTituloTercerNivel());
        txtTTCuartoNivelDocente.setText(docente.getTituloCuartoNivel());
        txtAniosExpDocente.setText(docente.getAniosExpDocente().toString());
        txtAniosExpLaboralDocente.setText(docente.getAniosExpLaboral().toString());
    }
    
    public void cargarCampoFecha(){
        if(txtFechaNacimientoDocente.getText().equals("dd/mm/aaaa")){
            txtFechaNacimientoDocente.setText("");
            txtFechaNacimientoDocente.setForeground(Color.black);
        }
    }
    
    public void generarCuenta(Docente docente) {
        Cuenta c = new Cuenta();
        c.setEstado(false);
        c.setTipoUser("Docente");
        c.setId(Utilidades.listarCuentas().getSize() + 1);
        docente.setCuenta(c);
        Utilidades.generarUsuario(docente);
        Utilidades.generarContrasenia(docente);
        Utilidades.guardarCuentas(c);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNombresDocente = new javax.swing.JTextField();
        txtApellidosDocente = new javax.swing.JTextField();
        txtIdentificacionDocente = new javax.swing.JTextField();
        txtDireccionDocente = new javax.swing.JTextField();
        txtTelefonoDocente = new javax.swing.JTextField();
        txtCiudadDocente = new javax.swing.JTextField();
        txtFechaNacimientoDocente = new javax.swing.JTextField();
        cbxGeneroDocente = new javax.swing.JComboBox<>();
        txtTTercerNivelDocente = new javax.swing.JTextField();
        txtTTCuartoNivelDocente = new javax.swing.JTextField();
        txtAniosExpDocente = new javax.swing.JTextField();
        txtAniosExpLaboralDocente = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Docente"));

        jLabel1.setText("Nombres");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Identificacion");

        jLabel4.setText("Direccion");

        jLabel5.setText("Telefono");

        jLabel6.setText("Ciudad");

        jLabel7.setText("Fecha de Nacimiento");

        jLabel8.setText("Genero");

        jLabel9.setText("Titulo de Tercer Nivel");

        jLabel10.setText("Titulo de Cuarto Nivel");

        jLabel11.setText("Experencia de Docente");

        jLabel12.setText("Experencia Laboral");

        txtFechaNacimientoDocente.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaNacimientoDocente.setText("dd/mm/aaaa");
        txtFechaNacimientoDocente.setToolTipText("");
        txtFechaNacimientoDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaNacimientoDocenteMousePressed(evt);
            }
        });
        txtFechaNacimientoDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoDocenteActionPerformed(evt);
            }
        });

        cbxGeneroDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAniosExpLaboralDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAniosExpDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTTCuartoNivelDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTTercerNivelDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxGeneroDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentificacionDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombresDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidosDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudadDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaNacimientoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombresDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidosDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdentificacionDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccionDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefonoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCiudadDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFechaNacimientoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxGeneroDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTTercerNivelDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTTCuartoNivelDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAniosExpDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtAniosExpLaboralDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (docente == null) {
            this.docente = crearDocente();
            if (docente.getNombres() != null || docente.getApellidos() != null || docente.getFechaNacimiento() != null) {
                generarCuenta(docente);
                JOptionPane.showMessageDialog(this, "Docente ingresado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } else {
            modificarDocente();
            JOptionPane.showMessageDialog(this, "Docente modificado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtFechaNacimientoDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoDocenteActionPerformed

    private void txtFechaNacimientoDocenteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaNacimientoDocenteMousePressed
        cargarCampoFecha();
    }//GEN-LAST:event_txtFechaNacimientoDocenteMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogDocente dialog = new DialogDocente(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
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
    private javax.swing.JComboBox<String> cbxGeneroDocente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAniosExpDocente;
    private javax.swing.JTextField txtAniosExpLaboralDocente;
    private javax.swing.JTextField txtApellidosDocente;
    private javax.swing.JTextField txtCiudadDocente;
    private javax.swing.JTextField txtDireccionDocente;
    private javax.swing.JTextField txtFechaNacimientoDocente;
    private javax.swing.JTextField txtIdentificacionDocente;
    private javax.swing.JTextField txtNombresDocente;
    private javax.swing.JTextField txtTTCuartoNivelDocente;
    private javax.swing.JTextField txtTTercerNivelDocente;
    private javax.swing.JTextField txtTelefonoDocente;
    // End of variables declaration//GEN-END:variables
}
