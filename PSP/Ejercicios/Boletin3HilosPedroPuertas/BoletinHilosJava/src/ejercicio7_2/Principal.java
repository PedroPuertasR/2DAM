/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7_2;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Instanciamos el array a sumar y los hilos
        int a [] = {1, 2, 3};
        
        MiHilo mh1 = MiHilo.crearYComenzar("primero", a);
        MiHilo mh2 = MiHilo.crearYComenzar("segundo", a);
        
        try {
            /*Realizamos los join para que uno comienzo y el siguiente espere a
            * que el primero muera para iniciarse
            */
            mh1.t.join();
            mh2.t.join();
        }catch (InterruptedException e){
            System.out.println("El hilo principal ha fallado.");
        }
        System.out.println("El hilo principal ha finalizado.");
    }
    
}

class sumArray{
    
    private int sum;
    
    public sumArray(){
        
    }
    
    //Este método bloqueará el objeto hilo hasta que termine de sumar el array
    synchronized int sumArray(int nums []){
        
        //Instanciamos nuestro atributo sum a 0 para que vaya sumando el array
        sum = 0;
        
        for (int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            System.out.println("Suma actual del hilo " 
                    + Thread.currentThread().getName()+ ":" + sum);
            
            //Esperaremos 1 segundo entre cada suma
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("El hilo ha fallado");
            }
        }
        
        //Devolvemos el total
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
        t = new Thread(this,nombre);
        a = nums;
    }

    //Método reutilizado para instanciar e iniciar el hilo
    public static MiHilo crearYComenzar (String nombre, int nums[]){
        MiHilo mh = new MiHilo(nombre,nums);
        mh.t.start();
        return mh;
    }

    public void run(){
        //Mostramos el inicio del hilo
        System.out.println("Iniciando el hilo " + t.getName());
        
        //Guardamos el resultado de la suma del array
        res = sumarray.sumArray(a);
        
        //Mostramos por pantalla la suma del array
        System.out.println("El total de la suma de "+ t.getName()+
                " es: " + res);
        
        //Mostramos por pantalla la finalización del hilo
        System.out.println("El hilo " + t.getName() + " ha terminado.");
    }
}