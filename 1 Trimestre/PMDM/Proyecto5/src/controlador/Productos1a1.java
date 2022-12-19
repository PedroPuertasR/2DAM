package controlador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.*;

public class Productos1a1 {
    
    private static Statement stmt = null;
    private static ResultSet rset = null;
        
    public static void crearConsulta(String consulta){
        try {
            stmt = ConnectionFactory.getConexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                  ResultSet.CONCUR_READ_ONLY);
            rset = stmt.executeQuery(consulta);
            if (rset.next()) {
                rset.first();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static void ejecutaUpdate(String consulta){
        try {
            int filas;
            stmt = ConnectionFactory.getConexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                  ResultSet.CONCUR_READ_ONLY);
            filas = stmt.executeUpdate(consulta);
            JOptionPane.showMessageDialog(null, "Se han actualizado " + filas + " fila(s)");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static Producto devolverProducto() {
        Producto pv = null;
        try {
            pv = new Producto(rset.getInt(1),
                    rset.getString(2),
                    rset.getFloat(3),
                    rset.getDate(4),
                    rset.getInt(5));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al extraer el proveedor");
        }
        
        return pv;
    }
    
    public static boolean siguienteProducto()
    {
        try {
            return rset.next();
        } catch (SQLException ex) {
            Logger.getLogger(Productos1a1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean anteriorProducto()
    {
        try {
            return rset.previous();
        } catch (SQLException ex) {
            Logger.getLogger(Productos1a1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean esPrimero()
    {
        try {
            return rset.isFirst();
        } catch (SQLException ex) {
            Logger.getLogger(Productos1a1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean esUltimo()
    {
        try {
            return rset.isLast();
        } catch (SQLException ex) {
            Logger.getLogger(Productos1a1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void cerrarStmtyRset() {
        try {
            rset.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Productos1a1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}