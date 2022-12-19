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
public class CuentaAhorro extends Cuenta{
    
    private double interesMensual; // Expresado en %
    private boolean bloqueada;

    public CuentaAhorro(double interesMensual, boolean bloqueada, String titular, double saldo, double saldoMinimo, Calendar fecha) throws ESaldoNoValido {
        super(titular, saldo, saldoMinimo, fecha, tipoCuenta.AHORRO);
        this.interesMensual = interesMensual;
        this.bloqueada = bloqueada;
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public void setInteresMensual(double interesMensual) {
        this.interesMensual = interesMensual;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    @Override
    public String toString() {
        return super.toString() + "interesAnual=" + interesMensual + ", bloqueada=" + bloqueada + '}';
    }
    
    
}
