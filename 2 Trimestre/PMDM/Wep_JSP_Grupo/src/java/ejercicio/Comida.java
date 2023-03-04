package ejercicio;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class Comida {
    
    private String nombre;
    private String pais;
    private Date fecha_inv;
    private int calorias;
    private String foto;

    public Comida() {
    }
    
    public Comida(String nombre, String pais, Date fecha_inv, int calorias, String foto) {
        this.nombre = nombre;
        this.pais = pais;
        this.fecha_inv = fecha_inv;
        this.calorias = calorias;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public Date getFecha_inv() {
        return fecha_inv;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setFecha_inv(Date fecha_inv) {
        this.fecha_inv = fecha_inv;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Comida{" + "nombre=" + nombre + ", pais=" + pais + ", fecha_inv=" + fecha_inv + ", calorias=" + calorias + ", foto=" + foto + '}';
    }

}
