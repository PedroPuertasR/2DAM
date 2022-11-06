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
        
        //Indicamos el inicio del hilo principal
        System.out.println("Hilo principal iniciando.");
        
        MiHilo primero = MiHilo.crearYComenzar("primero");
        MiHilo segundo = MiHilo.crearYComenzar("segundo");
        MiHilo tercero = MiHilo.crearYComenzar("tercero");
        
        /* Gracias al método join podremos ir iniciando un hilo después de
        * que termine el anterior, por lo que en este caso comenzará el tercer
        * hilo y finalizará el hilo principal el primer hilo. Todo gracias a que
        * el método join espera hasta que "muere" el hilo.
        */
        try{
            primero.t.join();
            System.out.println("Primer hilo unido");
            
            segundo.t.join();
            System.out.println("Segundo hilo unido");
            
            tercero.t.join();
            System.out.println("Tercer hilo unido");
            
        }catch (InterruptedException e){
            System.out.println("El hilo principal ha fallado.");
        }
        
        //Indicamos el fin del hilo
        System.out.println("El hilo principal ha finalizado.");
        
    }
    
}

class MiHilo implements Runnable{
    
    //Creamos el atributo Thread puesto que estamos utilizando la interfaz Runnable
    Thread t;
    
    public MiHilo(String nombre){
        t = new Thread(this, nombre);
    }
    
    /* Con este método estático instanciaremos el hilo con su nombre y 
    * lo iniciaremos inmediatamente
    */
    public static MiHilo crearYComenzar (String nombre){
        MiHilo mh = new MiHilo(nombre);
        mh.t.start();
        return mh;
    }
    
    public void run(){
        //Indicamos el inicio del hilo
        System.out.println("Iniciamos el hilo " + t.getName());
        
        try {
            /*Como anteriormente iremos contando cada 1 segundo donde se
            * encuentra el hilo
            */
            for (int i = 0 ; i < 10 ; i++){
                Thread.sleep(1000);
                System.out.println("En el hilo " + t.getName() + ", contador = " + i);
            }
            
        }catch (InterruptedException e){
            System.out.println("Fallo del hilo: " + t.getName());
        }
        
        //Indicamos el final del hilo
        System.out.println("Final del hilo: " + t.getName());
        
    }
}