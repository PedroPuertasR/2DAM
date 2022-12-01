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

    @Override
    public void run() {
        nap();
        cc.saca(1);
        nap();
        cc.mete(1);
    }

    private static void nap() {
        try {
            Thread.sleep((long) (100 * Math.random()));
        } catch (InterruptedException ignored) {
        }
    }
}
