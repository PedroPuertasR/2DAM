/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7_3;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Instanciamos el array y los hilos
        int a[] = {1, 2, 3};
        
        MiHilo mh1 = MiHilo.crearYComenzar("primero", a);
        MiHilo mh2 = MiHilo.crearYComenzar("segundo", a);
        
        /*Realizamos el join para que vayan comenzando los hilos después de la
        * finalización del anterior
        */
        try {
            mh1.t.join();
            mh2.t.join();
        }catch (InterruptedException e){
            System.out.println("El hilo principal ha fallado.");
        } 
        
        //Mostramos el finald el hilo principal
        System.out.println("El hilo principal ha finalizado.");
        
    } 
}

class sumArray{
    private int sum;
   
    public sumArray(){
        
    }
    
    /*Mismo método del ejercicio anterior pero sin el synchronized, devuelve la
    * suma del array
    */
    public int sumArray(int nums []){
        
        //Instanciamos sum a 0 para ir sumando cada número del array
        sum = 0;
        
        //Bucle for en el que iremos sumando los números del array
        for (int i = 0; i < nums.length; i++){
            
            sum = sum + nums[i];
            
            System.out.println("Suma actual del hilo " 
                    + Thread.currentThread().getName()+ ":" + sum);
            
            try {
                //Esperaremos 1 segundo entre cada suma
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("El hilo ha fallado.");
            }
        }
        return sum;
    }
}

class MiHilo implements Runnable{
    
    Thread t;
    static sumArray sumarray = new sumArray();
    int a[];
    int res;

    //En este constructor inicializamos el hilo con el nombre y también el array
    public MiHilo(String nombre, int nums[]){
        t= new Thread(this,nombre);
        a=nums;
    }
    
    //Método reutilizado para instanciar e iniciar el hilo
    public static MiHilo crearYComenzar (String nombre,int nums[]){
        MiHilo miHilo=new MiHilo(nombre,nums);
        miHilo.t.start();
        return miHilo;
    }
 
    public void run(){
        //Mostramos el inicio del hilo
        System.out.println("Iniciando el hilo " + t.getName());

        /*Metemos la ejecución del método sumArray en un bloque synchronized
        * para que bloquee el objeto mientras este termina de ejecutarse
        */
        synchronized(sumarray){
            res = sumarray.sumArray(a);
        }
        
        //Mostramos por pantalla la suma del array
        System.out.println("El total de la suma de "+ t.getName()+
        " es: " + res);
        
        //Mostramos por pantalla la finalización del hilo
        System.out.println("El hilo " + t.getName() + " ha terminado.");
    }
}