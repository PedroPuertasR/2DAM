package com.example.usuarios;

import java.io.Serializable;
import java.util.Date;

public class Datos implements Serializable {

    private String nombre;

    private String fecha;

    private String email;

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }


    public String getEmail() {

        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}
