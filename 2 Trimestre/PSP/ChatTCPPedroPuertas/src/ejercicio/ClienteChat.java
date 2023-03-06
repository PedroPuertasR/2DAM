package ejercicio;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClienteChat extends JFrame implements ActionListener, Runnable {

    String nombre;
    boolean seRepite = true;
    private static final long UID = 1L;
    Socket socket = null;
    /*La variable mensaje representa un cuadro de texto donde el cliente puede ingresar el mensaje que desea enviar al servidor*/
    private static JTextField mensaje = new JTextField();
    /*Las variables scrollpane1 y textarea1 representan un panel de desplazamiento y un área de texto respectivamente, donde se muestran los mensajes enviados y recibidos*/
    private JScrollPane scrollpane1;
    private static JTextArea textarea1;
    /*Las variables btnEnviar y botonSalir son botones que permiten al cliente enviar un mensaje al servidor y salir del chat, respectivamente.*/
    private JButton btnEnviar = new JButton("Enviar");
    private JButton botonSalir = new JButton("Salir");
    /*Las variables datoEntrada y datoSalida son flujos de datos de entrada y salida respectivamente, que permiten la comunicación entre el cliente y el servidor.*/
    private DataInputStream datoEntrada;
    private DataOutputStream datoSalida;

    /*El constructor de la clase ClienteChat se encarga de inicializar la GUI y los flujos de datos de entrada y salida*/
    public ClienteChat(Socket s, String nombre) {
        super("CONEXIÓN DEL CLIENTE CHAT: " + nombre);
        setLayout(null);
        mensaje.setBounds(15, 15, 450, 40);
        add(mensaje);
        textarea1 = new JTextArea();
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(15, 60, 500, 400);
        add(scrollpane1);
        btnEnviar.setBounds(450, 15, 150, 40);
        add(btnEnviar);
        botonSalir.setBounds(450, 60, 150, 40);
        add(botonSalir);
        textarea1.setEditable(false);
        btnEnviar.addActionListener(this);
        botonSalir.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        socket = s;
        this.nombre = nombre;
        try {
            datoEntrada = new DataInputStream(socket.getInputStream());
            datoSalida = new DataOutputStream(socket.getOutputStream());
            String texto = " > Entra en el Chat ... " + nombre;
            datoSalida.writeUTF(texto);
        } catch (IOException e) {
            System.out.println("ERROR DE E/S");
            System.exit(0);
        }
    }

    /*El método actionPerformed se encarga de detectar los eventos de acción de los botones btnEnviar y botonSalir, y realizar las acciones correspondientes*/
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEnviar) {
            if (mensaje.getText().trim().length() == 0) {
                return;
            }
            String texto = nombre + "> " + mensaje.getText();
            try {
                mensaje.setText("");
                datoSalida.writeUTF(texto);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == botonSalir) {
            String texto = " > Abandona el Chat ... " + nombre;
            try {
                datoSalida.writeUTF(texto);
                datoSalida.writeUTF("*");
                seRepite = false;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /*El método run se encarga de ejecutar el hilo de ejecución del cliente y recibir los mensajes enviados por el servidor.*/
    @Override
    public void run() {
        String texto = "";
        while (seRepite) {
            try {
                texto = datoEntrada.readUTF();
                textarea1.setText(texto);
            } catch (IOException e) {

                JOptionPane.showMessageDialog(null, "IMPOSIBLE CONECTAR CON EL SERVIDOR\n" + e.getMessage(),
                        "<<MENSAJE DE ERROR:2>>",
                        JOptionPane.ERROR_MESSAGE
                );
                seRepite = false;
            }
        }
        try {
            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*El método main es el punto de entrada del programa y se encarga de crear una instancia de la clase ClienteChat y conectarla al servidor mediante un socket*/
    public static void main(String args[]) {
        int puerto = 44444;
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
                    "<<MENSAJE DE ERROR:1>>",JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
