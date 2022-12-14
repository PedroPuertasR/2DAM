/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ESaldoNoValido;
import controlador.GestionFicheros;
import controlador.Lista;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

/**
 *
 * @author Pernas
 */
public class GestorDeCuentas extends javax.swing.JFrame {

    private Lista listaNodo;
    private NuevaCuenta panelNuevaCuenta;
    private VisualizaJList jList;
    private Visualiza1a1 panelVisualiza1a1;
    /**
     * Creates new form GestorDeCuentas
     */
    public GestorDeCuentas() {
        listaNodo = new Lista(100);
        //ordenarLista(listaCopia);
        initComponents();

//        Calendar fecha;
//        Cuenta c;
//        
//        try {
//            
//            fecha = seteaCuenta(18,10,2020);
//            c = new CuentaCorriente((float) 0.05, "semestral", "Pepito", 5634, 175, fecha);
//            listaNodo.insertar(c.getNumero(),c);
//            
//            fecha = seteaCuenta(18,7,2021);
//            c = new CuentaInversion(200, "Manu", 34523, 34, fecha);
//            listaNodo.insertar(c.getNumero(),c);
//            
//            fecha = seteaCuenta(18,10,2021);
//            c = new CuentaAhorro(0.1, false, "Ana", 6457, 745, fecha);
//            listaNodo.insertar(c.getNumero(),c);
//            
//            fecha = seteaCuenta(18,4,2020);
//            c = new CuentaCorriente((float) 0.2, "anual", "Juan", 1865, 475, fecha);
//            listaNodo.insertar(c.getNumero(),c);
//            
//            fecha = seteaCuenta(25, 9, 2022);   
//            c = new CuentaInversion(2000, "Alma", 3000, 100, fecha);
//            listaNodo.insertar(c.getNumero(), c);
//            
//        } catch (ESaldoNoValido ex) {
//            Logger.getLogger(GestorDeCuentas.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemCarga = new javax.swing.JMenuItem();
        jMenuItemGuarda = new javax.swing.JMenuItem();
        jMenuNuevaCuenta = new javax.swing.JMenu();
        jMenuItemAhorro = new javax.swing.JMenuItem();
        jMenuItemCorriente = new javax.swing.JMenuItem();
        jMenuVisualizar = new javax.swing.JMenu();
        jMenuItemUnoAUno = new javax.swing.JMenuItem();
        jMenuItemJList = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Opciones Cuentas");

        jMenuItemCarga.setText("Cargar");
        jMenuItemCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCarga);

        jMenuItemGuarda.setText("Guardar");
        jMenuItemGuarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGuarda);

        jMenuNuevaCuenta.setText("Nueva cuenta");

        jMenuItemAhorro.setText("Ahorro");
        jMenuItemAhorro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaCuentaActionPerformed(evt);
            }
        });
        jMenuNuevaCuenta.add(jMenuItemAhorro);

        jMenuItemCorriente.setText("Corriente");
        jMenuItemCorriente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaCuentaActionPerformed(evt);
            }
        });
        jMenuNuevaCuenta.add(jMenuItemCorriente);

        jMenu1.add(jMenuNuevaCuenta);

        jMenuVisualizar.setText("Visualiza");

        jMenuItemUnoAUno.setText("Visualiza 1 a 1");
        jMenuItemUnoAUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUnoAUnoActionPerformed(evt);
            }
        });
        jMenuVisualizar.add(jMenuItemUnoAUno);

        jMenuItemJList.setText("Visualiza JList");
        jMenuItemJList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemJListActionPerformed(evt);
            }
        });
        jMenuVisualizar.add(jMenuItemJList);

        jMenu1.add(jMenuVisualizar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargaActionPerformed
        GestionFicheros.leerFichero(listaNodo);
    }//GEN-LAST:event_jMenuItemCargaActionPerformed

    private void jMenuItemGuardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardaActionPerformed
        GestionFicheros.escribirFichero(listaNodo.getArrayNodos());
    }//GEN-LAST:event_jMenuItemGuardaActionPerformed

    private void nuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaCuentaActionPerformed

        if(panelNuevaCuenta == null) {
            panelNuevaCuenta = new NuevaCuenta(listaNodo);
        } else {
            panelNuevaCuenta.setVisible(true);
        }
        
        setContentPane(panelNuevaCuenta);
        panelNuevaCuenta.vaciarTextFields();
        panelNuevaCuenta.modificaLabels(evt);
    }//GEN-LAST:event_nuevaCuentaActionPerformed

    private void jMenuItemUnoAUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUnoAUnoActionPerformed

        if(panelVisualiza1a1 == null) {
            panelVisualiza1a1 = new Visualiza1a1(listaNodo);
        } else {
            panelVisualiza1a1.setVisible(true);
        }
        setContentPane(panelVisualiza1a1);
        panelVisualiza1a1.comprobarBotones();
        panelVisualiza1a1.mostrarCuenta();
        panelVisualiza1a1.modificaLabels();
    }//GEN-LAST:event_jMenuItemUnoAUnoActionPerformed

    private void jMenuItemJListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemJListActionPerformed
        // TODO add your handling code here:
        if(jList==null){
            jList=new VisualizaJList(listaNodo);
        } else {
            jList.setVisible(true);
        }
        jList.cargarDatosJlist();
        setContentPane(jList);
    }//GEN-LAST:event_jMenuItemJListActionPerformed

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
            java.util.logging.Logger.getLogger(GestorDeCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestorDeCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestorDeCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestorDeCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestorDeCuentas().setVisible(true);
            }
        });
    }
    
//    private Calendar seteaCuenta(int d, int m, int y){
//        Calendar date = Calendar.getInstance();
//        date.set(Calendar.YEAR, y);
//        date.set(Calendar.MONTH, m+1);
//        date.set(Calendar.DAY_OF_MONTH, d);
//
//        return date;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAhorro;
    private javax.swing.JMenuItem jMenuItemCarga;
    private javax.swing.JMenuItem jMenuItemCorriente;
    private javax.swing.JMenuItem jMenuItemGuarda;
    private javax.swing.JMenuItem jMenuItemJList;
    private javax.swing.JMenuItem jMenuItemUnoAUno;
    private javax.swing.JMenu jMenuNuevaCuenta;
    private javax.swing.JMenu jMenuVisualizar;
    // End of variables declaration//GEN-END:variables
}
