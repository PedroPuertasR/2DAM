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
        
        //Instanciamos una variable MiHilo con el nombre de este
        MiHilo primero = new MiHilo("primero");
        
        //Instaciamos un objeto Thread e incluimos nuestra variable "primero"
        Thread t = new Thread(primero);
        
        //Iniciamos el hilo
        t.start();
        
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("El hilo principal ha tenido un error.");
        }
        
        //Indicamos la finalización del hilo principal
        System.out.println("El hilo principal ha terminado.");
    }
}

class MiHilo implements Runnable {
    
    //Creamos un constructor con el nombre del hilo
    String nombre;
    
    public MiHilo(String nombre){
        
        this.nombre = nombre;
        
    }
    
    @Override
    public void run(){
        
        //Una vez se ejecute el run() comenzará el hilo
        System.out.println("Inicio del hilo "+ nombre);
        
        try {
            /*En este bucle pararemos momentaneamente el hilo durante un segundo
            * y cada vez que se reactive mostraremos el nombre del hilo y el
            * contador
            */
            for (int i = 0; i < 10; i++){
                Thread.sleep(1000);
                System.out.println("En el hilo " + nombre + ", contador = "+ i);
            }
        }catch (InterruptedException e){
            System.out.println("Fallo del hilo: " + nombre);
        }
        
        //Indicamos el final del hilo
        System.out.println("Final del hilo: " + nombre);
        
    }
}