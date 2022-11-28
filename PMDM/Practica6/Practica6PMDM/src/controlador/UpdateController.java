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
            
            ps = con.prepareStatement("UPDATE TIENDA SET PRESUPUESTO = PRESUPUESTO - " 
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
            
            ps = con.prepareStatement("UPDATE TRABAJADOR SET FOTO = ?, DNI = ?, "
                    + "FECHA_CONT = ? WHERE ID = ?");
            
            ps.setString(1, foto);
            ps.setString(2, dni);
            ps.setString(3, fecha);
            ps.setInt(4, idTr);
            
            int filas = ps.executeUpdate();
            
            return filas;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al actualizar al "
                    + "trabajador con foto");
            return 0;
        }
    }
    
    public static int updateTrabajadorSinF(String dni, String fecha, int idTr){
        try{
            
            con = GestionDB.getConnection();
            
            ps = con.prepareStatement("UPDATE TRABAJADOR SET DNI = ?, "
                    + "FECHA_CONT = ? WHERE ID = ?");
            
            ps.setString(1, dni);
            ps.setString(2, fecha);
            ps.setInt(3, idTr);
            
            int filas = ps.executeUpdate();
            
            return filas;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al actualizar el trabajador");
            return 0;
        }
    }
    
    public static int insertarLibro(String datos){
        
        try {
            con = GestionDB.getConnection();
            
            st = con.createStatement();
            
            int filas = st.executeUpdate("INSERT INTO LIBRO VALUES ("+ datos + ")");
            
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
