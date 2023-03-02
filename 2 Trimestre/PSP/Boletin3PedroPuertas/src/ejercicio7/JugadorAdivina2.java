package ejercicio7;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JugadorAdivina2 extends javax.swing.JFrame {
    
        String host = "localhost";
        int puerto = 6000;
        Socket jugador;
        ObjectOutputStream objectSalida;
        ObjectInputStream objectEntrada;
        Scanner sc;
        String cadena = "";
        Datos datos;
        int identificador;

    public JugadorAdivina2() {
        initComponents();
        try {
            //Instancia del socket, el id, la lectura y los flujos
            jugador = new Socket(host, puerto);
            objectSalida = new ObjectOutputStream(jugador.getOutputStream());
            objectEntrada = new ObjectInputStream(jugador.getInputStream());
            sc = new Scanner(System.in);
            datos = (Datos) objectEntrada.readObject();
            identificador = datos.getIdentificador();
        } catch (ClassNotFoundException ex) {
            System.out.println("El flujo no leyó los datos correctamente");
        } catch (IOException ex) {
            System.out.println("Socket mal creado o flujos incorrectos");
        }
        //Modificamos el texto de la interfaz con los datos del jugador
        tfID.setText(identificador+"");
        lblInfo.setText(datos.getCadena());
        
        //Actualización de los intentos
        actIntentos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        lblIntentos = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        tfIntentos = new javax.swing.JTextField();
        lblEscribir = new javax.swing.JLabel();
        tfEscribir = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblID.setText("ID:");

        lblIntentos.setText("Intentos:");

        lblEscribir.setText("Escriba el número:");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lblInfo.setText("Adivinanza:");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEscribir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfEscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfIntentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnSalir)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIntentos)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEscribir)
                    .addComponent(tfEscribir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar))
                .addGap(49, 49, 49)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        //Si ha terminado el juego la cadena será: * lo que parará el juego
        if (!datos.isJuega()) {
            cadena = "*";
        } else 
            //Si el juego sigue en marcha y no hay * en la cadena realizamos lo siguiente
            if (datos.isJuega() && !cadena.trim().equals("*")) {
                cadena = tfEscribir.getText();
                Datos d = new Datos();
                //Si hay un número en la cadena seguimos adelante
                if (validarCadena(cadena)) {
                    d.setCadena(cadena);
                    try {
                        objectSalida.reset();
                        //Escribimos los datos en el flujo de salida y lo recogemos con la variable Datos
                        objectSalida.writeObject(d);
                        datos = (Datos) objectEntrada.readObject();
                    } catch (IOException ex) {
                        Logger.getLogger(JugadorAdivina2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JugadorAdivina2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lblInfo.setText(datos.getCadena());
                    //Si los intentos son mayor o igual a 5 termina el juego, indicando que la cadena es *
                    if (datos.getIntentos() >= 5) {
                        lblInfo.setText("Juego terminado. Se ha alcanzado el máximo"
                                + "de intentos.");
                        cadena = "*";
                    }
                    //Si el jugador gana lo mostramos por pantalla y ponemos cadena como *
                    if (datos.isGana()) {
                        lblInfo.setText("Juego terminado. Has ganado.");
                        cadena = "*";
                    //En caso de que ya haya termiando lo indicamos y ponemos cadena como *
                    } else if (!(datos.isJuega())) {
                        lblInfo.setText("Juego terminado. Se ha adivinado el número.");
                        cadena = "*";
                    }
                }
                //Actualizamos los intentos
                actIntentos();
            }
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
            try {
                /*Cerramos todos los flujos, el socket, la ventana actual y 
                * liberamos todos los recursos asociados con dispose()
                */
                objectSalida.close();
                objectEntrada.close();
                System.out.println("Fin del juego.");
                sc.close();
                jugador.close();
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(JugadorAdivina2.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(JugadorAdivina2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JugadorAdivina2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JugadorAdivina2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JugadorAdivina2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JugadorAdivina2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblEscribir;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblIntentos;
    private javax.swing.JTextField tfEscribir;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfIntentos;
    // End of variables declaration//GEN-END:variables

    //Método para actualizar los intentos en la interfaz
    private void actIntentos() {
        tfIntentos.setText(datos.getIntentos()+"");
    }
    
    //Método para validar que la cadena es un número
    private static boolean validarCadena(String cadena) {
        boolean valor = false;
        try {
            Integer.parseInt(cadena);
            valor = true;
        } catch (NumberFormatException e) {
            System.out.println("ERROR: al transformar la cadena en entero");
        }
        return valor;
    }
}
