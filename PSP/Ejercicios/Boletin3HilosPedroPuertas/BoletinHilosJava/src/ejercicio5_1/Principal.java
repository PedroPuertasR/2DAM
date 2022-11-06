/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5_1;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Iniciando el hilo principal.");
        
        /*Instanciamos los objetos MiHilo con el método estático crearYComenzar,
        * por lo que directamente el hilo empezará a funcionar a través del
        * método start()
        */
        MiHilo primero = MiHilo.crearYComenzar("primero");
        MiHilo segundo = MiHilo.crearYComenzar("segundo");
        MiHilo tercero = MiHilo.crearYComenzar("tercero");
        
        do {
            try{
                Thread.sleep(1000);
            }catch (InterruptedException exc){
                System.out.println("El hilo principal ha fallado.");
            }
        /* Gracias al método isAlive() comprobaremos si alguno de nuestros
        * hilos sigue activo, por lo que se nos mantendrá dentro del bucle
        * hasta que todos terminen
        */
        }while (primero.isAlive() || segundo.isAlive() || tercero.isAlive());
        
        //Indicamos cuando finalicen todos los hilos
        System.out.println("El hilo principal ha finalizado.");

    }
    
}

class MiHilo extends Thread{
    
    //Como esta vez extendemos de Thread no necesitaremos un objeto tipo Thread
    
    public MiHilo(String nombre){
        super(nombre);
    }
    
    /* Reutilizamos el método crearYComenzar del ejercicio anterior para
    * instanciar e iniciar nuestros hilos inmediatamente.
    */
    public static MiHilo crearYComenzar (String nombre){
        
        MiHilo mh = new MiHilo(nombre);
        mh.start();
        return mh;
    }
    
    public void run(){
        //Indicamos el inicio del hilo
        System.out.println("Iniciamos el hilo " + getName());
        
        try {
            /*Como anteriormente iremos contando cada 1 segundo donde se
            * encuentra cada hilo
            */
            for (int i = 0; i < 10 ; i++){
                Thread.sleep(1000);
                System.out.println("En el hilo " + getName() + ", contador = " + i);
            }
        }catch (InterruptedException exc){
            System.out.println("Fallo del hilo: " + getName());
        }
        
        //Indicamos cuando finaliza nuestro hilo
        System.out.println("Final del hilo: " + getName());
    }
}