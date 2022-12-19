/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author alumno
 */
public class Nodo <T> {
    
    private T dato;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(T dato) {
        /*this.dato = dato;
        this.siguiente = null;
        this.anterior = null;*/
        
        this(dato, null, null);
        
    }
    
    public Nodo(T dato, Nodo siguiente, Nodo anterior){
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public T getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
    
    
}
