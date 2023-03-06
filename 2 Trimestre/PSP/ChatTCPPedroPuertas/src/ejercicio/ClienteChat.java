package ejercicio;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ClienteChat extends JFrame implements ActionListener, Runnable {

    String nombre;
    boolean rep = true;
    private static final long UID = 1L;
    Socket socket = null;

    /*Mensaje es un cuadro de texto donde el cliente puede 
    * escribir el mensaje que se enviará al servidor
    */
    private static JTextField mensaje = new JTextField();
    /* Para realizar el historial de mensajes creamos un scrollpane con un 
    * JTextArea dentro, para que podamos utilizar la barra lateral en caso
    * de que haya muchos mensajes.
     */
    private JScrollPane scrollpane1;
    private static JTextArea historial;
    /*Las variables btnEnviar y btnSalir son botones que permiten al cliente 
    * enviar un mensaje al servidor y salir del chat.
    */
    private JButton btnEnviar = new JButton("Enviar");
    private JButton btnSalir = new JButton("Salir");
    /*Las variables entrada y salida son flujos que permiten la comunicación 
    * cliente/servidor.
    */
    private DataInputStream entrada;
    private DataOutputStream salida;

    /*Con el constructor montamos el layout de la interfaz y los diferentes
    * botones y textfields.
     */
    public ClienteChat(Socket s, String nombre) {
        super("Conectándose al chat como: " + nombre + "...");
        setLayout(null);
        mensaje.setBounds(15, 15, 450, 40);
        add(mensaje);
        historial = new JTextArea();
        scrollpane1 = new JScrollPane(historial);
        scrollpane1.setBounds(15, 60, 500, 400);
        add(scrollpane1);
        btnEnviar.setBounds(550, 15, 150, 40);
        add(btnEnviar);
        btnSalir.setBounds(550, 60, 150, 40);
        add(btnSalir);
        historial.setEditable(false);
        btnEnviar.addActionListener(this);
        btnSalir.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        socket = s;
        this.nombre = nombre;
        try {
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            String texto = "\tUn usuario entra al chat: " + nombre;
            salida.writeUTF(texto);
        } catch (IOException ex) {
            Logger.getLogger(ClienteChat.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    /*Con este método detectamos el click en los botones Enviar y Salir, lo que
    * hará que realicen las acciones pertinentes.
    */
    public void actionPerformed(ActionEvent e) {
        //En caso de que sea enviar comprobamos que el mensaje no esté vacío
        if (e.getSource() == btnEnviar) {
            if (mensaje.getText().equalsIgnoreCase("")) {
                System.out.println("No hay mensaje.");
            } else {
                String texto = nombre + ": " + mensaje.getText();
                try {
                    mensaje.setText("");
                    salida.writeUTF(texto);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }else if (e.getSource() == btnSalir) {
            String texto = "\t" + nombre + "abandona el chat... ";
            try {
                salida.writeUTF(texto);
                salida.writeUTF("*");
                rep = false;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /*El método run se encarga de ejecutar el hilo de ejecución del cliente y 
    * recibir los mensajes enviados por el servidor.
    */
    @Override
    public void run() {
        String texto = "";
        while (rep) {
            try {
                texto = entrada.readUTF();
                historial.setText(texto);
            } catch (IOException e) {

                JOptionPane.showMessageDialog(null, "No se ha podido conectar "
                        + "con el servidor\n" + e.getMessage(), "Error: 2", 
                        JOptionPane.ERROR_MESSAGE);
                rep = false;
            }
        }
        try {
            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*El método main es el punto de entrada del programa y se encarga de crear
    * una instancia de la clase ClienteChat y conectarla al servidor 
    * mediante un socket.
    */
    public static void main(String args[]) {
        int puerto = 6000;
        Socket s = null;
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");
        if (nombre.trim().length() == 0) {
            System.out.println("Por favor, inserte un nombre");
            return;
        }
        try {
            s = new Socket("localhost", puerto);
            ClienteChat cliente = new ClienteChat(s, nombre);
            cliente.setBounds(0, 0, 540, 400);
            cliente.setVisible(true);
            new Thread(cliente).start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se puede conectar con el servidor\n" + e.getMessage(),
                    "<<MENSAJE DE ERROR:1>>", JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
