package controlador;

import java.sql.*;

public class ConnectionFactory {

    private static Connection conexion = null;

    public static void abrirConexion(){
        conexion = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: exception loading driver class");
        }

        String url = "jdbc:derby://localhost:1527/proveedores";

        try {
            if(conexion == null) {
                System.out.println("Creando conexion...");
                conexion = DriverManager.getConnection(url, "proveedores", "proveedores");
                System.out.println("Conexion creada");
            } else {
                System.out.println("Ya conectado:");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: conexion");
        }

    }

    public static void close() {
        if (conexion != null)
            try {
                System.out.println("Cerrando conexion...");
                conexion.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException ignored) {
        } else {
            System.out.println("Conexion ya cerrada");
        }
    }

    public static Connection getConexion() {
        return conexion;
    }
}