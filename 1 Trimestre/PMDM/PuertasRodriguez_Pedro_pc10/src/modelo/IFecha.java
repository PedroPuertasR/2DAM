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
public interface IFecha {
    
    public abstract boolean esDeHoy(GregorianCalendar fechaHoy);

}
