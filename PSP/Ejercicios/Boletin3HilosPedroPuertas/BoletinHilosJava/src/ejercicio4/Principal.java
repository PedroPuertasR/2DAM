/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        
        MiHilo miHilo1 = MiHilo.crearYComenzar("#1");
        MiHilo miHilo2 = MiHilo.crearYComenzar("#2");
        MiHilo miHilo3 = MiHilo.crearYComenzar("#3");
        
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
            Thread.sleep(100);
            } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
            }
        }
        
        System.out.println("Hilo principal finalizado");
    }
    
}

class MiHilo implements Runnable{
    private Thread hilo;
    
    public MiHilo(String nombre){
        hilo= new Thread(this,nombre);
    }
    
    public static MiHilo crearYComenzar (String nombre){
        MiHilo miHilo=new MiHilo(nombre);
        miHilo.hilo.start();
        return miHilo;
    }
    
    public void run(){
        System.out.println(hilo.getName()+" iniciando.");
        try {
            for (int i = 0; i < 10; i++){
                Thread.sleep(400);
                System.out.println("En "+hilo.getName()+ ", el recuento es "+i);
            }
        }catch (InterruptedException e){
            System.out.println(hilo.getName()+ " interrumpudo.");
        }
        
        System.out.println(hilo.getName()+" terminado.");
        
    }
 }