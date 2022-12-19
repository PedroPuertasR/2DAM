/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Data {

    private int nWriters = 0;
    private int nReaders = 0;
    private List<ReaderWriter> writersWaiting = new ArrayList<ReaderWriter>();

    /* Con este método haremos que mientras haya writers o writers a la espera
    * el proceso se quede esperando y una vez que entre le sumará uno a los readers.
     */
    public synchronized void openReading() {
        while (nWriters > 0 || writersWaiting.size() > 0) {
            waiting();
        }
        nReaders++;
    }

    /*Con este método acabaremos la lectura restandole uno a los readers y 
    * avisando a los hilos que se encuentren a la espera
    */
    public synchronized void closeReading() {
        nReaders--;
        notifyAll();
    }

    /* Con este método añadiremos 1 a la lista de writers a la espera, mientras
    * que haya un reader, writer o writer a la espera este proceso esperará, cuando
    * termine borrará el writer de la lista de espera y sumará 1 a los writers.
    */
    public synchronized void openWriting(ReaderWriter writer) {
        writersWaiting.add(writer);
        while (nReaders > 0 || nWriters > 0 || !writersWaiting.get(0).equals(writer)) {
            waiting();
        }
        writersWaiting.remove(0);
        nWriters++;
    }

    //Con este método le restamos 1 a los writers y despertamos a los demás hilos a la espera.
    public synchronized void closeWriting() {
        nWriters--;
        notifyAll();
    }

    //Con este método hacemos que los procesos se mantengan a la espera.
    private void waiting() {
        try {
            wait();
        } catch (InterruptedException e) {
        }
    }

}
