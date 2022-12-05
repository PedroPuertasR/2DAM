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
public class Puente {
    
    private static final int PESO_MAXIMO = 200;
    private static final int MAX_PERSONAS = 3;
    private int peso;
    private int numPersonas;

    public Puente(int peso, int numPersonas) {
        this.peso = peso;
        this.numPersonas = numPersonas;
    }
    
    
    
    public int getPeso (){
        return peso;
    }
    
    public int getNumPersonas(){
        return numPersonas;
    }
    
    public synchronized boolean autorizacionPaso (Persona p){
        if(numPersonas < MAX_PERSONAS && peso + p.getPeso() < PESO_MAXIMO){
            numPersonas++;
            peso += p.getPeso();
            return true;
        }else{
            return false;
        }
    }
            
    public synchronized void terminaPaso (Persona p){
        numPersonas--;
        peso -= p.getPeso();
    }
    
}
