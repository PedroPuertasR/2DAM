/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad02_ej02_sol1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author admin
 */
public class ConsultasBBDD {
       
    private static Connection conexion = null;
    private static PreparedStatement sentencia1 = null, sentencia3 = null;
    private static Statement sentencia2 = null;
    private static ResultSet rsConsulta1 = null, rsConsulta2 = null, rsConsulta3 = null;
    

    public static void consultaUno(String nombreDepar) {
        
        String nombreDeparMayus;
        nombreDeparMayus = nombreDepar.toUpperCase();
                        
        try {
            conexion = AccesoBBDD.establecerConexion();
            
            sentencia1 = conexion.prepareStatement("SELECT e.emp_no, e.apellido "
                                                + "FROM empleados e, departamentos d "
                                                + "WHERE e.dept_no = d.dept_no AND d.dnombre = ?");
            // Versión 2: Se introduce directamente en la consulta el nombre departamento que se le ha pasado al método.
            /*sentencia1 = conexion.prepareStatement("SELECT e.emp_no, e.apellido FROM consultorait.empleados e, consultorait.departamentos d "
                                                + "WHERE e.dept_no = d.dept_no AND d.dnombre = " + '"' + nombreDeparMayus + '"');*/
            // Versión 3: Consulta utilizando composición interna (INNER JOIN)
            /*sentencia1 = conexion.prepareStatement("SELECT e.emp_no, e.apellido FROM empleados INNER JOIN departamentos"
                                                + "on empleados.dept_no = departamentos.dept_no where departamentos.dnombre = ?");*/
            // Versión 4: Consulta utilizando composición externa (LEFT JOIN)
            /*sentencia1 = conexion.prepareStatement("SELECT e.emp_no, e.apellido FROM empleados e" 
                                                + "LEFT JOIN departamentos d on e.dept_no = d.dept_no where d.dnombre = ?")*/
            sentencia1.setString(1, nombreDeparMayus);
            rsConsulta1 = sentencia1.executeQuery();
            
            //Devolvemos por pantalla los resultados obtenidos tras ejecutar la query 1
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                                                   BB.DD. CONSULTORA IT");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Resultado consulta 1: Empleados que pertenecen a un determinado departamento ");
            
            while (rsConsulta1.next()) {
                System.out.println("Número de empleado: " + rsConsulta1.getInt(1) + " Apellido: " + rsConsulta1.getString(2));
                /*+ " Oficio: " + rsConsulta1.getString(3) + " Dirección: " + rsConsulta1.getString(4) + " Fecha de alta: " + rsConsulta1.getString(5) + 
                " Salario: " + rsConsulta1.getString(6) + " Comisión: " + rsConsulta1.getString(7) + " Número departamento: " + rsConsulta1.getString(8));*/
            }
            System.out.println("Se han mostrado todos los empleados del departamento " + nombreDepar + ", si no hay registros es que no existen empleados asociados al mismo.");

        } catch (SQLException e) {
            muestraErrorSQL(e);   
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            if (conexion != null){
                try {
                if (sentencia1 != null)
                    sentencia1.close(); //Cerramos la consulta 1
                if (rsConsulta1 != null)
                    rsConsulta1.close(); //Cerramos el ResultSet 1
                AccesoBBDD.cerrarConexion(conexion); //Llamada a método de cierre de conexión
                } catch (SQLException ex) {
                    muestraErrorSQL(ex);
                }
            }
        }
    }
    public static void consultaDos(){
        
              
        try {
            conexion = AccesoBBDD.establecerConexion();
            
            String query2 = ("SELECT d.dnombre, count(e.dept_no), sum(salario + comision) "
                           + "FROM empleados e, departamentos d "
                           + "WHERE d.dept_no = e.dept_no "
                           + "GROUP BY 1");
            
            sentencia2 = (Statement) conexion.createStatement();
            
            rsConsulta2 = sentencia2.executeQuery(query2);
            
            //Devolvemos por pantalla los resultados obtenidos tras ejecutar la query 2
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("                                    BB.DD. CONSULTORA IT");
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("Resultado consulta 2: Nº de empleados y presupuesto por departamento ");
            
            while (rsConsulta2.next()) {
                System.out.println("Número de departamento; " + rsConsulta2.getString(1) + "Número de trabajadores: "
                + rsConsulta2.getInt(2) + "Presupuesto: " + rsConsulta2.getInt(3));
            }
            System.out.println("Se han mostrado el nº de empleados y la cantidad presupuestaria destinada a cada departamento.");
        
        } catch (SQLException e) {
            muestraErrorSQL(e); 
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            if (conexion != null){
                try {
                if (sentencia2 != null)
                    sentencia2.close(); //Cerramos la consulta 2
                if (rsConsulta2 != null)
                    rsConsulta2.close(); //Cerramos el ResultSet 2
                AccesoBBDD.cerrarConexion(conexion); //Llamada a método de cierre de conexión
                } catch (SQLException ex) {
                    muestraErrorSQL(ex);
                }
            }
        }
    }
    
    public static void consultaTres(String departamento){
        
        try {
            conexion = AccesoBBDD.establecerConexion();
            
            sentencia3 = conexion.prepareStatement("SELECT e.emp_no, e.apellido, e.salario, (e.salario*1.10), d.dept_no "
                                                  + "FROM empleados e, departamentos d "
                                                  + "WHERE e.dept_no= d.dept_no AND d.dept_no= ?");
            //Versión 2: Consulta utilizando composición externa (LEFT JOIN)
            /*sentencia1 = conexion.prepareStatement("SELECT e.emp_no, e.apellido, e.salario , (e.salario*1.10)"
                                                    + "FROM empleados e LEFT JOIN departamentos d"
                                                    + "ON e.dept_no = d.dept_no where d.dept_no= ?");*/
            sentencia3.setString(1, departamento);
            rsConsulta3 = sentencia3.executeQuery();
            
            //Devolvemos por pantalla los resultados obtenidos tras ejecutar la query 3
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                                                                       BB.DD. CONSULTORA IT");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Resultado consulta 3: Incremento salarial del 10% de empleados de un determinado departamento ");
            
            while (rsConsulta3.next()) {
                System.out.println("Número de empleado: " + rsConsulta3.getInt(1) + " Apellido: " + rsConsulta3.getString(2) + " Salario: " + rsConsulta3.getInt(3)
                        + " Salario incrementado un 10%: " + rsConsulta3.getInt(4) + " Número de departamento: " + rsConsulta3.getInt(5));
            }
            System.out.println("Se han mostrado todos los empleados con el aumento de sueldo realizado del departamento " + departamento + ", si no hay registros es que no existen empleados asociados al mismo.");
            
        } catch (SQLException e) {
            muestraErrorSQL(e);    
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            if (conexion != null){
                try {
                if (sentencia3 != null)
                    sentencia3.close(); //Cerramos la consulta 3
                if (rsConsulta3 != null)
                    rsConsulta3.close(); //Cerramos el ResultSet 3
                AccesoBBDD.cerrarConexion(conexion); //Llamada a método de cierre de conexión
                } catch (SQLException ex) {
                    muestraErrorSQL(ex);
                }
            }
        }
    }    
    //Método que gestiona en profundidad los errores de SQL
    public static void muestraErrorSQL(SQLException e) {
        System.err.println("SQL ERROR mensaje: " + e.getMessage());
        System.err.println("SQL Estado: " + e.getSQLState());
        System.err.println("SQL código específico: " + e.getErrorCode());
    }
}
   
