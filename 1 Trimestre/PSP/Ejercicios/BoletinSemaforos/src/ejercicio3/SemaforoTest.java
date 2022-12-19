/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

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

        //Instanciamos el SemaforoTest y lo iniciamos para comprobar el resultado.
        SemaforoTest st = new SemaforoTest();
        st.iniciar();
        
    }

    public void iniciar() {
        try {
            //Instanciamos nuestro semáforo y le adjudicamos 1 permiso.
            MiSemaforo s = new MiSemaforo(1);
            
            //Cada una de las instancias de nuestra clase hilo incluirá el semáforo
            Hilo h1 = new Hilo(s);
            Hilo h2 = new Hilo(s);
            Hilo h3 = new Hilo(s);
            
            //Los empezamos todos
            h1.start();
            h2.start();
            h3.start();
            
            //Indicamos que cada uno se ejecute cuando el anterior termine
            h1.join();
            h2.join();
            h3.join();
            
            /* En caso de que x sea igual que contador * 3 (300), se imprimirá
            * por pantalla "Todo OK.", en el caso contrarió "Condición de carrera".
            * Como con la ayuda de nuestro semáforo cada hilo sumará a x 100 este
            * if se cumplirá.
            */
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

        /* Al iniciar el hilo nuestro semáforo obtendrá un permiso, lo cual hará
        * que este se bloquee. Una vez sumado 1 a x liberaremos el recurso. Esto
        * lo realizaremos el número de veces que se encuentre en nuestro contador,
        * en nuestro caso 100 veces. Por lo que x habrá llegado a 100.
        */
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
