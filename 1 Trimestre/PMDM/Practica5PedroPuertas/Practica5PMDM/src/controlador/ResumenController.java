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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Asignatura;
import modelo.Profesor;

/**
 *
 * @author pedro
 */
public class ResumenController {
    
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
    
    public static Profesor getProf(){
        Profesor aux = null;
        
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM PROFESOR WHERE CODPROFESOR = " 
                    + LoginController.getProf().getCodProfesor());
            
            rs.next();
            
            aux = new Profesor( rs.getInt(1),
                                    rs.getString(2),
                                    rs.getFloat(3),
                                    Herramienta.dateToGregorianCalendar(rs.getDate(4)),
                                    rs.getFloat(5),
                                    rs.getString(6),
                                    rs.getString(7),
                                    rs.getString(8)
            );
        } catch (SQLException ex) {
            Logger.getLogger(ResumenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aux;
    }
    
    public static void updateMedia(String query){
        try{
            st = GestionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                  ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Se ha actualizado la nota media.");
        }catch(SQLException ex){
            System.out.println("Error en el update.");
        }
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
    
}
