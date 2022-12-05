/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

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

    @Override
    public void run() {
        if(puente.autorizacionPaso(this)){
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            puente.terminaPaso(this);
        }
    }
    
    
    
}
