/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5_2;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hilo principal iniciando.");
        Mihilo miHilo1 = Mihilo.crearYComenzar("hilo 1");
        Mihilo miHilo2 = Mihilo.crearYComenzar("hilo 2");
        Mihilo miHilo3 = Mihilo.crearYComenzar("hilo 3");
        
        try{
            miHilo1.hilo.join();
            System.out.println("hilo 1 unido");
            miHilo2.hilo.join();
            System.out.println("hilo 2 unido");
            miHilo3.hilo.join();
            System.out.println("hilo 3 unido");
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        
        System.out.println("Hilo principal finalizado.");
        
    }
    
}

class Mihilo implements Runnable{
    
    Thread hilo;
    
    public Mihilo(String nombre){
        hilo= new Thread(this,nombre);
    }
    
    public static Mihilo crearYComenzar (String nombre){
        Mihilo miHilo=new Mihilo(nombre);
        miHilo.hilo.start();
        return miHilo;
    }
    
    public void run(){
        System.out.println(hilo.getName()+" iniciando.");
        
        try {
            for (int count=0; count<10;count++){
            Thread.sleep(400);
            System.out.println("En "+hilo.getName()+ ", el recuento es "+count);
            }
        }catch (InterruptedException exc){
            System.out.println(hilo.getName()+ " interrumpudo.");
        }
        System.out.println(hilo.getName()+" terminado.");
    }
}