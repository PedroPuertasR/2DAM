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
public class CuentaCorriente extends Cuenta{
    
    private float comisionMantenimiento;
    private String tipoComision; // Se calcula semetral o anual

    public CuentaCorriente(float comisionMantenimiento, String tipoComision, String titular, double saldo, double saldoMinimo, Calendar fecha) throws ESaldoNoValido {
        super(titular, saldo, saldoMinimo, fecha, tipoCuenta.CORRIENTE);
        this.comisionMantenimiento = comisionMantenimiento;
        this.tipoComision = tipoComision;
        
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public String getTipoComision() {
        return tipoComision;
    }

    public void setComisionMantenimiento(float comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public void setTipoComision(String tipoComision) {
        this.tipoComision = tipoComision;
    }

    @Override
    public String toString() {
        return super.toString() + "comisionMantenimiento=" + comisionMantenimiento + ", tipoComision=" + tipoComision + '}';
    }
    
    
    
}
