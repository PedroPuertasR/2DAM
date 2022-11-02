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
import modelo.Asignatura;

/**
 *
 * @author alumno
 */
public class DetalleController {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
     
    public static ArrayList getLista(String query){
        ArrayList<Asignatura> lista = new ArrayList<Asignatura>();
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                       
                Asignatura aux = new Asignatura(rs.getInt(1),
                                                    rs.getString(2),
                                                    rs.getInt(3),
                                                    rs.getFloat(4),
                                                    Herramienta.dateToGregorianCalendar(rs.getDate(5))
                );
                
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
    
    public static float getNotas(int cod){
        float total = 0;
        int contador = 0;
        
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM ASIGNATURA WHERE CODPROFESOR = " + cod);
            
            while(rs.next()){
                total += rs.getFloat(4);
                contador++;
            }
            
            total = total / contador;
            
            rs.close();
            st.close();
            
            return total;
        }catch(SQLException e){
            System.out.println("Error consulta notas");
            return 0;
        }        
    }
    
    public static Asignatura getAsignatura(){
        Asignatura aux = null;
        try{
            aux = new Asignatura(rs.getInt(1),
                                 rs.getString(2),
                                 rs.getInt(3),
                                 rs.getFloat(4),
                                 Herramienta.dateToGregorianCalendar(rs.getDate(5)));
        }catch(SQLException e){
            System.out.println("Fallo BBDD.");
        }
        return null;
    }
    
    public static void cargarDatos(String query){
        try {
            st = GestionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                  ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(query);
            
            if (rs.next()) {
                rs.first();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static boolean nextAsig(){
        try {
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Error al mostrar el siguiente.");
        }
        return false;
    }
    
    public static boolean prevAsig(){
        try {
            return rs.previous();
        } catch (SQLException ex) {
            System.out.println("Error al mostrar el anterior.");
        }
        return false;
    }
    
    public static boolean primero(){
        try{
            rs.isFirst();
        }catch(SQLException ex){
            System.out.println("No hay primero.");
        }
        return false;
    }
    
    public static boolean ultimo(){
        try{
            rs.isLast();
        }catch(SQLException ex){
            System.out.println("No hay último.");
        }
        return false;
    }
    
}
