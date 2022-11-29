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
import modelo.Tienda;

/**
 *
 * @author alumno
 */
public class MoverController {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public static Editorial getEdi()throws ProgramExceptions{
        Editorial aux = null;
        try{
            aux = new Editorial(rs.getInt(1),
                                 rs.getString(2),
                                 rs.getString(3));
            return aux;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al conseguir la editorial");
            ProgramExceptions err = new ProgramExceptions(1);
            ProgramExceptions.guardarError(e.getMessage());
            throw err;
        }
    }
    
    public static Tienda getTienda()throws ProgramExceptions{
        Tienda aux = null;
        try{
            aux = new Tienda(rs.getInt(1),
                             rs.getString(2),
                             rs.getFloat(3));
            return aux;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al conseguir la tienda");
            ProgramExceptions err = new ProgramExceptions(1);
            ProgramExceptions.guardarError(e.getMessage());
            throw err;
        }
    }
    
    public static void iniciar(String query)throws ProgramExceptions{
        try {
            st = GestionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                  ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(query);
            
            if (rs.next()) {
                rs.first();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al iniciar la lista");
            ProgramExceptions err = new ProgramExceptions(5);
            ProgramExceptions.guardarError(ex.getMessage());
            throw err;
        }
    }
    
    public static boolean avanzar()throws ProgramExceptions{
        try {
            return rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al avanzar");
            ProgramExceptions err = new ProgramExceptions(5);
            ProgramExceptions.guardarError(ex.getMessage());
            throw err;
        }
    }
    
    public static boolean retroceder()throws ProgramExceptions{
        try {
            return rs.previous();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al retroceder");
            ProgramExceptions err = new ProgramExceptions(5);
            ProgramExceptions.guardarError(ex.getMessage());
            throw err;
        }
    }
    
    public static boolean irPrimero()throws ProgramExceptions{
        try{
            return rs.first();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error. No hay primero");
            ProgramExceptions err = new ProgramExceptions(5);
            ProgramExceptions.guardarError(ex.getMessage());
            throw err;
        }
    }
    
    public static boolean irUltimo()throws ProgramExceptions{
        try{
            return rs.last();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error. No hay último");
            ProgramExceptions err = new ProgramExceptions(5);
            ProgramExceptions.guardarError(ex.getMessage());
            throw err;
        }
    }
    
    public static boolean primero()throws ProgramExceptions{
        try{
            return rs.isFirst();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error. No hay primero");
            ProgramExceptions err = new ProgramExceptions(5);
            ProgramExceptions.guardarError(ex.getMessage());
            throw err;
        }
    }
    
    public static boolean ultimo()throws ProgramExceptions{
        try{
            return rs.isLast();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error. No hay último");
            ProgramExceptions err = new ProgramExceptions(5);
            ProgramExceptions.guardarError(ex.getMessage());
            throw err;
        }
    }
    
    public static boolean finalizar()throws ProgramExceptions{
        try {
            rs.close();
            return rs.isClosed();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error. No se ha podido finalizar");
            ProgramExceptions err = new ProgramExceptions(5);
            ProgramExceptions.guardarError(ex.getMessage());
            throw err;
        }
    }
    
}
