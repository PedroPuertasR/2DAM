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
        
        System.out.println("Iniciando el hilo principal.");
        
        MiHilo primero = new MiHilo("primero");
        
        /*Como esta vez extendemos de Thread podemos iniciar el hilo 
        * directamente desde nuestro objeto MiHilo
        */
        primero.start();
        
        for (int i = 0; i < 10; i++){            
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                System.out.println("El hilo principal ha fallado.");
            }
        }
        
        System.out.println("El hilo principal ha finalizado.");
        
    }
}

class MiHilo extends Thread{
    
    /* Esta vez utilizaremos la extenderemos de la clase Thread, por lo que
    * no necesitamos crear atributos, puesto que están en la clase madre
    */
    public MiHilo(String nombre){
        super(nombre);
    }

    @Override
    public void run(){
        
        /*Indicamos el inicio y mostramos el nombre del hilo 
        *con el método getName()
        */
        System.out.println("Iniciamos el hilo " + getName());
    
    try {
        /* Realizamos de nuevo el contador con nuestro hilo pausándolo cada
        * 1 segundo e indicando el número por el que vamos
        */
        for (int i = 0; i < 10; i++){
            Thread.sleep(1000);
            System.out.println("En el hilo " + getName() + ", contador = " + i);
        }
    }catch (InterruptedException e){
        System.out.println("Fallo del hilo: " + getName());
    }
    
        //Indicamos la finalización del hilo
        System.out.println("Final del hilo: " + getName());
    }
}