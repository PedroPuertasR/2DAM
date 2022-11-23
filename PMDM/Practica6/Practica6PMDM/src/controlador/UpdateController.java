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
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.Trabajador;

/**
 *
 * @author alumno
 */
public class UpdateController {
    
    private static Statement st = null;
    private static PreparedStatement ps = null;
    private static Connection con = null;
    private static ResultSet rs = null;
    
    public static int updatePresupuesto(float pres, int id){
        try{
            
            con = GestionDB.getConnection();
            
            ps = con.prepareStatement("UPDATE TIENDA SET PRESUPUESTO = PRESUPUESTO + " 
                    + pres + " WHERE ID = " + id);
            
            int filas = ps.executeUpdate();
            
            return filas;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al actualizar el presupuesto");
            return 0;
        }
    }
    
    public static int updateTrabajador(String foto, String dni, String fecha, int idTr){
        try{
            
            con = GestionDB.getConnection();
            
            ps = con.prepareStatement("UPDATE TRABAJADOR SET FOTO = ? WHERE ID = ?");
            
            ps.setString(1, foto);
            ps.setInt(2, idTr);
            ps.setString(3, dni);
            ps.setString(4, fecha);
            
            int filas = ps.executeUpdate();
            
            return filas;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al actualizar el presupuesto");
            return 0;
        }
    }
    
    public static int insertarLibro(Libro l){
        
        try {
            con = GestionDB.getConnection();
            
            ps = con.prepareStatement("INSERT INTO LIBRO VALUES (" + l.getAtributos() + ")");
            
            int filas = ps.executeUpdate();
            
            return filas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el libro");
            return 0;
        }
        
        
    }
    
    public static int borrarLibro(char index){
        try{
            
            con = GestionDB.getConnection();
            
            ps = con.prepareStatement("DELETE FROM LIBRO WHERE ID = " + index);
            
            int filas = ps.executeUpdate();
            
            return filas;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al borrar el libro");
            return 0;
        }
    }
    
}
