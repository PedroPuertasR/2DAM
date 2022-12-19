/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Herramienta;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Mensaje implements IFecha{
    
    /*
    numero         INTEGER PRIMARY KEY,
    asunto         VARCHAR(20),
    contenido 	 VARCHAR(100),
    leido          INTEGER,
    fecha          DATE, 
    cueCodigoOrigen    	 INTEGER,
    cueCodigoDestino   	 INTEGER,
    */
    
    private int numero;
    private String asunto;
    private String contenido;
    private int leido;
    private GregorianCalendar fecha;
    private int cuentaOrigen;
    private int cuentaDestino;

    public Mensaje() {
    }

    public Mensaje(int numero, String asunto, String contenido, int leido, GregorianCalendar fecha, int cuentaOrigen, int cuentaDestino) {
        this.numero = numero;
        this.asunto = asunto;
        this.contenido = contenido;
        this.leido = leido;
        this.fecha = fecha;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getLeido() {
        return leido;
    }

    public void setLeido(int leido) {
        this.leido = leido;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "numero=" + numero + ", asunto=" + asunto + ", contenido=" + contenido + ", leido=" + leido + ", fecha=" + fecha + ", cuentaOrigen=" + cuentaOrigen + ", cuentaDestino=" + cuentaDestino + '}';
    }
    
    public String infoMensaje(){
        if(leido == 0){
            if(esDeHoy(new GregorianCalendar())){
                return asunto + ", No leído, " + Herramienta.gregorianCalendarToString(fecha) + ", Nuevo*";
            }else{
                return asunto + ", No leído, " + Herramienta.gregorianCalendarToString(fecha);
            }
            
        }else{
            if(esDeHoy(new GregorianCalendar())){
                return asunto + ", Leído, " + Herramienta.gregorianCalendarToString(fecha) + ", Nuevo*";
            }else{
                return asunto + ", Leído, " + Herramienta.gregorianCalendarToString(fecha);
            }
        }
    }

    @Override
    public boolean esDeHoy(GregorianCalendar fechaHoy) {
        
        String fechaString = Herramienta.gregorianCalendarToString(fechaHoy);
        
        if(fechaString.equalsIgnoreCase(Herramienta.gregorianCalendarToString(fecha))){
            return true;
        }else{
            return false;
        }
    }
    
}
