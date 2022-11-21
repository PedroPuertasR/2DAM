/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Libro;

/**
 *
 * @author alumno
 */
public class UpdateController {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public static void updatePresupuesto(String query){
        try{
            st = GestionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                  ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Se ha actualizado el presupuesto.");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error. No se han encontrado datos.");
            System.out.println("Error en el update.");
        }
    }
    
    public static void insertarLibro(Libro l){
        
        int contador = TablaController.getIdLibro("SELECT ID FROM LIBRO ORDER BY ID DESC");
        
        try {
            st = GestionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            st.executeUpdate("INSERT INTO LIBRO VALUES (" + (contador + 1) + ", " 
                                                        + "'" + l.getNombre() + "', "
                                                        + "'" + l.getAutor() + "', "
                                                        + l.getEditorial()+ ", "
                                                        + "'" + l.getIsbn() + "', "
                                                        + "'" + Herramienta.gregorianCalendarToString(l.getFechaPub()) + "', " 
                                                        + l.getPrecio() + ", " 
                                                        + l.getCategoria() + ", " 
                                                        + l.getTienda());
        } catch (SQLException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
