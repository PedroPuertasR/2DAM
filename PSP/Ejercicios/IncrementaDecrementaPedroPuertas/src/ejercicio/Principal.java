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
        
        Contador cont = new Contador(100);
        HiloA a = new HiloA("HiloA", cont);
        a.start();
        HiloB b = new HiloB("HiloB", cont);
        b.start();
        
    }
    
}

class HiloA extends Thread {

    private Contador contador;

    public HiloA(String n, Contador c) {
        setName(n);
        contador = c;
    }

    @Override
    public void run() {
        synchronized (contador) {
            for (int j = 0; j < 300; j++) {
                contador.incrementa();
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Error en el hilo A");
                }
            }
            System.out.println("\n"+getName() + "Hilo A. Contador vale :" + contador.getValor());
        }
    }
}

class HiloB extends Thread {

    private Contador contador;

    public HiloB(String n, Contador c) {
        setName(n);
        contador = c;
    }

    @Override
    public void run() {
        synchronized (contador) {
            for (int j = 0; j < 300; j++) {
                contador.decrementa();
                try {

                    sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Se ha producido un error en el hilo A");
                }
            }
            System.out.println("\n"+getName() + "Hilo B. Contador vale :" + contador.getValor());
        }
    }
}

class Contador {

    private int c = 0;

    Contador(int c) {
        this.c = c;
    }

    public synchronized void incrementa() {

        if (c > 300) {

            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en el incrementa.");
            }
        } else {
            c = c + 1;
            notify();
        }
        System.out.print("I - ");

    }

    public synchronized void decrementa() {

        if (c < 1) {

            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Error en el decrementa.");
            }
        } else {
            c = c - 1;
            notify();
        }
        System.out.print("D - ");

    }

    public synchronized int getValor() {
        return c;
    }
}