/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Editorial;
import modelo.Libro;
import modelo.Tienda;

/**
 *
 * @author alumno
 */
public class TablaController {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public static ArrayList getLista(String query){
        ArrayList<Libro> lista = new ArrayList<Libro>();
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                       
                Libro aux = new Libro(rs.getInt(1),
                                      rs.getString(2),
                                      rs.getString(3),
                                      rs.getInt(4),
                                      rs.getString(5),
                                      Herramienta.dateToGregorianCalendar(rs.getDate(6)),
                                      rs.getFloat(7),
                                      rs.getInt(8),
                                      rs.getInt(9));
                
                lista.add(aux);
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error consulta lista");
            return null;
        }        
        return lista;
    }
    
    public static Tienda getTienda(String query){
        
        Tienda aux;
        
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            aux = new Tienda(rs.getInt(1),
                             rs.getString(2),
                             rs.getFloat(3));
            
            return aux;
        }catch(SQLException es){
            JOptionPane.showInputDialog(null, "Error en la consulta.");
            return null;
        }
        
    }
    
    public static String getNomEdi(String query){
        
        String aux;
        
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            aux = rs.getString(1);
            
            return aux;
        }catch(SQLException es){
            JOptionPane.showInputDialog(null, "Error en la consulta de la editorial");
            return null;
        }
        
    }
    
    public static String getNomCate(String query){
        
        String aux;
        
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            aux = rs.getString(1);
            
            return aux;
        }catch(SQLException es){
            JOptionPane.showInputDialog(null, "Error en la consulta de la editorial");
            return null;
        }
        
    }
    
}
