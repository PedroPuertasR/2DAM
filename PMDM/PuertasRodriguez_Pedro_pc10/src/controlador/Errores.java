/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Errores {
    
    private int error;
    private String msg;

    public Errores(int error, String msg) {
        this.error = error;
        
        switch(error){
            case 1:
                this.msg = "Error en el login";
                break;
            case 2:
                this.msg = "Error de acceso al servidor";
                break;
            case 3:
                this.msg = "Error de SQL";
                break;
            default:
                this.msg = "Error general de la aplicación";
        }
    }
    
    public String mostrarError(){
        
        String errorS = "Error Nº " + error + ": " + msg;
        
        return errorS;
    }
    
    
    
}
