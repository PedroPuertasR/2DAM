/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import ejercicio.Robots.Colocador;
import ejercicio.Robots.Empaquetador;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tam = 10;

        System.out.println("Tamaño de la cadena: " + tam);

        //Instanciamos los empaquetadores y el colocador
        Empaquetador empaquetador1 = new Empaquetador(1);
        Empaquetador empaquetador2 = new Empaquetador(2);
        Empaquetador empaquetador3 = new Empaquetador(3);
        Colocador colocador = new Colocador();
        
        //Iniciamos los hilos
        colocador.start();
        empaquetador1.start();
        empaquetador2.start();
        empaquetador3.start();
    }

}
