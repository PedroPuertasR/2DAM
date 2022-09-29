/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplo1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Concesionario {
    
    public Automovil auto1;
    public Automovil auto2;

    public Concesionario() {
    }

    public Concesionario(Automovil auto1, Automovil auto2) {
        this.auto1 = auto1;
        this.auto2 = auto2;
    }

    public Automovil getAuto1() {
        return auto1;
    }

    public Automovil getAuto2() {
        return auto2;
    }

    public void setAuto1(Automovil auto1) {
        this.auto1 = auto1;
    }

    public void setAuto2(Automovil auto2) {
        this.auto2 = auto2;
    }

    @Override
    public String toString() {
        return "Concesionario{" + "auto1=" + auto1 + ", auto2=" + auto2 + '}';
    }
    
    //Métodos
    
    public String verMarca (int i){
        if(i == 1){
            return auto1.getMarca();
        }else{
            return auto2.getMarca();
        }
    }
    
    public String verModelo (int i){
        if(i == 1){
            return auto1.getModelo();
        }else{
            return auto2.getModelo();
        }
    }
    
    public int verPrecio (int i){
        if(i == 1){
            return auto1.getPrecio();
        }else{
            return auto2.getPrecio();
        }
    }
    
    public String cambiarModelo (Automovil a, String nuevo){
        a.setModelo(nuevo);
        return a.getModelo();
    }
    
    public int cambiarPrecio (Automovil a, int nuevo){
        if(nuevo < a.getPrecio()){
            return a.getPrecio();
        }else{
            a.setPrecio(nuevo);
            return a.getPrecio();
        }
    }
    
    public void imprimirMenu(){
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Ver coches.");
        System.out.println("2. Ver precio.");
        System.out.println("3. Ver modelo.");
        System.out.println("4. Ver marca.");
        System.out.println("5. Cambiar modelo.");
        System.out.println("6. Cambiar marca.");
        System.out.println("7. Cambiar precio.");
    }
    
    public void verCoches (){
        
        List <Automovil> lista = new ArrayList<Automovil>();
        lista.add(auto1);
        lista.add(auto2);
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("Coche Nº%d: " + lista.get(i) + "\n", i + 1);
        }
        
    }
    
}
