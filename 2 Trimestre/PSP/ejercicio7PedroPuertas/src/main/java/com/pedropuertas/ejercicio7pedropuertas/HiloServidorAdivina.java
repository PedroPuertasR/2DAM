/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedropuertas.ejercicio7pedropuertas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javir
 */
public class HiloServidorAdivina extends Thread {

    InputStreamReader flujoLecturaCliente;
    BufferedReader bufferLecturaCliente;
    ObjectOutputStream fsalida;
    Socket socket = null;

    ObjetoCompartido objeto;
    int identificador;
    int intentos = 0;

    private final static String COD_TEXTO="UTF-8";
    
    public HiloServidorAdivina(Socket s, ObjetoCompartido ob, int id) {
        
        this.socket = s;
        this.objeto = ob;
        this.identificador = id;

        Datos datos = new Datos("Has empezado el juego", 0, this.identificador);
        datos.setJuega(true);

        try {
            
            this.flujoLecturaCliente = new InputStreamReader(s.getInputStream(), COD_TEXTO);
            this.bufferLecturaCliente = new BufferedReader(flujoLecturaCliente);
            
            this.fsalida = new ObjectOutputStream(socket.getOutputStream());
            fsalida.writeObject(datos);

        } catch (IOException ex) {
            System.out.println("FALLO EN LA E/S EN SERVIDOR HILO");
            Logger.getLogger(HiloServidorAdivina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {

        while (this.intentos != 5 && !this.objeto.seAcabo()) {
            try {
                
                String numero = bufferLecturaCliente.readLine();
                
                this.intentos++;
                
                Datos datos = new Datos(this.objeto.nuevaJugada( this.identificador,Integer.parseInt(numero)), this.intentos, identificador);
                
                
                if(objeto.numeroAdivinar==Integer.parseInt(numero)){
                    objeto.setAcabado(true);
                    objeto.setGanador(this.identificador);
                    
                    datos.setGana(true);
                    datos.setJuega(false);
                    
                    
                    this.fsalida.writeObject(datos);
                    
                    break;
                }else{
                    objeto.setAcabado(false);
                    
                    datos.setGana(false);
                    datos.setJuega(true);
                    
                    
                    this.fsalida.writeObject(datos);
                }
            } catch (IOException ex) {
                Logger.getLogger(HiloServidorAdivina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            System.out.println("JUEGO FINALIZADO "+ this.identificador);
            Datos dato = new Datos("EL JUEGO HA FINALIZADO", intentos, identificador);
            dato.setJuega(false);
            
            fsalida.writeObject(dato);
            
            fsalida.close();
            bufferLecturaCliente.close();
            socket.close();
        
        }catch (SocketException ex){
            System.out.println("ERROR EN EL SOCKET DEL CLIENTE: "+identificador);
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("ERROR EN E/S DEL CLIENTE: "+identificador);
        }
    }

}
