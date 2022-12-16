/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author pedro
 */
public class Puerta {

    private boolean ocupada;

    public Puerta() {
        this.ocupada = false;
    }

    //Método para saber si la puerta está ocupada
    public synchronized boolean estaOcupada() {
        return this.ocupada;
    }

    //Método para cambiar la variable ocupada a false
    public synchronized void liberarPuerta() {
        this.ocupada = false;
    }

    /*Método para intentar entrar. Si está ocupada no te deja entrar y devuelve
    * false, en caso de que no lo esté devuelve true y pone la puerta como ocupada.
    */
    public synchronized boolean intentarEntrar() {
        if (this.ocupada) {
            return false;
        }
        
        this.ocupada = true;
        return true;
    }
}
