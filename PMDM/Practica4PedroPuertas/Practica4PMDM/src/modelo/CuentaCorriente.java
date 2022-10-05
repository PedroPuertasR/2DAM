/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;

/**
 *
 * @author alumno
 */
public class CuentaCorriente extends Cuenta{
    
    private double mantenimiento;
    private String tipoComision;

    public CuentaCorriente(double mantenimiento, String tipoComision, String titular, double saldo, Calendar fecha) {
        super(titular, saldo, fecha);
        this.mantenimiento = mantenimiento;
        this.tipoComision = tipoComision;
    }

    public double getMantenimiento() {
        return mantenimiento;
    }

    public String getTipoComision() {
        return tipoComision;
    }

    public void setMantenimiento(double mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public void setTipoComision(String tipoComision) {
        this.tipoComision = tipoComision;
    }

    @Override
    public String toString() {
        return super.toString() + "mantenimiento=" + mantenimiento + ", tipoComision=" + tipoComision + '}';
    }
    
    
    
}
