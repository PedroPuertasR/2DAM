/**
* 
* @author Miguel Maria Vazquez Martinez
* Fifth practice of module PMDM.
* 
*/

package Controlador;

import modelo.Producto;
import java.sql.*;
import java.util.ArrayList;

public class ListaProductos {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    
     
    public static ArrayList getLista(String query){
        ArrayList<Producto> lista = new ArrayList<>();
        Connection con = null;
        
        try{
            con = ConnectionFactory.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                       
                Producto auxProd = new Producto( rs.getInt(1),
                                                rs.getString(2),
                                                rs.getFloat(3),
                                                rs.getDate(4),
                                                rs.getInt(5)
                );
                
                lista.add(auxProd);
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error consulta ArrayList");
        }        
        return lista;
    }
      
    
}   
