/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Cuenta {
    
    private int numero;
    private Calendar fecha;
    private double saldo;
    private String propietario;

    public Cuenta() {
        this(new GregorianCalendar(), 2030, "Pedro Puertas");
    }
    
    public Cuenta(Calendar fecha, double saldo, String propietario) {
        this.numero = contador();
        this.fecha = fecha;
        this.saldo = saldo;
        this.propietario = propietario;
    }

    public int getNumero() {
        return numero;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numero=" + numero + ", fecha=" + fecha + ", saldo=" + saldo + ", propietario=" + propietario + '}';
    }
    
    public static int contador(){
        int num = 1;
        
        num++;
        
        return num;
    }
    
}
