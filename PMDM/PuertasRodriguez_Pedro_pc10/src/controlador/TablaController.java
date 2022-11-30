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
import modelo.Cuenta;
import modelo.Mensaje;

/**
 *
 * @author alumno
 */
public class TablaController {
    
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static Connection con = null;
    
    public static ArrayList<Mensaje> getMensajes(Cuenta c){
        
        ArrayList <Mensaje> lista = new ArrayList<Mensaje>();
        
        try {
            
            con = GestionDB.getCon();
            
            ps = con.prepareStatement("SELECT * FROM MENSAJE WHERE CUECODIGOORIGEN = ?");
            
            ps.setInt(1, c.getCodigo());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Mensaje aux = new Mensaje(rs.getInt(1),
                                          rs.getString(2),
                                          rs.getString(3),
                                          rs.getInt(4),
                                          Herramienta.dateToGregorianCalendar(rs.getDate(5)),
                                          rs.getInt(6),
                                          rs.getInt(7));
                lista.add(aux);
            }
            rs.close();
            ps.close();
            
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(TablaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public static int enviarMensaje(Mensaje j){
        
        try {
            con = GestionDB.getCon();
            
            st = con.createStatement();
            
            int filas = st.executeUpdate("INSERT INTO MENSAJE VALUES(" + j.getNumero() 
                    + ", '" + j.getAsunto() + "', " 
                    + ", '" + j.getContenido() + "', " 
                    + j.getLeido() + ", " 
                    + "'" + Herramienta.gregorianCalendarToString(j.getFecha()) + "', " 
                    + j.getCuentaOrigen() + ", " 
                    + j.getCuentaDestino()+")");
            
            return filas;
        } catch (SQLException ex) {
            Logger.getLogger(TablaController.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
}
