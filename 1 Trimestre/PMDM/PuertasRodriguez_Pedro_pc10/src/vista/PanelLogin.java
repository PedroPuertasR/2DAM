/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDB;
import controlador.LoginController;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import modelo.Usuario;

/**
 *
 * @author alumno
 */
public class PanelLogin extends javax.swing.JPanel {

    private JMenu vista;
    private JMenuItem abrir;
    private JMenuItem cerrar;
    private JMenuItem salir;
    
    /**
     * Creates new form PanelLogin
     */
    public PanelLogin(JMenu vista, JMenuItem abrir, JMenuItem cerrar, JMenuItem salir) {
        
        this.vista = vista;
        this.abrir = abrir;
        this.cerrar = cerrar;
        this.salir = salir;
        
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        tfPass = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();

        lblUsuario.setText("Usuario:");

        lblPass.setText("Contraseña:");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPass)
                            .addComponent(lblUsuario))
                        .addGap(29, 29, 29)
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPass, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(tfUsuario)))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnLogin)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnLogin)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        GestionDB.open();
        
        String usuario = tfUsuario.getText();
        String pass = tfPass.getText();
        
        Usuario aux = LoginController.getConexion(usuario, pass);
        
        comprobarConex(aux);
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void comprobarConex(Usuario aux){
        if(aux != null){
            
            this.setVisible(false);
            vista.setEnabled(true);
            abrir.setEnabled(false);
            cerrar.setEnabled(true);
            
        }else{
            
            vista.setEnabled(false);
            abrir.setEnabled(true);
            cerrar.setEnabled(false);
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JTextField tfPass;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
