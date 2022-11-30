/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author alumno
 */
public class ExcepcionProgram extends Exception{
    
    private int error;

    public ExcepcionProgram(int error) {
        this.error = error;
    }
    
    public int getErr(){
        return error;
    }
    
}
