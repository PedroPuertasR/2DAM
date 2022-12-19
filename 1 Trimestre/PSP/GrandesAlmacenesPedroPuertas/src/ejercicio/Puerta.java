/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Puerta {
    
    private boolean ocupada;
    
    public Puerta(){
        ocupada = false;
    }
    
    public boolean estaOcupada(){
        if(ocupada){
            return true;
        }else{
            return false;
        }
    }
    
    public synchronized void liberarPuerta(){
        ocupada = false;
    }
    
    public synchronized boolean intentarEntrada(){
        while(ocupada){
            System.out.println("La persona debe esperar.");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Puerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("La persona ha entrado.");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Puerta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ocupada = false;
        
        System.out.println("La persona ha salido.");
        
        return ocupada;
        
    }
    
}
