/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Cliente extends Thread{
    
    private Puerta puerta;
    private Almacen almacen;
    private String nombre;
    private Random generador;
    
    public Cliente(Puerta p, Almacen a, String nombre){
        this.puerta = p;
        this.almacen = a;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        
        
        
    }
    
    public void esperar(){
        
        int num = generador.nextInt(10 - 1 + 1) + 1;
        
        try {
            sleep(1000 * num);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
