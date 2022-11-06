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
        
        //Instanciamos nuestros hilos
        PrioridadHilos ph1 = new PrioridadHilos("Prioridad Alta");
        PrioridadHilos ph2 = new PrioridadHilos("Prioridad Baja");
        PrioridadHilos ph3 = new PrioridadHilos("Prioridad Normal 1");
        PrioridadHilos ph4 = new PrioridadHilos("Prioridad Normal 2");
        PrioridadHilos ph5 = new PrioridadHilos("Prioridad Normal 3");

        /*Seteamos la prioridad máxima al de prioridad alta y la mínima al de
        * prioridad baja. Los demás seguirán teniendo la normal
        */
        ph1.t.setPriority(Thread.MAX_PRIORITY);
        ph2.t.setPriority(Thread.MIN_PRIORITY);

        //Iniciamos nuestros hilos
        ph1.t.start();
        ph2.t.start();
        ph3.t.start();
        ph4.t.start();
        ph5.t.start();
        
        try {
            
            /* Realizamos los join de cada hilo para que vaya ejecutandose
            * el siguiente cuando "muera" el anterior
            */
            ph1.t.join();
            ph2.t.join();
            ph3.t.join();
            ph4.t.join();
            ph5.t.join();
            
        }catch (InterruptedException e){
            System.out.println("Hilo principal interrumpido.");
        }
        
        //Mostramos hasta donde han contado nuestros hilos
        System.out.println("\nEl hilo de alta prioridad contó hasta: " + ph1.contador);
        System.out.println("El hilo de baja prioridad contó hasta: " + ph2.contador);
        System.out.println("El hilo de prioridad normal 1 contó hasta: " + ph3.contador);
        System.out.println("El hilo de prioridad normal 2 contó hasta: " + ph4.contador);
        System.out.println("El hilo de prioridad normal 3 contó hasta: " + ph5.contador);  
        
    }
}

class PrioridadHilos implements Runnable {
    
    int contador;
    Thread t;
    static boolean stop = false;
    static String actual;
    
    /*Creamos un constructor para instanciar el Thread, iniciar el contador a 0
    * e indicar el nombre actual del hilo
    */
    public PrioridadHilos(String nombre){
        t = new Thread(this,nombre);
        contador = 0;
        actual = nombre;
    }
    
    public void run(){
        
        System.out.println("Iniciamos el hilo " + t.getName());
        
        /*Con este bucle iremos mostrando en que hilo estamos actualmente
        * mientras que stop no sea verdadero y el contador no llegue a 10
        */
        do {
            //Sumamos uno al contador cada vez que empecemos el bucle
            contador++;
            
            if (actual.compareTo(t.getName()) != 0){
                actual = t.getName();
                System.out.println("En el hilo: " + actual);
            }
        }while(stop == false && contador < 10);
        
        stop = true;
        
        System.out.println("Final del hilo: " + t.getName());
        
    }
}