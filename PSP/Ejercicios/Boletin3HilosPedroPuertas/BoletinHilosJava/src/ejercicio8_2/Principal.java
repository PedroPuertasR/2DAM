/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8_2;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TicTac tt=new TicTac();
        MiNHilo mh1=MiNHilo.crearEIniciar("Tic",tt);
        MiNHilo mh2=MiNHilo.crearEIniciar("Tac",tt);
        
        try {
            mh1.hilo.join();
            mh2.hilo.join();
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
    }  
}

class TicTac{
    String estado;
    
    synchronized void tic(boolean corriendo){
        if (!corriendo){//Detiene el reloj
            estado="ticmarcado";
            return;
        }

        System.out.print("Tic ");
        estado="ticmarcado";

        try {
            while (!estado.equals("tacmarcado")){
                wait();
            }
        }catch (InterruptedException exc){
            System.out.println("Hilo interrumpido.");
        }
    }

    synchronized void tac(boolean corriendo){
        if (!corriendo){
            estado="tacmarcado";
            notify();
            return;
        }
        
        System.out.println("Tac");
        estado="tacmarcado";
        notify();
        
        try {
            while (!estado.equals("ticmarcado")){
                wait();
            }
        }catch (InterruptedException exc){
            System.out.println("Hilo interrumpido.");
        }
    }
}

class MiNHilo implements Runnable{
    Thread hilo;
    TicTac ttob;
    
    public MiNHilo(String nombre, TicTac tt){
        hilo=new Thread(this,nombre);
        ttob=tt;
    }
    
    public static MiNHilo crearEIniciar(String nombre, TicTac tt){
        MiNHilo miNHilo=new MiNHilo(nombre,tt);
        
        miNHilo.hilo.start();
        return miNHilo;
    }
    public void run(){
        if (hilo.getName().compareTo("Tic")==0){
            for (int i=0; i<5; i++) ttob.tic(true);
            ttob.tic(false);
        }else {
            for (int i=0; i<5;i++) ttob.tac(true);
            ttob.tac(false);
        }
    }
}
