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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int tMinParaLlegadaPersona=1;
        int tMaxParaLlegadaPersona=30;
        int tMinPaso=10;
        int tMaxPaso=50;
        int minPesoPersona=40;
        int maxPesoPersona=120;
        int idPersona=1;
        int peso, tiempoEnLlegar;
        
        Puente p = new Puente(0, 0);
        
        /* Generamos un peso y un tiempo en llegar (tiempo del sleep) aleatorio.
        * Más tarde iniciamos el hilo.
        */
        while(true){
            peso = generarAleatorio(maxPesoPersona, minPesoPersona);
            Persona per = new Persona("Persona " + String.valueOf(idPersona++), peso, tMinPaso, tMaxPaso, p);
            tiempoEnLlegar = generarAleatorio(tMaxParaLlegadaPersona, tMinParaLlegadaPersona);
            try {
                Thread.sleep(tiempoEnLlegar);
                System.out.printf("Tiempo en llegar: %d segundos.\n", tiempoEnLlegar);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            per.start();
            System.out.println("Hay " + p.getNumPersonas() 
                    + " personas pasando por el puente. Peso actual: " + p.getPeso());
        }
        
    }
    
    //Método para generar un número aleatorio.
    public static int generarAleatorio(int max, int min){
        Random r = new Random();
            
        int num = r.nextInt(((max - min) - 1) + min);
        
        return num;
    }
    
}
