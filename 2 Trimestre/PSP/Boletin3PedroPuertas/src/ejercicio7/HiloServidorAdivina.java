package ejercicio7;

import java.io.*;
import java.net.*;

public class HiloServidorAdivina extends Thread {

    ObjectInputStream objectEntrada;
    ObjectOutputStream objectSalida;
    Socket socket = null;
    ObjetoCompartido objeto;
    int identificador;
    int intentos = 0;

    public HiloServidorAdivina(Socket s, ObjetoCompartido objeto, int id) {

        // Se inicializan las variables del juego con los valores recibidos como parámetros
        this.socket = s;
        this.objeto = objeto;
        this.identificador = id;

        try {
            // Se crea el flujo de entrada y salida para recibir datos del cliente
            objectSalida = new ObjectOutputStream(socket.getOutputStream());
            objectEntrada = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error en HiloServidor");
            e.printStackTrace();
        }
    }
    
    public void run() {
        System.out.println("Cliente: " + identificador);
        
        // Se crea un objeto Datos para enviar el mensaje de inicio del juego al cliente
        Datos datos = new Datos("Adivina un número entre 1 y 25", intentos, identificador);
        //Si el juego ha acabado seteamos juega como false para el siguiente while
        if (objeto.acabado()) {
            datos.setCadena("El juego ha terminado.");
            datos.setJuega(false);
        }
        try {
            objectSalida.reset();
            objectSalida.writeObject(datos);
        } catch (IOException e1) {
            System.out.println("Error al realizar el primer envio al jugador: " 
                    + identificador);
        }
        
        // Se ejecuta el juego mientras no se hayan realizado 5 intentos o el juego no haya finalizado
        while (!objeto.acabado() || !(datos.getIntentos() == 5)) {
            int numecli = 0;
            try {
                Datos d = (Datos) objectEntrada.readObject();
                numecli = Integer.parseInt(d.getCadena());
            } catch (IOException e) {
                System.out.println("Error al leer del jugador: " + identificador);
                break;
            } catch (NumberFormatException n) {
                System.out.println("El jugador " + identificador + " desconectado.");
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
            
            //Indicamos nuestra jugada, que nos devolverá si hemos ganado o no
            String cad = objeto.jugada(identificador, numecli);
            intentos++;
            //Instanciamos la variable datos con nuestra cadena, intentos y el id
            datos = new Datos(cad, intentos, identificador);
            
            //Comprobamos si el juego ha terminado
            if (objeto.acabado()) {
                datos.setJuega(false);
                if (identificador == objeto.getGanador()) {
                    datos.setGana(true);
                }
            }
            try {
                objectSalida.reset();
                //Escribimos los datos en el flujo de salida
                objectSalida.writeObject(datos);
            } catch (IOException e) {
                System.out.println("Error escribiendo en flujo de salida del jugador: "
                        + identificador + " * " + e.getMessage());
            } catch (NullPointerException n) {
                System.out.println("Jugador " + identificador + " desconectado ");
            }
        }
        //Si el juego ha terminado lo indicamos por pantalla
        if (objeto.acabado()) {
            System.out.println("Juego terminado.");
            System.out.println("Desconectando a: " + identificador);
        }
        try {
            //Cerramos los flujos y el socket
            objectSalida.close();
            objectEntrada.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar al cliente: " + identificador);
            e.printStackTrace();
        }
    }
}