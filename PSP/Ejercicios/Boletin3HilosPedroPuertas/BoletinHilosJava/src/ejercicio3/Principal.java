/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 *
 * @author alumno
 */
public class Principal{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Iniciando hilo principal.");
        
        MiHilo primero = new MiHilo("primero");
        
        Thread t = new Thread(primero);
        
        t.start();
        
        for (int i=0;i < 50; i++){            
            try {
                Thread.sleep(100);
            }catch (InterruptedException exc) {
                System.out.println("Hilo principal interrumpido");
            }
        }
        
        System.out.println("Hilo principal finalizado");
        
    }
}

class MiHilo extends Thread{
    
    public MiHilo(String nombre){
        super(nombre);
    }

    public void run(){
        System.out.println(getName()+" iniciando.");
    
    try {
        for (int cont=0;cont<10;cont++){
            Thread.sleep(400);
            System.out.println("En " + getName() + ", el recuento es "+cont);
        }
    }catch (InterruptedException e){
        System.out.println(getName()+ "interrumpido.");
    }
        System.out.println(getName()+ "finalizando.");
    }
}