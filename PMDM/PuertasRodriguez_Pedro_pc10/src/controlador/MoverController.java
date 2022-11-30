/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cuenta;

/**
 *
 * @author alumno
 */
public class MoverController {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public static Cuenta getCuenta(){
        Cuenta aux = null;
        
        try {
            aux = new Cuenta(rs.getInt(1),
                            rs.getString(2),
                            Herramienta.dateToGregorianCalendar(rs.getDate(3)),
                            rs.getInt(4),
                            rs.getFloat(5),
                            rs.getInt(6));
            
            return aux;
        } catch (SQLException ex) {
            Logger.getLogger(MoverController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void iniciar(String query){
        try {
            st = GestionDB.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            rs = st.executeQuery(query);
            
            if(rs.next()){
                rs.first();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MoverController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean avanzar(){
        try{
            return rs.next();
        }catch(SQLException e){
            return false;
        }
    }
    
    public static boolean retro(){
        try{
            return rs.previous();
        }catch(SQLException e){
            return false;
        }
    }
    
    public static boolean irPrimero(){
        try {
            return rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(MoverController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean irUltimo(){
        try {
            return rs.last();
        } catch (SQLException ex) {
            Logger.getLogger(MoverController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean primero(){
        try {
            return rs.isFirst();
        } catch (SQLException ex) {
            Logger.getLogger(MoverController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean ultimo(){
        try {
            return rs.isLast();
        } catch (SQLException ex) {
            Logger.getLogger(MoverController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean finalizar(){
        try {
            rs.close();
            return rs.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(MoverController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
