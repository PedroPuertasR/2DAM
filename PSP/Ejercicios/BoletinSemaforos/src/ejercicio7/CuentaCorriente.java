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

    public void mete(int n) {
        saldo.addAndGet(n);
    }

    public void saca(int n) {
        saldo.addAndGet(-n);
    }

    public int getSaldo() {
        return saldo.get();
    }
}
