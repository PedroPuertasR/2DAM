/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;

/**
 *
 * @author alumno
 */
public interface Fecha {
    public final static int DIA_DEL_MES = Calendar.DAY_OF_MONTH;
    public final static int MES_DEL_ANIO = Calendar.MONTH;
    public final static int ANIO = Calendar.YEAR;
    
    public abstract boolean mes();
    public abstract boolean trimestre();
    public abstract boolean semestre();
    public abstract boolean año();
}
