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
public class Principal {

    public static void main(String[] args) throws InterruptedException {
        
        CuentaCorriente cc = new CuentaCorriente();
        int N = 10;
        Cliente[] clientes = new Cliente[N];
        
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(cc);
        }
        for (Cliente cliente : clientes) {
            cliente.start();
        }
        for (Cliente cliente : clientes) {
            cliente.join();
        }
        System.out.println("CC.getN(): " + cc.getSaldo());
    }
}
