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

    ;

    public synchronized void openReading() {
        while (nWriters > 0 || writersWaiting.size() > 0) {
            waiting();
        }
        nReaders++;
    }

    public synchronized void closeReading() {
        nReaders--;
        notifyAll();
    }

    public synchronized void openWriting(ReaderWriter writer) {
        writersWaiting.add(writer);
        while (nReaders > 0 || nWriters > 0 || !writersWaiting.get(0).equals(writer)) {
            waiting();
        }
        writersWaiting.remove(0);
        nWriters++;
    }

    public synchronized void closeWriting() {
        nWriters--;
        notifyAll();
    }

    private void waiting() {
        try {
            wait();
        } catch (InterruptedException e) {
        }
    }

}
