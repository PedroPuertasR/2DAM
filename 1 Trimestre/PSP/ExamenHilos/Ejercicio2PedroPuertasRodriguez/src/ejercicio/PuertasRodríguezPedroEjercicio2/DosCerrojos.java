/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author alumno
 */
public class DosCerrojos extends Thread {

    private Object cerrojo1 = new Object();
    private Object cerrojo2 = new Object();

    /*Incrementamos en 1 la variable global 1, sincronizandola para que no haya
    * problemas al utilizar el método
    */
    public synchronized void incrementaVariableGlobal1() {
        VariableGlobal.variableGlobal1++;
    }

    /*Incrementamos en 1 la variable global 2, sincronizandola para que no haya
    * problemas al utilizar el método
    */
    public synchronized void incrementaVariableGlobal2() {
        VariableGlobal.variableGlobal2++;
    }

    /*Sincronizamos cada uno de los objetos para que el hilo no pueda acceder
    * hasta que termine el cada uno.
    */
    public void run() {

        synchronized(cerrojo1){
            incrementaVariableGlobal1();
        }
        
        synchronized(cerrojo2){
            incrementaVariableGlobal2();
        }
        
    }
}