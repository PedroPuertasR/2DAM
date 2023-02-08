/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author alumno
 */
public class TCPCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int puerto = 6000;

        Socket cliente = new Socket("192.168.8.9", puerto);
        System.out.println("Cliente conectado...");

        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        flujoSalida.writeUTF("Mensaje de Pedro");
        flujoSalida.flush();

        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        System.out.println(flujoEntrada.readUTF());

        flujoEntrada.close();
        flujoSalida.close();
        entrada.close();
        salida.close();
        cliente.close();
    }

}
