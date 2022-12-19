/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2pedropuertas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        final Interfaz app = new Interfaz();

        //Lo que pasa si cerramos la ventana
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            //Pone el focus (foco de atencion)
            public void windowActivated(WindowEvent e) {
                app.setFocus();
            }
        });
        app.pack();
        app.setVisible(true);
        
    }
    
}
