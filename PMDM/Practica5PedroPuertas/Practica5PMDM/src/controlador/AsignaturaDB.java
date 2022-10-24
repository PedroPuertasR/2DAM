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
import modelo.Profesor;

/**
 *
 * @author alumno
 */
public class AsignaturaDB {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
     
    public static ArrayList getLista(String query){
        ArrayList<Asignatura> lista = new ArrayList<Asignatura>();
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                       
                Asignatura aux = new Asignatura(rs.getInt(0),
                                                    rs.getString(1),
                                                    rs.getInt(2),
                                                    rs.getFloat(3)
                );
                
                lista.add(aux);
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error consulta 1");
        }        
        return lista;
    }
    
    public static float getNotas(int cod){
        float total = 0;
        int contador = 0;
        String query = String.valueOf(cod);
        
        try{
            st = GestionDB.getConnection().createStatement();
            rs = st.executeQuery("SELECT notaCorte FROM asignatura WHERE codProfesor = " + query);
            
            while(rs.next()){
                total += rs.getFloat(0);
                contador++;
            }
            
            total = total / contador;
            
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error consulta 1");
        }        
        
        return total;
    }
    
}
