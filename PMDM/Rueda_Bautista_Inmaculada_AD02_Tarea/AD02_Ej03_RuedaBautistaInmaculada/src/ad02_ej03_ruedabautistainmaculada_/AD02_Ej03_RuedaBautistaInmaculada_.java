package ad02_ej03_ruedabautistainmaculada_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author Inmaculada Rueda Bautista
 */
public class AD02_Ej03_RuedaBautistaInmaculada_ {
    
    //creamos la variable de conexión
    static Connection conexion=null;
    
    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);
        
        //creamos las variables para el primer procedimiento
        int comisionInicial;
        int comisionFinal;
        
        //creamos las variables para el segundo procedimiento
        int salarioInicial;
        int salarioFinal;
        
        //creamos las variables para el tercer procedimiento
        int departamento;
        int porcentaje;
        
        //creamos la conexión con la bbdd
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/consultorait", "root", "ROOT");
       
            //Enunciado del primer ejercicio
            System.out.println("P.A. 1: Un procedimiento almacenado que obtenga en un parámetro de salida, el número total de empleados "
                    + "cuya comisión pertenece a un determinado intervalo. Se deben pasar como parámetros al procedimiento, tanto el valor "
                    + "inicial del intervalo como el valor final");
            System.out.println("----------------------------------------------");
            
            //controlamos que los valores sean correctos
            do{
                System.out.print("Introduzca la comisión inicial del rango: ");
                comisionInicial = teclado.nextInt();
                System.out.print("Introduzca la comisión final del rango: ");
                comisionFinal = teclado.nextInt();  
            }while (comisionInicial>comisionFinal);
            
            //llamamos al procedimiento y definimos los parámetros
            CallableStatement prcTotalEmpleadosPorComision = conexion.prepareCall("{ call TotalEmpleadosPorComision(?,?,?) }");
            
            //Parámetros de entrada y el parámetro de salida
            prcTotalEmpleadosPorComision.setInt(1, comisionInicial);
            prcTotalEmpleadosPorComision.setInt(2, comisionFinal);
            prcTotalEmpleadosPorComision.registerOutParameter(3, java.sql.Types.INTEGER);
            
            //Se ejecuta el procedimeinto creado
            prcTotalEmpleadosPorComision.execute();
            
            //Se crea la variable de salida donde se almacena el valor devuelto
            int resultado = prcTotalEmpleadosPorComision.getInt(3);
            
            //Mostramos por pantalla el resultado
            System.out.println("El nº total de empleados con una comision entre " + comisionInicial + " y " + comisionFinal + " es " + resultado);
            System.out.println("----------------------------------------------");
            
            //Enunciado del segundo ejercicio
            System.out.println("P.A. 2:  Un procedimiento almacenado que devuelva en un parámetro de salida, el número total de empleados dados de "
                     + "alta en la consultora, cuyo salario pertenece a un determinado intervalo económico. Se deben pasar como parámetros al procedimiento, "
                     + "tanto el valor inicial como el valor final de dicho intervalo");
            System.out.println("----------------------------------------------");
            
            //controlamos que los valores sean correctos
            do{
                System.out.print("Introduzca el salario inicial del rango: ");
                salarioInicial = teclado.nextInt();
                System.out.print("Introduzca el salario final del rango: ");
                salarioFinal = teclado.nextInt();
            }while (salarioInicial > salarioFinal);

            //llamamos al procedimiento y definimos los parámetros
            CallableStatement prcEmpleadosSegunSalario = conexion.prepareCall("{ call EmpleadosSegunSalario(?,?,?) }");

            //Parámetros de entrada y el parámetro de salida
            prcEmpleadosSegunSalario.setInt(1, salarioInicial);
            prcEmpleadosSegunSalario.setInt(2, salarioFinal);
            prcEmpleadosSegunSalario.registerOutParameter(3, java.sql.Types.INTEGER);
            
            //Ejecutamos el procedimiento creado
            prcEmpleadosSegunSalario.execute();

            //Se crea la variable de salida donde se almacena el valor devuelto
            int resultado2 = prcEmpleadosSegunSalario.getInt(3);
            
            //Mostramos por pantalla el resultado
            System.out.println("El total de empleados con un salario entre " + salarioInicial + " y " + salarioFinal + " es " + resultado2);
            System.out.println("----------------------------------------------");
            
            //Enunciado del tercer ejercicio
            System.out.println("P.A. 3:  Un procedimiento almacenado que aumente el salario de los empleados de cierto departamento en un "
                    + "porcentaje. El departamento y valor entero del porcentaje a aplicar se han de pasar como parámetros (de entrada)");
            System.out.println("----------------------------------------------");
            
            //Primero mostramos los salarios actuales
            consultaSalario();
            System.out.println("----------------------------------------------");

            System.out.print("Introduzca el departamento: ");
            departamento = teclado.nextInt();
            System.out.print("Introduzca el porcentaje a aumentar el salario: ");
            porcentaje = teclado.nextInt();
            System.out.println("----------------------------------------------");

            //llamamos al procedimiento y definimos los parámetros
            CallableStatement prpAumentoSalario = conexion.prepareCall("{ call AumentarSalario(?,?) }");
            
            //Parámetros de entrada y el parámetro de salida
            prpAumentoSalario.setInt(1, departamento);
            prpAumentoSalario.setInt(2, porcentaje);
            
            //Ejecutamos el procedimiento creado
            prpAumentoSalario.executeQuery();
            
            //Mostramos los salarios tras el incremento del porcentaje indicado para comprobar que se ha 
            //aumentado correctamente a los empleados del departamento indicado  
            consultaSalario();
        
        //controlamos sy hay un error en la conexión con la bbdd y cerramos la conexión sea así o tras finalizar el programa
        } catch (Exception e) { //Recogemos las excepciones.
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
    
    //método para consultar los salarios
    private static void consultaSalario() {
        try {
            PreparedStatement pstmt = conexion.prepareStatement("SELECT apellido, dept_no, salario FROM consultorait.empleados");
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                System.out.printf("Empleado: %s, Departamento: %s Salario: %s %n",result.getString(1),result.getString(2), result.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AD02_Ej03_RuedaBautistaInmaculada_.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
        
    
    
        


