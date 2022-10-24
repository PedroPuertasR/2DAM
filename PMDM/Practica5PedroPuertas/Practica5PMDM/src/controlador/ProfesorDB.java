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
import modelo.Profesor;

/**
 *
 * @author alumno
 */
public class ProfesorDB {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
     
    public static ArrayList getLista(String query){
        ArrayList<Profesor> lista = new ArrayList<Profesor>();
        
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                       
                Profesor aux = new Profesor( rs.getInt(1),
                                        rs.getString(2),
                                        rs.getFloat(3),
                                        Herramienta.dateToGregorianCalendar(rs.getDate(4)),
                                        AsignaturaDB.getNotas(rs.getInt(0)),
                                        rs.getString(6),
                                        rs.getString(7),
                                        rs.getString(8)
                );
                
                lista.add(aux);
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error consulta");
        }        
        return lista;
    }
    
}
