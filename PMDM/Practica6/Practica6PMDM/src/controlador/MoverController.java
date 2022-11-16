/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Editorial;

/**
 *
 * @author alumno
 */
public class MoverController {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public static Editorial getEdi(){
        Editorial aux = null;
        try{
            aux = new Editorial(rs.getInt(1),
                                 rs.getString(2),
                                 rs.getString(3));
        }catch(SQLException e){
            System.out.println("Fallo BBDD.");
        }
        return aux;
    }
    
    public static void iniciar(String query){
        try {
            st = GestionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                  ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(query);
            
            if (rs.next()) {
                rs.first();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static boolean avanzar(){
        try {
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Error al mostrar el siguiente.");
        }
        return false;
    }
    
    public static boolean retroceder(){
        try {
            return rs.previous();
        } catch (SQLException ex) {
            System.out.println("Error al mostrar el anterior.");
        }
        return false;
    }
    
    public static boolean irPrimero(){
        try{
            return rs.isFirst();
        }catch(SQLException ex){
            System.out.println("No hay primero.");
        }
        return false;
    }
    
    public static boolean irUltimo(){
        try{
            return rs.isLast();
        }catch(SQLException ex){
            System.out.println("No hay último.");
        }
        return false;
    }
    
    public static boolean finalizar(){
        return false;
    }
    
}
