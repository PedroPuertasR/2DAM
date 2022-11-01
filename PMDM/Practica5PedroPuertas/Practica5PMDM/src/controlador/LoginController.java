/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Profesor;

/**
 *
 * @author alumno
 */
public class LoginController {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    private static Profesor aux = null;
    
    public static Profesor getConexion(String usuario, String pass){
        
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM PROFESOR WHERE USUARIO = '" + usuario
                                  + "' AND PASS = '" + pass + "'");
            
            rs.next();
                      
            aux = new Profesor( rs.getInt(1),
                                    rs.getString(2),
                                    rs.getFloat(3),
                                    Herramienta.dateToGregorianCalendar(rs.getDate(4)),
                                    AsignaturaDB.getNotas(rs.getInt(1)),
                                    rs.getString(6),
                                    rs.getString(7),
                                    rs.getString(8)
            );
                
            rs.close();
            st.close();
            
            return aux;
            
        }catch(SQLException e){
            System.out.println("Error consulta");
            return null;
        }catch(NullPointerException np){
            System.out.println("Error lista");
            return null;
        }
    }
    
    public static Profesor getProf(){
        return aux;
    }
    
}
