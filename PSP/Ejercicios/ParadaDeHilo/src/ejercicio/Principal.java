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


/* Con este hilo moveremos la pelota y usaremos el sleep para que se vaya ejecutando
* durante lo que dure el bucle for. Usaremos la pelota y la pantalla en la que
* nos moveremos.
*/
class PelotaHilos implements Runnable{

    public PelotaHilos(Pelota p, Component component) {
        pelota = p;
        componente = component;
    }
    private Pelota pelota;
    private Component componente;

    @Override
    public void run() {
        
        while(!Thread.currentThread().isInterrupted()){
            
            pelota.mueve_pelota(componente.getBounds());
            
            componente.paint(componente.getGraphics());
            
            try{
                Thread.sleep(4);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            
        }
        
//        for (int i = 1; i <= 4000; i++) {
//            //Movemos la pelota (indicando la pantalla por la que rebotará)
//            pelota.mueve_pelota(componente.getBounds());
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException ex) {
//                System.out.println("Error en la pelota");
//            }
//            //Mostramos la nueva posición de la pelota
//            componente.paint(componente.getGraphics());
//        }
    }

}


/* Con esta clase instanciaremos una pelota con su posición inicial y tamaño.
* Además tendremos un método para mover la pelota por la pantalla
*/
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
    //Devuelve la pelota
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }
}

/* En esta clase tendremos un arraylist de pelotas en el que guardaremos estas
* para más tarde usarlas en nuestro programa.
*/
class LaminaPelota extends JPanel {

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
    
    //Borramos la lista (por si había otra pelota) y añadimos una nueva.
    public void add(Pelota b) {
        pelotas.clear();
        pelotas.add(b);
    }

    //Con este método rellenamos el Graphics2D con todas las pelotas del arraylist.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Pelota b : pelotas) {
            g2.fill(b.getShape());
        }
    }
}

/* Con esta clase controlaremos los botones que instanciaran las pelotas y nos
* permitirán detenerlas y terminar el programa.
*/
final class MarcoRebote extends JFrame {

    private LaminaPelota lamina;
    private Thread t1, t2, t3;
    private JButton ini1, ini2, ini3, par1, par2, par3;

    public MarcoRebote() {
        //Setteamos el JFrame
        setBounds(600, 300, 600, 350);
        //Setteamos el nombre del JFrame
        setTitle("Rebotes");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();
        
        
        /*Instanciamos el JButton que corresponde al primer hilo. Al pulsarlo 
        * llamaremos al método que inicia el hilo y por lo tanto mueve la 
        * pelota
        */
        ini1 = new JButton("Hilo 1");
        
        ini1.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent evento){
                comienza_el_juego(evento);
            }
            
        });
        
        laminaBotones.add(ini1);
        
        
        /*Instanciamos el JButton que corresponde al segundo hilo. Al pulsarlo 
        * llamaremos al método que inicia el hilo y por lo tanto mueve la 
        * pelota
        */
        ini2 = new JButton("Hilo 2");
        
        ini2.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent evento){
                comienza_el_juego(evento);
            }
            
        });
        
        laminaBotones.add(ini2);
        
        
        /*Instanciamos el JButton que corresponde al tercer hilo. Al pulsarlo 
        * llamaremos al método que inicia el hilo y por lo tanto mueve la 
        * pelota
        */
        ini3 = new JButton("Hilo 3");
        
        ini3.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent evento){
                comienza_el_juego(evento);
            }
            
        });
        
        laminaBotones.add(ini3);
        
        
        /* Instanciamos el JButton que corresponde a la parada del primer hilo.
        * En caso de que pulsemos este botón llamaremos al método que
        * hará que se interrumpa la primera pelota.
        */
        par1 = new JButton("Parar 1");
        
        par1.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent evento){
                detener(evento);
            }
            
        });
        
        laminaBotones.add(par1);
        
        
        /* Instanciamos el JButton que corresponde a la parada del segundo hilo.
        * En caso de que pulsemos este botón llamaremos al método que
        * hará que se interrumpa la segunda pelota.
        */
        par2 = new JButton("Parar 2");
        
        par2.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent evento){
                detener(evento);
            }
            
        });
        
        laminaBotones.add(par2);
        
        
        /* Instanciamos el JButton que corresponde a la parada del tercer hilo.
        * En caso de que pulsemos este botón llamaremos al método que
        * hará que se interrumpa la tercera pelota.
        */
        par3 = new JButton("Parar 3");
        
        par3.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent evento){
                detener(evento);
            }
            
        });
        
        laminaBotones.add(par3);

        add(laminaBotones, BorderLayout.SOUTH);

    }

    /*Con este método iniciamos el hilo que corresponda al botón que le 
    * pasamos. En nuestro caso como tenemos tres botones de inicio, cada
    * uno empezará el hilo correspondiente.
    */
    public void comienza_el_juego(ActionEvent evento) {
        Pelota pelota = new Pelota();
        lamina.add(pelota);
        
        Runnable run = new PelotaHilos(pelota, lamina);
        
        if(evento.getSource().equals(ini1)){
            t1 = new Thread(run);
        
            t1.start();
        }else if(evento.getSource().equals(ini2)){
            t2 = new Thread(run);
            
            t2.start();
        }else if(evento.getSource().equals(ini3)){
            t3 = new Thread(run);
            
            t3.start();
        }
        
        
    }
    
    /* Con este método detendremos el hilo dependiendo del ActioEvent que le
    * pasemos. Como en nuestro caso tenemos 3 botones para detener el hilo
    * cada uno de los botones detendrá su hilo respectivamente.
    */
    public void detener(ActionEvent evento){
        
        if(evento.getSource().equals(par1)){
            t1.interrupt();
        }else if(evento.getSource().equals(par2)){
            t2.interrupt();
        }else if(evento.getSource().equals(par3)){
            t3.interrupt();
        }
        
    }

}

