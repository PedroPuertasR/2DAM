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
public class Profesor {
    
    private int codProfesor;
    private String nombre;
    private float horas;
    private GregorianCalendar fechaContrato;
    private float notaCorteMedia;
    private String foto;
    private String usuario;
    private String pass;

    public Profesor() {
    }
    
    public Profesor(int codProfesor, String nombre, float horas, GregorianCalendar fechaContrato, float notaCorteMedia, String foto, String usuario, String pass) {
        this.codProfesor = codProfesor;
        this.nombre = nombre;
        this.horas = horas;
        this.fechaContrato = fechaContrato;
        this.notaCorteMedia = notaCorteMedia;
        this.foto = foto;
        this.usuario = usuario;
        this.pass = pass;
    }

    public int getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(int codProfesor) {
        this.codProfesor = codProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getHoras() {
        return horas;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }

    public GregorianCalendar getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(GregorianCalendar fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public float getNotaCorteMedia() {
        return notaCorteMedia;
    }

    public void setNotaCorteMedia(float notaCorteMedia) {
        this.notaCorteMedia = notaCorteMedia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Profesor{" + "codProfesor=" + codProfesor + ", nombre=" + nombre + ", horas=" + horas + ", fechaContrato=" + fechaContrato + ", notaCorteMedia=" + notaCorteMedia + ", foto=" + foto + ", usuario=" + usuario + ", pass=" + pass + '}';
    }
    
}
