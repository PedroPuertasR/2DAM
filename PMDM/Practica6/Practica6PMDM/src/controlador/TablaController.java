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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Libro;
import modelo.Tienda;
import modelo.Trabajador;

/**
 *
 * @author alumno
 */
public class TablaController {
    
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public static ArrayList getListaLibros(Trabajador t) throws SQLException{
        ArrayList<Libro> lista = new ArrayList<Libro>();
        
        try{
            con = GestionDB.getConnection();
        
            if(t.getIdJefe() == 0){
                ps = con.prepareStatement("SELECT * FROM LIBRO");
            }else{
                ps = con.prepareStatement("SELECT * FROM LIBRO WHERE ID_TIENDA = ?");

                ps.setInt(1, t.getTienda());
                
            }
            
            rs = ps.executeQuery();
            
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
            ps.close();
        }catch(SQLException e){
            System.out.println("Error consulta lista");
            return null;
        }        
        return lista;
    }
    
    public static ArrayList getCategorias(String query){
        ArrayList <Categoria> lista = new ArrayList <Categoria>();
        
        try {
            con = GestionDB.getConnection();
            
            ps = con.prepareStatement("SELECT * FROM CATEGORIA");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Categoria c = new Categoria(rs.getInt(1),
                                            rs.getString(2),
                                            );
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            JOptionPane.showInputDialog(null, "Error al encontrar el "
                    + "nombre de la categoria");
            return null;
        }
        
    }
    
    public static int getIdLibro(String query){
        
        int aux;
        
        try{
            
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            rs.next();
            
            aux = rs.getInt(1);
            
            return aux;
            
        }catch(SQLException ex){
            JOptionPane.showInputDialog(null, "Error en la consulta de la editorial");
            return 0;
        }
        
    }
    
}
