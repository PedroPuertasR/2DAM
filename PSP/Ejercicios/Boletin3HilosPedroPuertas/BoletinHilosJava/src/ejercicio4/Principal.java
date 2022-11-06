/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Indiciamos el inicio del hilo principal
        System.out.println("Iniciando el hilo principal.");
        
        /*Instanciamos los objetos MiHilo con el método estático crearYComenzar,
        * por lo que directamente el hilo empezará a funcionar a través del
        * método start()
        */
        MiHilo primero = MiHilo.crearYComenzar("primero");
        MiHilo segundo = MiHilo.crearYComenzar("segundo");
        MiHilo tercero = MiHilo.crearYComenzar("tercero");
        
        for (int i = 0; i < 10; i++) {
            try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
            System.out.println("El hilo principal ha fallado.");
            }
        }
        
        //Indicamos el fin del hilo
        System.out.println("El hilo principal ha finalizado.");
    }
    
}

class MiHilo implements Runnable{
    
    //Creamos el atributo Thread puesto que estamos utilizando la interfaz Runnable
    private Thread t;
    
    public MiHilo(String nombre){
        t = new Thread(this, nombre);
    }
    
    /* Con este método estático instanciaremos el hilo con su nombre y 
    * lo iniciaremos inmediatamente
    */
    public static MiHilo crearYComenzar (String nombre){
        MiHilo miHilo=new MiHilo(nombre);
        miHilo.t.start();
        return miHilo;
    }
    
    public void run(){
        //Indicamos el inicio del hilo
        System.out.println("Iniciamos el hilo " + t.getName());
        
        try {
            /*Como anteriormente iremos contando cada 1 segundo donde se
            * encuentra el hilo
            */
            for (int i = 0; i < 10; i++){
                Thread.sleep(1000);
                System.out.println("En el hilo " + t.getName() + ", contador = " + i);
            }
        }catch (InterruptedException e){
            System.out.println("Fallo del hilo: " + t.getName());
        }
        
        //Indicamos el final del hilo
        System.out.println("Final del hilo: " + t.getName());
        
    }
 }