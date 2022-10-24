package AD02_Ej02_RuedaBautistaInmaculada;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inmaculada Rueda Bautista
 */

public class AD02_Ej02_RuedaBautistaInmaculada {
    
    //variable de conexión
    static Connection conexion = null;
   
    public static void main(String[] args){
        
        try{
            //iniciaremos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorait", "root", "ROOT");
            
            System. out.println("Estos son los resultados de la Consulta 1");
            System. out.println("-----------------------------------------");
            //llamamos a la primera consulta
            consulta1();
            System. out.println("-----------------------------------------");

            System. out.println("Estos son los resultados de la Consulta 2");
            System. out.println("-----------------------------------------");
            //llamamos a la segunda consulta
            consulta2();
            System. out.println("-----------------------------------------");

            System. out.println("Estos son los resultados de la Consulta 3");
            System. out.println("-----------------------------------------");
            System. out.println("Veamos primero los salarios de los empleados del departamento 20");
            System. out.println("----------------------------------------------------------------");
            //Mostramos los salarios antes de realizar la tercera consulta
            consultaSalario();

            System. out.println("-----------------------------------------------------------------------------------------");
            System. out.println("Veamos ahora los salarios de los empleados del departamento 20 tras el incremento del 10%");
            System. out.println("-----------------------------------------------------------------------------------------");
            //llamamos a la tercera consulta
            consulta3();
            //Mostramos los salarios después de realizar la tercera consulta
            consultaSalario();
        
            //controlamos las excepciones e indicamos el fin de la conexión
        }catch (Exception e) { 
            System.err.print("SQL Exception: " + e.toString());
        } finally {
            //Por ultimo, comprobamos si la conexion se ha quedado abierta y la cerramos.
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                // Recogemos las excepciones.
                System.err.print("Exception: " + e.toString());
            }
        
        }
    }
    
    
    //método para realizar la primera consulta 
    private static void consulta1() {
        
        try {
            //realizamos la consulta conectando con la bbdd
            PreparedStatement pstmt = conexion.prepareStatement("SELECT e.apellido, d.dnombre FROM consultorait.empleados e, consultorait.departamentos d "
                    + "where e.dept_no = d.dept_no and d.dnombre = 'DESARROLLO'");
            //guardamos en una variable el resultado
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                System.out.printf("Empleado: %s, Departamento: %s %n",result.getString(1),result.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AD02_Ej02_RuedaBautistaInmaculada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //método para realizar la segunda consulta
    private static void consulta2() {
        
        try {
            //realizamos la consulta conectando con la bbdd
            PreparedStatement pstmt = conexion.prepareStatement("SELECT d.dnombre, count(e.emp_no), sum(e.salario) FROM consultorait.empleados e, "
                    + "consultorait.departamentos d where e.dept_no = d.dept_no  group by d.dnombre");
            //guardamos en una variable el resultado
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                System.out.printf("Departamento: %s, Empleado: %s Presupuesto: %s %n",result.getString(1),result.getString(2), result.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AD02_Ej02_RuedaBautistaInmaculada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     //método para realizar la tercera consulta
    private static void consulta3() {
      
        try {
            //realizamos la consulta conectando con la bbdd
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE consultorait.empleados SET salario=salario*1.10 where dept_no = ?");
            pstmt.setInt(1,20);
            //guardamos en una variable el resultado
            int dpto = pstmt.executeUpdate();
          
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AD02_Ej02_RuedaBautistaInmaculada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    //método para consultar los salarios y llamarlo para ver si la consulta 3 ha realizado los cambios requeridos correctamente
    private static void consultaSalario() {
        try {
            PreparedStatement pstmt = conexion.prepareStatement("SELECT apellido, dept_no, salario FROM consultorait.empleados where dept_no= 20");
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                System.out.printf("Empleado: %s, Departamento: %s Salario: %s %n",result.getString(1),result.getString(2), result.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AD02_Ej02_RuedaBautistaInmaculada.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
     
}
