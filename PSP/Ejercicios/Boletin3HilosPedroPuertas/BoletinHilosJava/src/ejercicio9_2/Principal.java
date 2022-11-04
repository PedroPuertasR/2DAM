/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9_2;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MiHilo mh1=MiHilo.crearEIniciar("Mi Hilo");
        
        try {
            Thread.sleep(1000);//dejar que el primer hilo comience a ejecutarse
            mh1.suspenderhilo();
            System.out.println("Suspendiendo Hilo.");
            Thread.sleep(1000);
            mh1.renaudarhilo();
            System.out.println("Renaudando Hilo.");
            Thread.sleep(1000);
            mh1.suspenderhilo();
            System.out.println("Suspendiendo Hilo.");
            Thread.sleep(1000);
            mh1.renaudarhilo();
            System.out.println("Renaudando Hilo.");
            Thread.sleep(1000);
            mh1.suspenderhilo();
            System.out.println("Pausando Hilo.");
            mh1.pausarhilo();
        }catch (InterruptedException e){
            System.out.println("Hilo principal interrumpido.");
        }
        
        try {
            mh1.hilo.join();
        }catch (InterruptedException e){
            System.out.println("Hilo principal interrumpido.");
        }
        
        System.out.println("Hilo principal finalizado.");
        
    }  
}

class MiHilo implements Runnable{
    
    Thread hilo;
    boolean suspender;
    boolean pausar;
    
    public MiHilo (String nombre){
        hilo=new Thread(this,nombre);
        suspender=false;
        pausar=false;
    }
    
    public static MiHilo crearEIniciar(String nombre){
        MiHilo miHilo=new MiHilo(nombre);
        miHilo.hilo.start(); //Iniciar el hilo
        return miHilo;
    }
    
    public void run() {
        System.out.println(hilo.getName()+ " iniciando.");
        try {
            for (int i=1;i<1000;i++){
                System.out.print(i+" ");
                
                if ((i%10)==0){
                    System.out.println();
                    Thread.sleep(250);
                }
                synchronized (this) {
                    while (suspender) {
                        wait();
                    }
                    if (pausar) break;
                }
            }
        }catch (InterruptedException exc){
            System.out.println(hilo.getName()+ "interrumpido.");
        }
        System.out.println(hilo.getName()+ " finalizado.");
    }

    synchronized void pausarhilo(){
        pausar=true;
        suspender=false;
        notify();
    }

    synchronized void suspenderhilo(){
        suspender=true;
    }
    
    synchronized void renaudarhilo(){
        suspender=false;
        notify();
    }
}
