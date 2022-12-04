/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

/**
 *
 * @author alumno
 */
public class Cliente extends Thread {

    private final CuentaCorriente cc;

    public Cliente(CuentaCorriente cc) {
        this.cc = cc;
    }

    /* Al iniciar el hilo hace que espere un tiempo aleatorio y resta del saldo
    * de la cuenta 1. Espera otra vez un tiempo aleatorio y le suma al saldo 1.
    */
    @Override
    public void run() {
        nap();
        cc.saca(1);
        nap();
        cc.mete(1);
    }

    //Este método duerme el hilo un tiempo aleatorio
    private static void nap() {
        try {
            Thread.sleep((long) (100 * Math.random()));
        } catch (InterruptedException ignored) {
        }
    }
}
