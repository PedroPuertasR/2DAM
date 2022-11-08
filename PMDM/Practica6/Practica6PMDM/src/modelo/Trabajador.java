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
public class Trabajador {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private GregorianCalendar fechaCont;
    private float salario;
    private int idJefe;
    private int tienda;
    private String usuario;
    private String pass;
    private String foto;

    public Trabajador() {
    }

    public Trabajador(int id, String nombre, String apellidos, String dni, GregorianCalendar fechaCont, float salario, int idJefe, int tienda, String usuario, String pass, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaCont = fechaCont;
        this.salario = salario;
        this.idJefe = idJefe;
        this.tienda = tienda;
        this.usuario = usuario;
        this.pass = pass;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public GregorianCalendar getFechaCont() {
        return fechaCont;
    }

    public void setFechaCont(GregorianCalendar fechaCont) {
        this.fechaCont = fechaCont;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getTienda() {
        return tienda;
    }

    public void setTienda(int tienda) {
        this.tienda = tienda;
    }
    
    @Override
    public String toString() {
        return "Trabajador{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", fechaCont=" + fechaCont + ", salario=" + salario + ", idJefe=" + idJefe + ", usuario=" + usuario + ", pass=" + pass + ", foto=" + foto + '}';
    }
    
}
