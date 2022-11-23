/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame marco = new MarcoRebote();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
        
    }
    
}

class PelotaHilos implements Runnable {

    public PelotaHilos(Pelota unaPelota, Component component) {
        pelota = unaPelota;
        componente = component;
    }
    private Pelota pelota;
    private Component componente;

    @Override
    public void run() {
        for (int i = 1; i <= 3000; i++) {
            pelota.mueve_pelota(componente.getBounds());
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println("Error en la pelota");
            }
            componente.paint(componente.getGraphics());
        }
    }

}

class Pelota {

    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
//Mueve la pelota invirtiendo posición si choca con los limites

    public void mueve_pelota(Rectangle2D limites) {
        x += dx;
        y += dy;
        if (x < limites.getMinX()) {
            dx = -dx;
        }
        if (x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }
        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }
        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }
    }
//Forma de la pelota en su posición inicial

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }
}

class LaminaPelota extends JPanel {

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
//Añadimos pelota a la lámina

    public void add(Pelota b) {
        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Pelota b : pelotas) {
            g2.fill(b.getShape());
        }
    }
}

final class MarcoRebote extends JFrame {

    private LaminaPelota lamina;

    public MarcoRebote() {
        setBounds(600, 300, 400, 350);
        setTitle("Rebotes");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();
        ponerBoton(laminaBotones, "Dale!", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego();
            }
        });
        ponerBoton(laminaBotones, "Salir", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });
        add(laminaBotones, BorderLayout.SOUTH);

    }

    public void ponerBoton(Container c, String titulo, ActionListener oyente) {
        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }

    public void comienza_el_juego() {
        Pelota pelota = new Pelota();
        lamina.add(pelota);
        
        Runnable run= new PelotaHilos(pelota, lamina);
        Thread th=new Thread(run);
        
        th.start();
    }

}

