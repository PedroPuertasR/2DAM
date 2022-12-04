/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author alumno
 */
public class Botones {

    private static final int N_ROWS = 5;
    private static final int N_COLS = 4;

    /* En el main instanciaremos nuestro JFrame y haremos que nuestro ReaderWriter
    * realice su función, como hemos comentado en su clase.
    */
    public static void main(String[] args) {

        Data data = new Data();
        Thread[][] threads = new Thread[N_ROWS][N_COLS];
        JFrame frame = new JFrame("Readers & writers");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();

        container.setLayout(new GridLayout(N_ROWS, N_COLS));
        
        for (int row = 0;row < N_ROWS;row++) {
            
            for (int col = 0; col < N_COLS; col++) {
                JButton button = new JButton(String.format("%d, %d", row, col));
                button.setOpaque(true);
                container.add(button);
                ReaderWriter rw = new ReaderWriter(data, button);
                threads[row][col] = rw;
                rw.start();
            }
            
        }

        frame.pack();

        frame.setVisible(true);
    }

}
