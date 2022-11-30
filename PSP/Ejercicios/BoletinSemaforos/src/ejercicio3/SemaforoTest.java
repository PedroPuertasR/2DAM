/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class SemaforoTest {

    private static final int contador = 100;
    private int x = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SemaforoTest st = new SemaforoTest();
        st.iniciar();
        
    }

    public void iniciar() {
        try {
            MiSemaforo s = new MiSemaforo(1);
            
            Hilo h1 = new Hilo(s);
            Hilo h2 = new Hilo(s);
            Hilo h3 = new Hilo(s);
            
            h1.start();
            h2.start();
            h3.start();
            
            h1.join();
            h2.join();
            h3.join();
            
            if(x == 3 * contador){
                System.out.println("Todo OK.");
            }else{
                System.out.println("Condición de carrera.");
            }
        } catch (InterruptedException ex) {
            System.out.println("Error en el inicio del programa.");
        }
    }

    class Hilo extends Thread {

        private final MiSemaforo semaforo;

        public Hilo(MiSemaforo s) {
            this.semaforo = s;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < contador; i++) {
                    semaforo.acquire();
                    x += 1;
                    semaforo.release();
                }
            } catch (InterruptedException ex) {
                System.out.println("Problema en el hilo");
            }
        }

    }
}
