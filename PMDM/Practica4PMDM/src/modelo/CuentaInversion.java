/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ESaldoNoValido;
import java.util.Calendar;

/**
 *
 * @author alumno
 */
public class CuentaInversion extends Cuenta{
    
    private float beneficio; // 10% positivo o negativo del saldo y se calcula trimestral
    private double totalInvertido;

    public CuentaInversion(double totalInvertido, String titular, double saldo, double saldoMinimo, Calendar fecha) throws ESaldoNoValido {
        super(titular, saldo, saldoMinimo, fecha, tipoCuenta.INVERSION);
        
        this.beneficio = (float) generarAleatorio(10, -10) / 100;
        this.totalInvertido = totalInvertido; 
    }

    public float getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(float beneficio) {
        this.beneficio = beneficio;
    }

    public double getTotalInvertido() {
        return totalInvertido;
    }

    public void setTotalInvertido(double totalInvertido) {
        this.totalInvertido = totalInvertido;
    }

    @Override
    public String toString() {
        return super.toString() + "beneficio=" + beneficio + ", totalInvertido=" + totalInvertido + '}';
    }
    
    
    
}
