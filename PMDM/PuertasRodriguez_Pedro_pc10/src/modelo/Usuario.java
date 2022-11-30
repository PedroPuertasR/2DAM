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
public class Usuario {
    
    /*
        numero		    INTEGER,
        nombre		    VARCHAR(20),
        apellido		    VARCHAR(20),
        password		    VARCHAR(20),
        fechaNacimiento   DATE,
        foto  		    VARCHAR(20),
        PRIMARY KEY (numero)
    */
    
    private int numero;
    private String nombre;
    private String apellido;
    private String password;
    private GregorianCalendar fechaNacimiento;
    private String foto;

    
    public Usuario(int numero, String nombre, String apellido, String password, GregorianCalendar fechaNacimiento, String foto) {
        this.numero = numero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.foto = foto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "numero=" + numero + ", nombre=" + nombre + ", apellido=" + apellido + ", password=" + password + ", fechaNacimiento=" + fechaNacimiento + ", foto=" + foto + '}';
    }
    
}
