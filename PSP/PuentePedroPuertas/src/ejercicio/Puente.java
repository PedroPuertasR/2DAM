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

    //Método para conseguir el peso del puente.
    public synchronized int getPeso (){
        return peso;
    }
    
    //Método para conseguir el número de personas del puente.
    public synchronized int getNumPersonas(){
        return numPersonas;
    }
    
    /* Método para comprobar si la persona puede entrar en el puente. En caso
    * de que cumpla los requisitos de peso y número de personas sumará el
    * peso al puente y agregará 1 al contador de personas, además de delvolver true.
    */
    public synchronized boolean autorizacionPaso (Persona p){
        System.out.println(p.getIdPersona() + " pide paso en el puente.");
        if(numPersonas < MAX_PERSONAS && peso + p.getPeso() < PESO_MAXIMO){
            System.out.println("-------------- " + p.getIdPersona() + " entra en el puente.");
            numPersonas++;
            peso += p.getPeso();
            return true;
        }else{
            return false;
        }
    }
            
    /* Método para que una persona abandone el puente, lo que restará 1 al contador
    * de personas y restará el peso del puente.
    */
    public synchronized void terminaPaso (Persona p){   
        numPersonas--;
        peso -= p.getPeso();
        System.out.println(p.getIdPersona() + " termina su paso.");
    }
    
}
