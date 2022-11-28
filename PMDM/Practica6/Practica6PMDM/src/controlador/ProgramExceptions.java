/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class ProgramExceptions extends RuntimeException{
    
    public ProgramExceptions(){
        
    }
    
    public ProgramExceptions(String msg, Throwable err){
        super(msg, err);
        JOptionPane.showMessageDialog(null, msg + err);
    }
    
}
