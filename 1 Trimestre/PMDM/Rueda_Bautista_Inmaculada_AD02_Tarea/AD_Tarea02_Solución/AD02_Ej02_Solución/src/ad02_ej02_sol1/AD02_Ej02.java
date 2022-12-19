/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad02_ej02_sol1;

import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class AD02_Ej02 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException{
        ConsultasBBDD.consultaUno("desarrollo");
        ConsultasBBDD.consultaDos();
        ConsultasBBDD.consultaTres("20");
    }
    
}
