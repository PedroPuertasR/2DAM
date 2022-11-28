/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alumno
 */
public class Tienda {
    
    private int id;
    private String direccion;
    private float presupuesto;
    
    public Tienda() {
    }

    public Tienda(int id, String direccion, float presupuesto) {
        this.id = id;
        this.direccion = direccion;
        this.presupuesto = presupuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Tienda{" + "id=" + id + ", direccion=" + direccion + ", presupuesto=" + presupuesto + '}';
    }
    
    
    
}
