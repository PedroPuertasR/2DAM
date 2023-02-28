/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedropuertas.ejercicio7pedropuertas;

import java.io.Serializable;

/**
 *
 * @author Javir
 */
public class ObjetoCompartido implements Serializable {
    
    int numeroAdivinar;
    Boolean acabado=false;
    int ganador;

    public ObjetoCompartido(int n) {
        this.numeroAdivinar=n;
    }
    
    public boolean seAcabo (){
        return this.acabado;
    }
    
    public void setGanador(int ganador){
        this.ganador=ganador;
    }
    
    
    public int getGanador(){
        return this.ganador;
    }
    
    public void setAcabado(boolean acabado){
        this.acabado=acabado;
    }
    
    public synchronized String nuevaJugada(int jugador,int numero){
        if(numero>this.numeroAdivinar)
            return "\n El numero es demasiado alto.";
        else if(numero<this.numeroAdivinar)
            return "\n El numero es demasiado bajo.";
        else
            return "\n HAS GANADO!!";
    }
}
