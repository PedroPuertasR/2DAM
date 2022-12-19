/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Asignatura {
    
    /*
    codAsignatura INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    codProfesor INTEGER NOT NULL,
    notaCorte DECIMAL (5,2) NOT NULL,
    */
 
    private int codAsignatura;
    private String nombre;
    private int codProfesor;
    private float notaCorte;
    private GregorianCalendar fechaCorte;

    public Asignatura() {
    }

    public Asignatura(int codAsignatura, String nombre, int codProfesor, float notaCorte, GregorianCalendar fechaCorte) {
        this.codAsignatura = codAsignatura;
        this.nombre = nombre;
        this.codProfesor = codProfesor;
        this.notaCorte = notaCorte;
        this.fechaCorte = fechaCorte;
    }

    public int getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(int codProfesor) {
        this.codProfesor = codProfesor;
    }

    public float getNotaCorte() {
        return notaCorte;
    }

    public void setNotaCorte(float notaCorte) {
        this.notaCorte = notaCorte;
    }

    public GregorianCalendar getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(GregorianCalendar fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "codAsignatura=" + codAsignatura + ", nombre=" + nombre + ", codProfesor=" + codProfesor + ", notaCorte=" + notaCorte + ", fechaCorte=" + fechaCorte + '}';
    }
    
    public String infoAsig(){
        return "Nombre: " + nombre + ". Código: " + codAsignatura + ". Nota corte: " + notaCorte;
    }
    
}
