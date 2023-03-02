/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedropuertas.ejercicio7pedropuertas;

import java.io.Serializable;

public class Datos implements Serializable {

    String cadena; //cadena que se intercambia con el servidor
    int intentos; //intentos que lleva el jugador
    int identificador; //id del jugador
    boolean gana; //true si el jugador adivina el numero
    boolean juega; //true si el jugador juega, false juego finalizado

    public Datos(String cadena, int intentos, int identificador) {
        this.cadena = cadena;
        this.intentos = intentos;
        this.identificador = identificador;
    }

    public Datos() {
    }

    public boolean jugando() {
        return juega;
    }

    public void setJuega(boolean juega) {
        this.juega = juega;
    }

    public boolean ganador() {
        return this.gana;
    }

    public void setGana(boolean gana) {
        this.gana = gana;
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador=identificador;
    }

    public String getCadena() {
        return this.cadena;
    }

    public void setCadena(String cadena) {
        this.cadena=cadena;
    }

    public int getIntentos() {
        return this.intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos=intentos;
    }
}
