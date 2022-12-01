/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

/**
 *
 * @author alumno
 */
public class ContadorCompartido {
    
    private int almacenar;
    private int contador;
    
    public ContadorCompartido(int a){
        almacenar = a;
        contador = 0;
    }

    public synchronized int getN(String id){
        System.out.println("En el hilo " + id + " el valor es: " + almacenar);
        return almacenar;
    }
    
    public synchronized void setN(String id, int n){
        
        this.almacenar = n;
        this.contador += almacenar;
        System.out.println("En el hilo " + id + ", modifica el valor: " + contador);
        
    }
    
}
