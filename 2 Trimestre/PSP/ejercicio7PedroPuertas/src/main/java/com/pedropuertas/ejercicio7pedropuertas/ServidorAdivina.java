/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pedropuertas.ejercicio7pedropuertas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Javir
 */
public class ServidorAdivina {

    public static void main(String args[]) throws IOException {
        
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");
        
        // Numero a adivinar entre 1 y 25
        int numero = (int) (1 + 25 * Math.random());
        System.out.println("NUMERO A ADIVINAR=> " + numero);
        
        Socket cliente;
        // Creamos el objeto
        
        ObjetoCompartido partida = new ObjetoCompartido(numero);
        
        //NUMERO PARA IDENTIFICAR A LOS JUGADORES
        int id=0;
        while (true) {
            id++;
            
            cliente = servidor.accept();
            HiloServidorAdivina hilo = new HiloServidorAdivina(cliente, partida, id);
            
            hilo.start();
        }
       
    }
}
