/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author alumno
 */
public class ReaderWriter extends Thread {

    private static final Color IDLE = Color.LIGHT_GRAY;
    private static final Color READING = Color.BLUE;
    private static final Color WRITING = Color.RED;
    private final Random random = new Random();
    private final Data data;
    private final JButton button;

    public ReaderWriter(Data data, JButton button) {
        this.data = data;
        this.button = button;
    }

    @Override
    public void run() {
        while (true) {
            button.setBackground(IDLE);
            int s = 2;
            nap(s);
            if (Math.random()
                    < 0.1) {
                data.openWriting(this);
                button.setBackground(WRITING);
                nap(5);
                data.closeWriting();
            } else {
                data.openReading();
                button.setBackground(READING);
                nap(3);

                data.closeReading();
            }
        }
    }

    public void nap(int s) {
        try {
            sleep(random.nextInt(s) * 3000);
        } catch (InterruptedException ignored) {
        }
    }
}
