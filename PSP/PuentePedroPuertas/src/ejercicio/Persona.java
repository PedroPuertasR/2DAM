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
public class Persona extends Thread {

    private final String idPersona;
    private final int peso;
    private final int tMinPaso, tMaxPaso;
    private final Puente puente;

    public Persona(String idPersona, int peso, int tMinPaso, int tMaxPaso, Puente puente) {
        this.idPersona = idPersona;
        this.peso = peso;
        this.tMinPaso = tMinPaso;
        this.tMaxPaso = tMaxPaso;
        this.puente = puente;
    }

    //Método que devuelve el peso de la persona.
    public int getPeso() {
        return peso;
    }

    //Método que devuelve el id de la persona.
    public String getIdPersona() {
        return idPersona;
    }

    /* Al iniciar el hilo comprobará que se cumple las condiciones para ingresar
    * al puente y en caso de que pueda espera un tiempo aleatorio dentro y después
    * sale del puente. En caso de que no pueda pasar el hilo permanecerá a la
    * espera.
    */
    @Override
    public void run() {

        boolean pasaje = false;

        while (!pasaje) {
            synchronized (this.puente) {
                pasaje = this.puente.autorizacionPaso(this);
                if (!pasaje) {
                    try {
                        System.out.println(idPersona + " tiene que esperar.");
                        puente.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        System.out.println("Peso actual: " + puente.getPeso() + ". Personas en el puente: "
                + puente.getNumPersonas());

        int tiempo = generarAleatorio(tMaxPaso, tMinPaso);
        System.out.println("Tiempo en pasar: " + tiempo);

        try {
            sleep(500 * tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        synchronized (this.puente) {
            this.puente.terminaPaso(this);

            puente.notifyAll();
        }

    }

    //Método para generar un número aleatorio
    public int generarAleatorio(int max, int min) {
        Random r = new Random();

        int num = r.nextInt(((max - min) + 1)) + min;

        return num;
    }
}
