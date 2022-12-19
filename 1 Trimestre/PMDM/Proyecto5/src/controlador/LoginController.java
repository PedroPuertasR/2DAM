/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import modelo.Proveedor;

/**
 *
 * @author Pernas
 */
public class LoginController {
        
    private static Statement st = null;
    private static ResultSet rs = null;
    private static Proveedor auxProv = null;
    
    public static void loginGetProveedor(String query){
        int cont = 0;
        try{
            st = ConnectionFactory.getConexion().createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                auxProv = new Proveedor( rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getFloat(4),
                                        rs.getString(5)
                );
                cont++;
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Error consulta proveedor login");
        }
        if (cont != 1) {
            auxProv = null;
            showMessageDialog(null, "No se ha devuelto usuario o se ha devuelto mas de uno con esas credenciales");
        }
    }

    public static Proveedor getAuxProv() {
        return auxProv;
    }
    
    
}
