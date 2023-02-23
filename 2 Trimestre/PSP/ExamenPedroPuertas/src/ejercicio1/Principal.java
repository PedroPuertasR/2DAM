package ejercicio1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Principal {

    public static void main(String[] args) throws UnknownHostException{
        Socket s;

        System.out.println("Iniciando escaneo de puertos...\n");
        System.out.println("PUERTO\t\tESTADO");
        System.out.println("****************************");
        
        //Realizamos un bucle con los 1024 puertos
        for (int i = 1; i <= 1024; i++) {
            try {

                //Creamos el socket con conexión local
                s = new Socket("localhost", i);
                //Guardamos el puerto en un string
                String aux = String.valueOf(i);
                
                //Dependiendo de la longitud de este iremos a un case u otro
                switch (aux.length()) {
                    case 1: {
                        System.out.println("** " + aux + "\tABIERTO.");
                        break;
                    }
                    case 2: {
                        System.out.println("** " + aux + "\tABIERTO.");
                        break;
                    }
                    case 3: {
                        System.out.println("** " + aux + "\tABIERTO");
                        break;
                    }
                }
                //Cerramos el socket al terminar
                s.close();
            } catch (IOException e) {
            }
        }
        System.out.println("***********************");
        System.out.println("Escaneo terminado.");
    }
}