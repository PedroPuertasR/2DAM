/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Trabajador;

/**
 *
 * @author alumno
 */
public class LoginController {
    
    private static Connection con = null;
    private static ResultSet rs = null;
    private static Trabajador aux = null;
    
    public static Trabajador getConexion(String usuario, String pass){
        
        try{
            
            GestionDB.open();
            
            con = GestionDB.getConnection();
            
            PreparedStatement ps = con.prepareStatement("SELECT * "
            + "FROM TRABAJADOR WHERE USUARIO = ? AND PASS = ?");
            
            ps.setString(1, usuario);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            rs.next();
            
            aux = new Trabajador(rs.getInt(1),
                                 rs.getString(2),
                                 rs.getString(3), 
                                 rs.getString(4), 
                                 Herramienta.dateToGregorianCalendar(rs.getDate(5)),
                                 rs.getFloat(6), 
                                 rs.getInt(7), 
                                 rs.getInt(8), 
                                 rs.getString(9),
                                 rs.getString(10), 
                                 rs.getString(11));
            
        }catch(SQLException sql){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }catch(NullPointerException ne){
            JOptionPane.showMessageDialog(null, "Error lista");
        }
        
        JOptionPane.showMessageDialog(null, "Logueado como " + aux.getNombre());
        return aux;
        
    }
    
    public static Trabajador getTrabajador(){
        return aux;
    }
    
}
