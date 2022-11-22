/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LoginController;
import controlador.TablaController;
import controlador.UpdateController;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Tienda;
import modelo.Trabajador;

/**
 *
 * @author alumno
 */
public class PanelTrabajador extends javax.swing.JPanel {

    private boolean modificar;
    private static String foto = null;
    
    /**
     * Creates new form PanelTrabajador
     */
    public PanelTrabajador(boolean modificar) {
        
        this.modificar = modificar;
        
        initComponents();

        comprobarBotones();
        cargarDatos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTrabajador = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        lblApe = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        btnFoto = new javax.swing.JButton();
        lblTienda = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfApe = new javax.swing.JTextField();
        tfSalario = new javax.swing.JTextField();
        tfDni = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        fcFoto = new javax.swing.JFileChooser();
        cbTienda = new javax.swing.JComboBox<>();

        pnlTrabajador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setText("Nombre:");
        pnlTrabajador.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 35, -1, -1));

        lblSalario.setText("Salario:");
        pnlTrabajador.add(lblSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 109, -1, -1));

        lblFoto.setText("FOTO");
        pnlTrabajador.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 12, 170, 166));

        lblApe.setText("Apellidos:");
        pnlTrabajador.add(lblApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 72, -1, -1));

        lblDni.setText("DNI:");
        pnlTrabajador.add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 146, -1, -1));

        lblFecha.setText("Contratación:");
        pnlTrabajador.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 185, -1, -1));
        pnlTrabajador.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 181, 249, -1));

        btnFoto.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnFoto.setText("Cambiar foto");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });
        pnlTrabajador.add(btnFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 218, -1, -1));

        lblTienda.setText("ID Tienda:");
        pnlTrabajador.add(lblTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 221, -1, -1));
        pnlTrabajador.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 33, 249, -1));
        pnlTrabajador.add(tfApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 70, 249, -1));
        pnlTrabajador.add(tfSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 107, 249, -1));
        pnlTrabajador.add(tfDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 144, 249, -1));

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlTrabajador.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 319, -1, -1));

        fcFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcFotoActionPerformed(evt);
            }
        });
        pnlTrabajador.add(fcFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        fcFoto.setVisible(false);

        cbTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlTrabajador.add(cbTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        
        btnFoto.setVisible(false);
        btnGuardar.setVisible(false);
        tfDni.setVisible(false);
        tfNombre.setVisible(false);
        tfApe.setVisible(false);
        tfSalario.setVisible(false);
        cbTienda.setVisible(false);
        lblApe.setVisible(false);
        lblDni.setVisible(false);
        lblFoto.setVisible(false);
        lblNombre.setVisible(false);
        lblSalario.setVisible(false);
        lblTienda.setVisible(false);
        lblFecha.setVisible(false);
        dcFecha.setVisible(false);
        
        fcFoto.setVisible(true);
        
    }//GEN-LAST:event_btnFotoActionPerformed

    private void fcFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcFotoActionPerformed
       
        foto = fcFoto.getSelectedFile().getName(); 
        
        lblFoto.setIcon(new ImageIcon(System.getProperty("user.dir") 
                + "/src/fotos/" + foto));
        
        btnFoto.setVisible(true);
        btnGuardar.setVisible(true);
        tfDni.setVisible(true);
        tfNombre.setVisible(true);
        tfApe.setVisible(true);
        tfSalario.setVisible(true);
        cbTienda.setVisible(true);
        lblApe.setVisible(true);
        lblDni.setVisible(true);
        lblFoto.setVisible(true);
        lblNombre.setVisible(true);
        lblSalario.setVisible(true);
        lblTienda.setVisible(true);
        lblFecha.setVisible(true);
        dcFecha.setVisible(true);
        
        fcFoto.setVisible(false);
        
    }//GEN-LAST:event_fcFotoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        int filas = UpdateController.updateFoto(foto, LoginController.getTrabajador());
        
        JOptionPane.showMessageDialog(null, "Filas afectadas: " + filas);
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void comprobarBotones(){
        
        if(modificar){
            btnFoto.setVisible(true);
            btnGuardar.setVisible(true);
            tfDni.setEnabled(true);
            tfNombre.setEnabled(false);
            tfApe.setEnabled(false);
            tfSalario.setEnabled(false);
            cbTienda.setEnabled(false);
            fcFoto.setVisible(false);
        }else{
            btnFoto.setVisible(false);
            btnGuardar.setVisible(false);
            tfDni.setEnabled(false);
            tfNombre.setEnabled(false);
            tfApe.setEnabled(false);
            tfSalario.setEnabled(false);
            cbTienda.setEnabled(false);
        }
        
    }
    
    private void cargarDatos() {
        ArrayList <Tienda> listaTienda = new ArrayList <Tienda>();
        listaTienda = TablaController.getTiendas();
        String [] tiendas = new String [(listaTienda.size())];
        
        Trabajador t = LoginController.getTrabajador();
        
        for (int i = 0; i < tiendas.length; i++) {
            tiendas[i] = listaTienda.get(i).getDireccion();
        }
        
        DefaultComboBoxModel <String> cbT = new DefaultComboBoxModel(tiendas);
        
        cbTienda.setModel(cbT);
        
        tfDni.setText(t.getDni());
        tfNombre.setText(t.getNombre());
        tfApe.setText(t.getApellidos());
        tfSalario.setText("" + t.getSalario());
        lblFoto.setIcon(new ImageIcon(System.getProperty("user.dir") 
                + "/src/fotos/" + t.getFoto()));
        dcFecha.setCalendar(t.getFechaCont());
        cbTienda.setSelectedIndex(t.getTienda());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbTienda;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JFileChooser fcFoto;
    private javax.swing.JLabel lblApe;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblTienda;
    private javax.swing.JPanel pnlTrabajador;
    private javax.swing.JTextField tfApe;
    private javax.swing.JTextField tfDni;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfSalario;
    // End of variables declaration//GEN-END:variables
}