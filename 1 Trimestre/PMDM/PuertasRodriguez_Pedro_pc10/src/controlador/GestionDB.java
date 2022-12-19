/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class GestionDB {
    
    public static final String usuario = "java22";
    public static final String pass = "java22";
    public static Connection con = null;
    
    public static void open(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }catch(ClassNotFoundException e){
            System.out.println("Error al entrar en la BBDD");
        }
        
        String url = "jdbc:derby://localhost:1527/java22";
        
        try {
            con = DriverManager.getConnection(url, usuario, pass);
        } catch (SQLException ex) {
            
        }
    }
    
    public static Connection getCon() throws SQLException{
        return con;
    }
    
    public static void close(){
        try{
            con.close();
        }catch(Exception ignored){
        }
    }
    
}
