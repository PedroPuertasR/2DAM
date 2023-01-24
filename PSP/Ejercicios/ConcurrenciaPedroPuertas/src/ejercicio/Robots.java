/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author pedro
 */
public class Robots {

    public static int tam = 10;
    public static int[] prod = new int[tam];
    public static Semaphore colocar = new Semaphore(tam, true);
    public static Semaphore[] emp = {new Semaphore(0), new Semaphore(0), new Semaphore(0)};
    public static int nEmpa = 0;
    public static Semaphore mutex = new Semaphore(1, true);
    public static Random r = new Random();

    
    public static class Colocador extends Thread {
        public void run() {
            
            int i, n;
            
            while (true) {
                try {
                    /*Generamos un random con un máximo de 3 para indicar 
                    * que tipo debe producir
                    */
                    n = r.nextInt(3) + 1;
                    System.out.println("Produciendo tipo " + n);
                    sleep(r.nextInt(1000));
                    
                    //Esperamos hasta que se libere un recurso para realizar el proceso
                    colocar.acquire();
                    i = 0;
                    
                    /* Con esta condición hacemos que se recorra nuestro array
                    * hasta que encuentre un hueco libre para colocar el objeto.
                    */
                    while (prod[i] != 0) {
                        i++;
                    }

                    //Una vez encontrado el hueco lo coloca y lo mostramos
                    prod[i] = n;
                    System.out.println("Coloco un producto " + n + " en la posición " 
                            + i + "\n" + Arrays.toString(prod));
                    //Liberamos el recurso
                    emp[n - 1].release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Empaquetador extends Thread {

        private int tipo;

        public Empaquetador(int tipo) {
            this.tipo = tipo;

        }

        public void run() {
            int i;
            while (true) {
                try {
                    //Se adquiere el recurso del semáforo específico del tipo
                    emp[tipo - 1].acquire();

                    i = 0;
                    //Con este bucle buscamos en el array nuestro tipo para empaquetarlo
                    while (prod[i] != tipo) {
                        i++;
                    }
                    
                    //Esperamos un tiempo aleatorio para el empaquetado y lo indicamos
                    sleep(r.nextInt(1000));
                    System.out.println("Robot tipo " + tipo 
                            + " empaqueta el producto de la posición " + i);
                    //Una vez empaquetado vaciamos la posición y liberamos el recurso
                    prod[i] = 0;
                    colocar.release();
                    
                    /*Esperamos 2 segundos para adquirir el recurso del mutex, 
                    * sumar uno a los productos empaquetados y mostrarlo en
                    * pantalla
                    */
                    sleep(2000);
                    mutex.acquire(); 
                    nEmpa++;

                    System.out.println("Aumenta el número de empaquetados: " + nEmpa);

                    //Liberamos el mutex para que el siguiente pueda sumar al empaquetado
                    mutex.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
