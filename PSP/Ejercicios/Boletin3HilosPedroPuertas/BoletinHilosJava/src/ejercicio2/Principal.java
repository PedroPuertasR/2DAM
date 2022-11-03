/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author alumno
 */

public class Principal{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Comienzo del hilo principal.");
        
        MiHilo primero = new MiHilo("primero");
        
        Thread t = new Thread(primero);
        
        t.start();
        
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("El hilo principal ha tenido un error.");
        }
        
        System.out.println("El hilo principal ha terminado.");
    }
}

class MiHilo implements Runnable {
    
    String nombre;
    
    public MiHilo(String nombre){
        
        this.nombre = nombre;
        
    }
    
    public void run(){
        
        System.out.println("Inicio del hilo "+ nombre);
        
        try {
            for (int i = 0; i < 10; i++){
                Thread.sleep(1000);
                System.out.println("En el hilo " + nombre + ", contador = "+ i);
            }
        }catch (InterruptedException e){
            System.out.println("Fallo del hilo: " + nombre);
        }
        
        System.out.println("Final del hilo: " + nombre);
        
    }
}