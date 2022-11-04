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
        int a[]={1,2,3,4,5};
        MiHilo mh1 = MiHilo.creaEInicia("#1",a);
        MiHilo mh2 = MiHilo.creaEInicia("#2",a);
        try {
            mh1.hilo.join();
            mh2.hilo.join();
        }catch (InterruptedException e){
            System.out.println("Hilo principal interrumpido.");
        }
    }
    
}

class sumArray{
    private int sum;
    synchronized int sumArray( int nums []){
        sum=0;
        for (int i=0; i<nums.length;i++){
            sum+=nums[i];
            System.out.println("Total acumulado de "+Thread.currentThread().getName()+" es "+sum);
            
            try {
                Thread.sleep(10);
            }catch (InterruptedException exc){
                System.out.println("Hilo interrumpido");
            }
        }
        return sum;
    }
}
class MiHilo implements Runnable{
    Thread hilo;
    static sumArray sumarray= new sumArray();
    int a[];
    int resp;
    
    public MiHilo(String nombre, int nums[]){
        hilo= new Thread(this,nombre);
        a=nums;
    }

    public static MiHilo creaEInicia (String nombre,int nums[]){
        MiHilo miHilo=new MiHilo(nombre,nums);
        miHilo.hilo.start();
        return miHilo;
    }

    public void run(){
        int sum;
        System.out.println(hilo.getName()+ " iniciando.");
        resp=sumarray.sumArray(a);
        System.out.println("Suma para "+hilo.getName()+ " es "+resp);
        System.out.println(hilo.getName()+ " terminado.");
    }
}