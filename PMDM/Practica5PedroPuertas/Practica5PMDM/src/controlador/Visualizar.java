/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JPanel;

/**
 *
 * @author alumno
 */
public class Visualizar {
    
    public static JPanel actual = null;
    
    public Visualizar(){
    }
    
    public static void cambiarPanel(JPanel nuevo){
        actual = nuevo;
    }
    
}
