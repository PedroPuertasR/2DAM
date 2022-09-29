/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2pedropuertas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author alumno
 */
public class Cuenta {
    
    private Cuenta siguiente = null;
    private Cuenta anterior = null;
    private static Cuenta inicial = null;
    private int numero;
    private Calendar fecha;
    private double saldo;
    private String propietario;
    
    public Cuenta(double saldo, String propietario) {
        if(inicial == null){
            inicial = this;
        }else{
            this.siguiente = Cuenta.inicial;
            this.siguiente.setAnterior(this);
            Cuenta.inicial = this;
        }
        this.numero = generarAleatorio(99999999, 10000000);
        this.fecha = new GregorianCalendar();
        this.saldo = saldo;
        this.propietario = propietario;
    }
    
    public Cuenta getSiguiente() {
        return siguiente;
    }

    public Cuenta getAnterior() {
        return anterior;
    }

    public static Cuenta getInicial() {
        return inicial;
    }
    
    public int getNumero() {
        return numero;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setSiguiente(Cuenta siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Cuenta anterior) {
        this.anterior = anterior;
    }

    public static void setInicial(Cuenta inicial) {
        Cuenta.inicial = inicial;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    //Métodos

    @Override
    public String toString() {
        return "Cuenta{" + "numero=" + numero + ", fecha=" + fecha + ", saldo=" + saldo + ", propietario=" + propietario + '}';
    }
    
    public int generarAleatorio (int max, int min){
        Random aleatorio = new Random();
        int num;
        
        num = aleatorio.nextInt(((max - min) - 1) + min);
        
        return num;
        
    }
    
    
    
}
