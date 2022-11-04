/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6_3;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PrioridadHilos ph1= new PrioridadHilos("Prioridad Alta h1");
        PrioridadHilos ph2= new PrioridadHilos("Prioridad Baja h2");
        PrioridadHilos ph3= new PrioridadHilos("Prioridad Normal h3");
        PrioridadHilos ph4= new PrioridadHilos("Prioridad Normal h4");
        PrioridadHilos ph5= new PrioridadHilos("Prioridad Normal h5");

        ph1.hilo.setPriority(Thread.NORM_PRIORITY+2);
        ph2.hilo.setPriority(Thread.NORM_PRIORITY-2);

        ph1.hilo.start();
        ph2.hilo.start();
        ph3.hilo.start();
        ph4.hilo.start();
        ph5.hilo.start();
        try {
            ph1.hilo.join();
            ph2.hilo.join();
            ph3.hilo.join();
            ph4.hilo.join();
            ph5.hilo.join();
        }catch (InterruptedException e){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("\nHilo de alta prioridad h1 contó hasta "+ph1.contar);
        System.out.println("Hilo de baja prioridad h2 contó hasta "+ph2.contar);
        System.out.println("Hilo de normal prioridad h3 contó hasta "+ph3.contar);

        System.out.println("Hilo de normal prioridad h4 contó hasta "+ph4.contar);
        System.out.println("Hilo de normal prioridad h5 contó hasta "+ph5.contar);
        
    }
    
}

class PrioridadHilos implements Runnable {
    int contar;
    Thread hilo;
    static boolean stop=false;
    static String actualNombre;
    
    public PrioridadHilos(String nombre){
        hilo= new Thread(this,nombre);
        contar=0;
        actualNombre=nombre;
    }
    
    public void run(){
        System.out.println(hilo.getName()+" iniciando.");
        do {
            contar++;
            if (actualNombre.compareTo(hilo.getName())!=0){
                actualNombre=hilo.getName();
                System.out.println("En "+actualNombre);
            }
        }while (stop==false&&contar<1000000);
        
        stop=true;
        System.out.println("\n"+ hilo.getName()+" terminado.");
    }
}