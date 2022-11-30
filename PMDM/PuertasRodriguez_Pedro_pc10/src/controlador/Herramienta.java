/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Herramienta {
 
    public static String gregorianCalendarToString(GregorianCalendar gc){
        SimpleDateFormat sfd = new SimpleDateFormat("MM/dd/yyyy");
        return sfd.format(gc.getTime());
    }

    public static GregorianCalendar dateToGregorianCalendar(Date d){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(d);
        return gc;
    }
    
}
