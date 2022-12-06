/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Persona extends Thread{
    
    private final String idPersona;
    private final int peso;
    private final int tMinPaso , tMaxPaso;
    private final Puente puente;

    public Persona(String idPersona, int peso, int tMinPaso, int tMaxPaso, Puente puente) {
        this.idPersona = idPersona;
        this.peso = peso;
        this.tMinPaso = tMinPaso;
        this.tMaxPaso = tMaxPaso;
        this.puente = puente;
    }
    
    public int getPeso(){
        return peso;
    }

    /* Al iniciar el hilo comprobará que se cumple las condiciones para ingresar
    * al puente y en caso de que pueda espera un tiempo aleatorio dentro y después
    * sale del puente.
    */
    @Override
    public void run() {
        if(puente.autorizacionPaso(this)){
            nap();
            puente.terminaPaso(this);
            
            //Una vez que termine la ejecución avisará a los demás hilos a la espera.
            synchronized(this){
                notifyAll();
            }
        }
    }
    
    //Método para hacer que el hilo espere con un número de segundos aleatorio
    public void nap(){
        try {
            Random r = new Random();
            
            int num = r.nextInt(((tMaxPaso - tMinPaso) - 1) + tMinPaso);
            
            sleep(num);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
