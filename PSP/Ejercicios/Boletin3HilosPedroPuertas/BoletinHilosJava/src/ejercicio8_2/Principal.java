/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8_2;

/**
 *
 * @author pedro
 */
class Principal {

    public static void main(String[] args) {

        //Instanciamos el objeto TicTac y los hilos
        TicTac tt = new TicTac();
        
        MiHilo mh1 = MiHilo.crearYComenzar("Tic", tt);
        MiHilo mh2 = MiHilo.crearYComenzar("Tac", tt);
        
        /* Realizamos los join para que un hilo comience cuando "muera" el 
        * anterior
        */
        try {
            mh1.t.join();
            mh2.t.join();
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }
    }
}

class TicTac{

    //En este atributo almacenaremos el estado del reloj
    String estado;

    /* Con este método synchronized bloquearemos el objeto hasta que termine de
    * ejecutarse. En este caso hasta que no se nos devuelva un tac no continuará
    */
    synchronized void tic(boolean corriendo) {
        //Detiene el reloj y cambia el estado a tichecho
        if (!corriendo) {
            estado = "tichecho";
            //Se lo notifica a los demás hilos
            notify();
            return;
        }
        
        System.out.print("Tic ");
        //Marcaremos el tichecho y lo notificaremos a los demás hilos
        estado = "tichecho";
        notify();
        
        try {
            //Mientras que el tac no esté hecho este proceso esperará
            while (!estado.equals("tachecho")) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido.");
        }
    }

    /* Con este método synchronized bloquearemos el objeto hasta que termine de
    * ejecutarse. En este caso hasta que no se nos devuelva un tic no continuará
    */
    synchronized void tac(boolean corriendo) {
        //Detiene el reloj y cambia el estado a tachecho
        if (!corriendo) {
            estado = "tachecho";
            //Se lo notifica a los demás hilos
            notify();
            return;
        }
        
        System.out.println("Tac");
        //Marcaremos el tachecho y lo notificaremos a los demás hilos
        estado = "tachecho";
        notify();
        
        try {
            //Mientras que el tic no esté hecho este proceso esperará
            while (!estado.equals("tichecho")) {
                wait();
            }
        } catch (InterruptedException exc) {
            System.out.println("Hilo interrumpido.");
        }
    }
}

class MiHilo implements Runnable {

    Thread t;
    TicTac ttA;

    //Constructor en el que instanciamos el hilo y el objeto TicTac
    MiHilo(String nombre, TicTac tt) {
        t = new Thread(this, nombre);
        ttA = tt;
    }

    //Método reutilizado en el que instanciamos e inicializamos el hilo
    public static MiHilo crearYComenzar(String nombre, TicTac tt) {
        MiHilo mh = new MiHilo(nombre, tt);
        mh.t.start();
        return mh;
    }

    public void run() {
        //En caso de que el nombre del hilo sea Tic realizaremos un tic
        if (t.getName().compareTo("Tic") == 0) {
            for (int i = 0; i < 5; i++) {
                ttA.tic(true);
            }
            ttA.tic(false);
        //En caso contrario realizaremos un tac
        } else {
            for (int i = 0; i < 5; i++) {
                ttA.tac(true);
            }
            ttA.tac(false);
        }
    }
}