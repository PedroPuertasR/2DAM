/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author alumno
 */
public class Cuenta {
    
    private int numero;
    private transient String titular;
    private double saldo;
    private Calendar fecha;

    public Cuenta() {
    }
    
    public Cuenta(String titular, double saldo, Calendar fecha) {
        this.numero = generarAleatorio(100, 1);
        this.titular = titular;
        this.saldo = saldo;
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", fecha=" + fecha + '}';
    }
    
    //Métodos
    
    public int generarAleatorio(int max, int min){
        Random aleatorio = new Random();
        int num;
        
        num = aleatorio.nextInt(max - min + 1) + min;
        
        return num;
    }
    
}
