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

    /* Con este método le devolvemos al usuario la variable almacenar, además de
    * mostrar por pantalla su valor actual.
    */
    public synchronized int getN(String id){
        System.out.println("En el hilo " + id + " el valor es: " + almacenar);
        return almacenar;
    }
    
    /* Con este método seteamos la variable almacenar con el valor que nos pasen,
    * además se lo sumamos al contador para mostrarlo por pantalla
    */
    public synchronized void setN(String id, int n){
        
        this.almacenar = n;
        this.contador += almacenar;
        System.out.println("En el hilo " + id + ", modifica el valor: " + contador);
        
    }
    
}
