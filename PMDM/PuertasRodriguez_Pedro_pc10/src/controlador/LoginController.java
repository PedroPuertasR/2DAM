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
import modelo.Usuario;

/**
 *
 * @author alumno
 */
public class LoginController {
    
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static Connection con = null;
    private static Usuario aux = null;
    
    
    public static Usuario getConexion(String usuario, String pass){
        
        try{
            con = GestionDB.getCon();
            
            ps = con.prepareStatement("SELECT * FROM USUARIO WHERE NOMBRE = ? AND PASSWORD = ?");
            
            ps.setString(1, usuario);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            rs.next();
            
            aux = new Usuario(rs.getInt(1),
                              rs.getString(2),
                              rs.getString(3),
                              rs.getString(4),
                              Herramienta.dateToGregorianCalendar(rs.getDate(5)),
                              rs.getString(6));
            
            
            
            rs.close();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Logueado como " + usuario);
            return aux;
        }catch(SQLException ex){
            return null;
        }
    }
    
    public static Usuario getUsuario(){
        return aux;
    }
    
    
}
