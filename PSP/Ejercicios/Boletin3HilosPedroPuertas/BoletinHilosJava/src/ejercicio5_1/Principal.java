/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5_1;

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
        
        MiHilo miHilo1 = MiHilo.crearYComenzar("hilo 1");
        MiHilo miHilo2 = MiHilo.crearYComenzar("hilo 2");
        MiHilo miHilo3 = MiHilo.crearYComenzar("hilo 3");
        
        do {
            System.out.print(".");
        try{
            Thread.sleep(100);
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        }while (miHilo1.hilo.isAlive() || miHilo2.hilo.isAlive() || miHilo3.hilo.isAlive());
        System.out.println("Hilo Principal finalizado.");

    }
    
}

class MiHilo extends Thread{
    
    Thread hilo;
    
    public MiHilo(String nombre){
        super(nombre);
    }
    
    public static MiHilo crearYComenzar (String nombre){
        MiHilo miHilo=new MiHilo(nombre);
        miHilo.hilo.start();
        return miHilo;
    }
    
    public void run(){
        System.out.println(getName()+" iniciando.");
        
        try {
            for (int cont=0;cont<10;cont++){
                Thread.sleep(400);
                System.out.println("En "+getName()+ ", el recuento es "+cont);
            }
        }catch (InterruptedException exc){
            System.out.println(getName()+ "interrumpido.");
        }
        
        System.out.println(getName()+ "finalizando.");
    }
}