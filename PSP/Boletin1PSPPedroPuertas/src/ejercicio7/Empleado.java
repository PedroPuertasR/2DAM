/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Empleado implements Serializable{
    
    private String nombre;
    private double sueldo;
    private Date fecha;

    public Empleado(String nombre, double sueldo, int anio, int mes, int dia) {
        
        Calendar fechaCalendar = new GregorianCalendar(anio, mes, dia);
        
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.fecha = fechaCalendar.getTime();
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", sueldo=" + sueldo + ", fecha=" + fecha + '}';
    }    
    
}
