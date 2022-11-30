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
public class Cuenta {
    /*
    codigo		    INTEGER,
    email             VARCHAR(20),
    fechaAlta         DATE, 
    maximoMensajes    INTEGER, 
    costeMensajeExtra NUMERIC(6,2),
    usuNumero		    INTEGER,
    */
    
    private int codigo;
    private String email;
    private GregorianCalendar fechaAlta;
    private int maximo;
    private float coste;
    private int usuario;

    public Cuenta(int codigo, String email, GregorianCalendar fechaAlta, int maximo, float coste, int usuario) {
        this.codigo = codigo;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.maximo = maximo;
        this.coste = coste;
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "codigo=" + codigo + ", email=" + email + ", fechaAlta=" + fechaAlta + ", maximo=" + maximo + ", coste=" + coste + ", usuario=" + usuario + '}';
    }
    
    
}
