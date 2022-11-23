/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SacarDinero c = new SacarDinero("Pedro", new Cuenta(40));
        SacarDinero c2 = new SacarDinero("Pablo", new Cuenta(120));
        
        //Ejecutamos los hilos
        c.start();
        c2.start();     
    }
    
}

class Cuenta {

    private int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    //Método para restar una cantidad al saldo
    public void restar(int cantidad) {
        saldo = saldo - cantidad;
    }

    /*Método para retirar dinero de la cuenta que bloqueará el proceso en caso de 
    * que el saldo sea menor que el importe o negativo el hilo quedará en espera
    */
    public synchronized void RetirarDinero(int importe, String cliente) {
        if (getSaldo() >= importe) {
            try {
                //Realizamos un sleep cada vez que se vaya a restar
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error en la retirada de dinero.");
            }
            
            //Restamos el importe
            restar(importe);

            System.out.println("\n" + cliente + " retira: " + importe + "€. Saldo: " 
                    + getSaldo() + "€");
        }else {
            System.out.println("\n" + cliente + " no tiene saldo suficiente. Saldo: " 
                    + getSaldo() + "€");
            
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class SacarDinero extends Thread {

    private Cuenta cuenta;

    public SacarDinero(String cliente, Cuenta cuenta) {
        super(cliente);
        this.cuenta = cuenta;
    }

    //Cuando se ejecute el hilo intentará retirar 10 euros de la cuenta 8 veces
    @Override
    public void run() {
        
        for (int i = 1; i <= 8; i++) {
            cuenta.RetirarDinero(10, getName());
        }
    }// 
}