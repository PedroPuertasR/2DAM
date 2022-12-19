/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

/**
 *
 * @author alumno
 */
public class Data {

    private int nWriters = 0;
    private int nReaders = 0;
    private int nWritersWaiting = 0;

    /* Este método espera si los writers o los writers que esperan son más que 0,
    * más tarde le suma a los readers 1
    */
    public synchronized void openReading() {
        while (nWriters > 0 || nWritersWaiting > 0) {
            waiting();
        }
        nReaders++;
    }

    //Este método le resta a los readers 1 y despierta a los demás hilos a la espera.
    public synchronized void closeReading() {
        nReaders--;
        notifyAll();
    }

    /* Este método suma 1 a los writers que esperan y más tarde se mantiene a la
    * espera cuando los readers o los writers son mayores que 0.
    * Al terminar la espera le resta 1 a los writers que esperan puesto que ha
    * terminado su espera y muestra en pantalla la cantidad de que writers que
    * se encuentran a la espera. Después de esto le suma 1 a los writers.
    */
    public synchronized void openWriting(ReaderWriter writer) {
        nWritersWaiting++;
        while (nReaders > 0 || nWriters > 0) {
            waiting();
        }
        nWritersWaiting--;
        System.out.println("en cola: " + nWritersWaiting);
        nWriters++;
    }

    /*Este método le suma 1 a los writers y despierta a los hilos 
    *que se encuentran a la espera.
    */
    public synchronized void closeWriting() {
        nWriters--;
        notifyAll();
    }

    //Método para poner a la espera el hilo
    private void waiting() {
        try {
            wait();
        } catch (InterruptedException ignored) {
        }
    }

}
