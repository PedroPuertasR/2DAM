/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cuenta cuenta = new Cuenta(40);
        SacarDinero cliente1 = new SacarDinero("Inma", cuenta);
        SacarDinero cliente2 = new SacarDinero("Jorge", cuenta);
        cliente1.start();
        cliente2.start();
        
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

    public void restar(int cantidad) {
        saldo = saldo - cantidad;
    }

    public synchronized void RetirarDinero(int importe, String cliente) {
        if (getSaldo() >= importe) {
            System.out.println(cliente + ": SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }

            restar(importe);
            System.out.println("\t" + cliente + " retira =>" + importe + " ACTUAL(" + getSaldo() + ")");
        } else {
            System.out.println(cliente + " No puede retirar dinero, NO HAY SALDO(" + getSaldo() + ")");
        }

        if (getSaldo() < 0) {
            System.out.println("SALDO NEGATIVO => " + getSaldo());
        }
    }
}

class SacarDinero extends Thread {

    private Cuenta cuenta;

    public SacarDinero(String cliente, Cuenta cuenta) {
        super(cliente);
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            cuenta.RetirarDinero(10, getName());
        }
    }// 
}