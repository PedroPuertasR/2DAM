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
public class Libro {
    
    private int id;
    private String autor;
    private String nombre;
    private int editorial;
    private String isbn;
    private GregorianCalendar fechaPub;
    private float precio;
    private int categoria;
    private int tienda;

    public Libro() {
    }

    public Libro(int id, String autor, String nombre, int editorial, String isbn, GregorianCalendar fechaPub, float precio, int categoria, int tienda) {
        this.id = id;
        this.autor = autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.isbn = isbn;
        this.fechaPub = fechaPub;
        this.precio = precio;
        this.categoria = categoria;
        this.tienda = tienda;
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

    public int getEditorial() {
        return editorial;
    }

    public void setEditorial(int editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public GregorianCalendar getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(GregorianCalendar fechaPub) {
        this.fechaPub = fechaPub;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getTienda() {
        return tienda;
    }

    public void setTienda(int tienda) {
        this.tienda = tienda;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", isbn=" + isbn + ", fechaPub=" + fechaPub + ", precio=" + precio + ", categoria=" + categoria + ", tienda=" + tienda + '}';
    }
    
    public String infoLibro(){
        return nombre + ", " + autor + ", " + isbn;
    }
    
    public String [] getAtributos(){
        String [] aux = {};
        
        return aux;
    }
    
}
