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
    
    private static final String usuario = "usuario";
    private static final String pass = "usuario";
    private static Connection con = null;
    
    public static void open() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");	
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: exception loading driver class");
        }
               
        String url = "jdbc:derby://localhost:1527/libreria";
        try {
            con = DriverManager.getConnection(url, usuario, pass);
        } catch (SQLException ex) {
            System.out.println("ERROR: conexion");
        }
        
    }

    public static Connection getConnection() throws SQLException {
        return con;
    } 
    
    public static void close() {
        try {
            con.close();
        } catch (Exception ignored) {}
    }
    
}
