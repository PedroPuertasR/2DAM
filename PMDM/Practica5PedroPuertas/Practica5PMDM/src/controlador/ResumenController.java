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
import modelo.Asignatura;

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
    
}
