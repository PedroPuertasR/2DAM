/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionDB;
import controlador.LoginController;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import modelo.Profesor;

/**
 *
 * @author alumno
 */
public class Login extends javax.swing.JPanel {

    private JMenu acerca;
    private JMenuItem abrir;
    private JMenuItem cerrar;
    private JMenu visual;
    
    /**
     * Creates new form Abrir
     */
    public Login(JMenu acercaDe, JMenu visual, JMenuItem abrir, JMenuItem cerrar) {
        this.acerca = acercaDe;
        this.visual = visual;
        this.abrir = abrir;
        this.cerrar = cerrar;
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

        panelLogin = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        fieldUsuario = new javax.swing.JTextField();
        fieldPass = new javax.swing.JTextField();
        botonLogin = new javax.swing.JButton();

        labelUsuario.setText("Usuario:");

        labelPass.setText("Contraseña:");

        botonLogin.setText("Login");
        botonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(botonLogin))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPass)
                            .addComponent(labelUsuario))
                        .addGap(58, 58, 58)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldUsuario)
                            .addComponent(fieldPass, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPass)
                    .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(botonLogin)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLoginActionPerformed
        GestionDB.open();

        String usuario = fieldUsuario.getText();
        String pass =  fieldPass.getText();
        
        LoginController.getConexion(usuario, pass);

        comprobarConexion(LoginController.getProf());
    }//GEN-LAST:event_botonLoginActionPerformed

    public void comprobarConexion(Profesor logProf){
        if(logProf != null){
            this.setVisible(false);
            visual.setEnabled(true);
            acerca.setEnabled(true);
            abrir.setEnabled(false);
            cerrar.setEnabled(true);
        }else{
            System.out.println("Acceso denegado.");
            visual.setEnabled(false);
            acerca.setEnabled(false);
            abrir.setEnabled(true);
            cerrar.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLogin;
    private javax.swing.JTextField fieldPass;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelLogin;
    // End of variables declaration//GEN-END:variables
}
