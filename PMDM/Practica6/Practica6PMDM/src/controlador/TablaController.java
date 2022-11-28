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
import modelo.Editorial;
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
    
    public static ArrayList getLibrosEdi(Trabajador t, Editorial e){
        
        ArrayList<Libro> lista = new ArrayList<Libro>();
        
        try{
            con = GestionDB.getConnection();
        
            if(t.getIdJefe() == 0){
                ps = con.prepareStatement("SELECT * FROM LIBRO WHERE ID_EDITORIAL = ?");
                ps.setInt(1, e.getId());
            }else{
                ps = con.prepareStatement("SELECT * FROM LIBRO WHERE ID_EDITORIAL = ? "
                        + "AND ID_TIENDA = ?");

                ps.setInt(1, e.getId());
                ps.setInt(2, t.getTienda());
                
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
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al cargar los libros");
            return null;
        }        
        return lista;
        
    }
    
    public static ArrayList getListaLibros(Trabajador t){
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
            JOptionPane.showMessageDialog(null, "Error al cargar los libros");
            return null;
        }        
        return lista;
    }
    
    public static ArrayList getCategorias(){
        ArrayList <Categoria> lista = new ArrayList <Categoria>();
        
        try {
            con = GestionDB.getConnection();
            
            ps = con.prepareStatement("SELECT * FROM CATEGORIA");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Categoria c = new Categoria(rs.getInt(1),
                                            rs.getString(2));
                
                lista.add(c);
            }
            
            ps.close();
            rs.close();
            
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al coger la categoria");
            return null;
        }
    }
    
    public static ArrayList getEditoriales(){
        ArrayList <Editorial> lista = new ArrayList <Editorial>();
        
        try {
            con = GestionDB.getConnection();
            
            ps = con.prepareStatement("SELECT * FROM EDITORIAL");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Editorial e = new Editorial(rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3));
                
                lista.add(e);
            }
            
            ps.close();
            rs.close();
            
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar las editoriales");
            return null;
        }
    }
    
    public static ArrayList getTiendas(){
        ArrayList <Tienda> lista = new ArrayList <Tienda>();
        
        try {
            con = GestionDB.getConnection();
            
            ps = con.prepareStatement("SELECT * FROM TIENDA");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Tienda t = new Tienda(rs.getInt(1),
                                      rs.getString(2),
                                      rs.getFloat(3));
                
                lista.add(t);
            }
            
            ps.close();
            rs.close();
            
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar las tiendas");
            return null;
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
            JOptionPane.showMessageDialog(null, "Error al coger la tienda");
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
            JOptionPane.showMessageDialog(null, "Error en la consulta de la editorial");
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
            JOptionPane.showMessageDialog(null, "Error al encontrar el "
                    + "nombre de la categoria");
            return null;
        }
        
    }
    
    public static int getIdLibro(){
        
        int aux;
        
        try{
            
            con = GestionDB.getConnection();
            
            st = con.createStatement();
            
            rs = st.executeQuery("SELECT ID FROM LIBRO ORDER BY ID DESC FETCH FIRST ROW ONLY");
            
            rs.next();
            
            aux = rs.getInt(1);
            
            return aux;
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conseguir el id del libro");
            return 0;
        }
        
    }
    
    public static float getTotalSalario(int idTienda){
        
        float aux = 0;
        
        try {
            con = GestionDB.getConnection();
            
            st = con.createStatement();
            
            rs = st.executeQuery("SELECT SALARIO FROM TRABAJADOR WHERE TIENDA = "+ idTienda);
            
            while(rs.next()){
                aux = aux + rs.getFloat(1);
            }
            
            return aux;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al recoger los salarios");
            return 0;
        }
        
    }
    
}
