/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ESaldoNoValido;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author alumno
 */
public class Cuenta implements Fecha, Serializable {

    private int numero;
    private transient String titular;
    private double saldo;
    private double saldoMinimo;
    private Calendar fecha;
    public enum tipoCuenta {
        AHORRO, CORRIENTE, INVERSION
    }
    private tipoCuenta tipoCuenta;

    public Cuenta() {
    }

    public Cuenta(String titular, double saldo, double saldoMinimo, Calendar fecha, tipoCuenta tipo) throws ESaldoNoValido {
        this.numero = generarAleatorio(1000, 1);
        this.titular = titular; // Debe ser alfanumerico y trascient o no serializable
        this.saldo = saldo;
        this.saldoMinimo = saldoMinimo;
        this.fecha = fecha;
        this.tipoCuenta=tipo;
        controlSaldo();
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

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
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

    public tipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(tipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
    

    @Override
    public String toString() {
        return "Cuenta{" + "numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + '}';
    }
    
    public String toStringJlist(){
        return numero+ " --- "+titular+ " --- "+saldo+ " --- "+tipoCuenta;
    }

    //Métodos
    public int generarAleatorio(int max, int min) {
        Random aleatorio = new Random();
        int num;

        num = aleatorio.nextInt(max - min + 1) + min;

        return num;
    }

    public void controlSaldo() throws ESaldoNoValido {
        if (saldo < saldoMinimo) {
            // throw new ESaldoNoValido();
            throw new ESaldoNoValido("El saldo " + this.saldo + " €, no debe ser menor que "
                    + "el saldo mínimo < " + this.saldoMinimo + "€.");
        }
    }

    @Override
    public boolean mes() {

        if (fecha.get(DIA_DEL_MES) == Fecha.DIA_DEL_MES) {
            return true;

        } else {
            return false;
        }
    }

    @Override
    public boolean trimestre() {
        if (Fecha.MES_DEL_ANIO >= (fecha.get(MES_DEL_ANIO)) + 3) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean semestre() {
        if (Fecha.MES_DEL_ANIO >= (fecha.get(MES_DEL_ANIO)) + 6) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public boolean año() {
        if (Fecha.ANIO > (fecha.get(ANIO))) {
            return true;
        } else {
            return false;

        }
    }
    

}
