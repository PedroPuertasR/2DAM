/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Instanciamos el contador igualado a 100.
        
        Contador cont = new Contador(100);
        
        //Instanciamos los hilos con nuestro contador a 100.
        
        HiloA a = new HiloA("A", cont);
        //Ejecuta el hilo a
        a.start();
        
        HiloB b = new HiloB("B", cont);
        //Ejecuta el hilo b
        b.start();
        
    }
    
}

class HiloA extends Thread {

    private Contador contador;

    public HiloA(String n, Contador c) {
        setName(n);
        contador = c;
    }

    /*Cuando se ejecute el hilo incrementará el contador y en caso de que llegue
    * a su límite se quedará esperando.
    */
    @Override
    public void run() {
        synchronized (contador) {
            for (int i = 0; i < 200; i++) {
                contador.incrementa();
                try {
                    /*Separamos cada incrementa por 10 milisegundos por si hace 
                    *falta que ejecute otro proceso
                    */
                    sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Error en el hilo A");
                }
            }
            //Informamos del valor del contador en el hilo
            System.out.println("\nEn el hilo " + getName() 
                    + ".El contador ha llegado a: " + contador.getValor());
        }
    }
}

class HiloB extends Thread {

    private Contador contador;

    public HiloB(String n, Contador c) {
        setName(n);
        contador = c;
    }

    
    /*Cuando se ejecute el hilo decrementará el contador y en caso de que llegue
    * a su límite se quedará esperando.
    */
    @Override
    public void run() {
        synchronized (contador) {
            for (int i = 0; i < 200; i++) {
                contador.decrementa();
                try {
                    /*Separamos cada decrementa por 10 milisegundos por si hace 
                    *falta que ejecute otro proceso
                    */
                    sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Se ha producido un error en el hilo A");
                }
            }
            //Informamos del valor del contador en el hilo
            System.out.println("\nEn el hilo " + getName() 
                    + ".El contador ha llegado a: " + contador.getValor());
        }
    }
}

class Contador {

    private int c = 0;

    Contador(int c) {
        this.c = c;
    }

    /*Con este método incrementamos el valor de nuestra variable c (el contador)
    * y en caso de que este llegue a 200 quedará bloqueado hasta que otro
    * método lo cambie de estado.
    */
    public synchronized void incrementa() {

        if (c > 200) {

            try {
                //Le indicamos al hilo que espere mientras el contador sea > 200.
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en el incrementa.");
            }
            
        //En caso de que sea menos que 200 sumamos uno y despertamos el hilo.
        } else {
            c = c + 1;
            notify();
        }
        System.out.print("Incremento\t");

    }

    /* Con este método decrementamos el valor del contador y si es menor que 1
    * queda bloqueado el hilo hasta que otro método lo cambie.
    */
    public synchronized void decrementa() {

        if (c < 1) {

            try {
                //Le indicamos al hilo que espere mientras el contador sea < 1.
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en el decrementa.");
            }
        //Despierta el hilo y resta uno al contador.
        } else {
            c = c - 1;
            notify();
        }
        System.out.print("Decremento\t");

    }

    //Devuelve el valor del contador
    public synchronized int getValor() {
        return c;
    }
}