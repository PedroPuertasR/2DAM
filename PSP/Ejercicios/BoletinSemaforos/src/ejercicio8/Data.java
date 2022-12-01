/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Data {

    private int nWriters = 0;
    private int nReaders = 0;
    private int nWritersWaiting = 0;

    public synchronized void openReading() {
        while (nWriters > 0 || nWritersWaiting > 0) {
            waiting();
        }
        nReaders++;
    }

    public synchronized void closeReading() {
        nReaders--;
        notifyAll();
    }

    public synchronized void openWriting(ReaderWriter writer) {
        nWritersWaiting++;
        while (nReaders > 0 || nWriters > 0) {
            waiting();
        }
        nWritersWaiting--;
        System.out.println("en cola: " + nWritersWaiting);
        nWriters++;
    }

    public synchronized void closeWriting() {
        nWriters--;
        notifyAll();
    }

    private void waiting() {
        try {
            wait();
        } catch (InterruptedException ignored) {
        }
    }

}
