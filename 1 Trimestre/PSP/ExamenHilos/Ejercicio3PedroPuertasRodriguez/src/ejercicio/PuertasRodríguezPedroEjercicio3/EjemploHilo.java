/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author alumno
 */
public class EjemploHilo implements Runnable {

    private String n;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        int prio = 1;

        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        for (int i = 0; i < 4; i++) {
            //Creamos el hilo y le damos nombre.
            Thread hilo = new Thread(new EjemploHilo("HILO " + (i + 1)));
            //Le indicamos la prioridad con nuestra variable prio.
            hilo.setPriority(prio);
            //Iniciamos el hilo
            hilo.start();
            hilo.join();

            //Incrementamos nuestra variable prio para el siguiente hilo.
            prio += 2;

        }

    }

    //Creamos un constructor donde guarda el número del hilo
    public EjemploHilo(String n) {
        this.n = n;
    }

    /* En nuestro método run mostramos la información de hilo y el contador de
    * hilos totales
    */
    @Override
    public void run() {
        System.out.println("Información del hilo: " + Thread.currentThread().toString());
        //Indicamos en que hilo nos encontramos
        System.out.println("Dentro del " + n);
        System.out.println("\tPrioridad: " + Thread.currentThread().getPriority());
        System.out.println("\tID: " + Thread.currentThread().getId());
        System.out.println("\tHilos activos: " + Thread.activeCount());
    }
}
