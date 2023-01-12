/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.Random;

/**
 *
 * @author pedro
 */
public class Cliente implements Runnable {

    private Puerta puerta;
    private Almacen almacen;
    private String nombre;
    private Random generador;
    private final int MAX = 10;

    public Cliente(Puerta p, Almacen a, String nombre) {
        this.puerta = p;
        this.almacen = a;
        this.nombre = nombre;
        generador = new Random();
    }

    //Método para hacer sleep al hilo un número aleatorio de milisegundos
    public void esperar() {
        try {
            int alea = generador.nextInt(100);
            Thread.sleep(alea);
        } catch (InterruptedException ex) {
            System.out.println("Fallo en el sleep.");
        }
    }

    /* Al iniciar el hilo el cliente entrará en un bucle for con un número
    * máximo de intentos para entrar por la puerta. Si no está ocupada intentará
    * entrar y en caso de que lo consiga esperará un tiempo aleatorio hasta 
    * salir y liberarla. Si hay productos en el almacén cogerá uno y si no se irá
    * sin nada. En caso de que termine el bucle for y no haya logrado coger ningún
    * producto mostrará un mensaje de que no pudo conseguirlo.
    */
    @Override
    public void run() {
        for (int i = 0; i < MAX; i++) {
            if (!puerta.estaOcupada()) {
                if (puerta.intentarEntrar()) {
                    System.out.println("El cliente " + nombre + " consigue entrar.");
                    esperar();
                    puerta.liberarPuerta();
                    if (almacen.cogerProducto()) {
                        System.out.println(this.nombre + " ha cogido un producto.");
                        System.out.println("Productos restantes: " 
                                + almacen.getNumProductos());
                        return;
                    } else {
                        System.out.println(
                                this.nombre + " me voy sin coger nada.");
                        return;
                    }
                }
            } else {
                esperar();
            }

        } 
        
        System.out.println(this.nombre + " lo intentó muchas veces y "
                + "no pudo coger nada.");
    }

}
