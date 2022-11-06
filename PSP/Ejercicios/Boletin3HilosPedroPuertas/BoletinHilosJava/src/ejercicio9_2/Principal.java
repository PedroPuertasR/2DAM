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

        MiHilo mh1 = MiHilo.crearYComenzar("primero");

        try {
            //El hilo comienza y esperamos un segundo para suspenderlo
            Thread.sleep(1000);
            
            //Suspendemos el hilo y esperaremos un segundo para reanudarlo
            mh1.suspenderhilo();
            System.out.println("Hilo suspendido.");
            Thread.sleep(1000);
            
            //Reanudamos el hilo y esperamos un segundo para suspenderlo
            mh1.renaudarhilo();
            System.out.println("Hilo reestablecido.");
            Thread.sleep(1000);
            
            //Suspendemos el hilo y esperaremos un segundo para reanudarlo
            mh1.suspenderhilo();
            System.out.println("Hilo suspendido.");
            Thread.sleep(1000);
            
            //Reanudamos el hilo y esperamos un segundo para pausarlo
            mh1.renaudarhilo();
            System.out.println("Hilo reestablecido.");
            Thread.sleep(1000);
            
            //Pausamos el hilo y salimos de la cuenta
            mh1.pausarhilo();
            System.out.println("Hilo pausado.");
            
        } catch (InterruptedException e) {
            System.out.println("El hilo principal ha fallado.");
        }

        //Realizamos el join para que los demás hilos esperen a que termine el anterior
        try {
            mh1.t.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido.");
        }

        //Mostramos que el hilo principal ha finalizado
        System.out.println("Hilo principal finalizado.");

    }
}

class MiHilo implements Runnable {

    Thread t;
    boolean suspender;
    boolean pausar;

    //Realizamos un constructor para instanciar el hilo y los demás atributos
    public MiHilo(String nombre) {
        t = new Thread(this, nombre);
        suspender = false;
        pausar = false;
    }

    //Con este método reutilizado instanciamos e inicializamos el hilo
    public static MiHilo crearYComenzar(String nombre) {
        MiHilo mh = new MiHilo(nombre);
        mh.t.start();
        return mh;
    }

    public void run() {
        
        System.out.println("Iniciando el hilo " + t.getName());
        
        try {
            //Con este bucle iremos mostrando por pantalla un contador
            for (int i = 1; i < 100; i++) {
                System.out.println(i);
                
                /*Ponemos una condición para que la cuenta vaya frenando y que
                * le de tiempo al hilo a suspenderse, pausarse o reanudarse
                */
                if (i / 3 > 0){
                    System.out.println();
                    Thread.sleep(100);
                }

                /*Con este bloque synchronized bloquearemos el objeto y 
                * haremos que el hilo se mantenga en espera si suspender es 
                * true y saldremos en caso de que pausar sea true
                */
                synchronized (this) {
                    while (suspender) {
                        wait();
                    }
                    if (pausar) {
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo " + t.getName() + " ha fallado.");
        }
        System.out.println("El hilo " + t.getName() + " ha finalizado.");
    }

    /* Con estos métodos synchronized bloquearemos el objeto y esperaremos a
    * que cambie el estado de este
    */
    
    //Método para pausar
    synchronized void pausarhilo() {
        pausar = true;
        suspender = false;
        //Les indicaremos a los demás hilos el estado de este
        notify();
    }

    //Método para suspender
    synchronized void suspenderhilo() {
        suspender = true;
    }

    //Método para reanudar
    synchronized void renaudarhilo() {
        suspender = false;
        //Les indicaremos a los demás hilos el estado de este
        notify();
    }
}
