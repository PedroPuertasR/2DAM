/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author alumno
 */
public class CuentaCorriente {

    private AtomicInteger saldo = new AtomicInteger(0);

    //Este método añade n a saldo y devuelve este más tarde
    public void mete(int n) {
        saldo.addAndGet(n);
    }

    //Este método resta n a saldo y devuelve este más tarde
    public void saca(int n) {
        saldo.addAndGet(-n);
    }

    //Este método devuelve el saldo
    public int getSaldo() {
        return saldo.get();
    }
}
