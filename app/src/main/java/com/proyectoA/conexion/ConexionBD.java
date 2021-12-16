package com.proyectoA.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection c = null;
    //private static String direccion = "jdbc:mysql://localhost/proyectosistemasweb?user=root&password=bryan444";
    private static String direccion = "jdbc:mysql://bbt7fzdbe42sfo749g5o-mysql.services.clever-cloud.com/bbt7fzdbe42sfo749g5o?user=ujjtociuihd6gub7&password=d5Ebad1O6lwOLYWccS4c";
    //Método estatico (que no requiere instancia) de la conexion a la base de datos
    public static Connection conectar(){
        try {
            //Conexion con el servidor en la nube. Se especifica el driver, host, base de datos, usuario y contraseña
            c = DriverManager.getConnection(direccion);
        }catch(SQLException ex){
            //Se maneja la excepción y se envia el mensaje a consola.
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        if(c==null){
            //Mensaje de conexion nula
            System.out.println("Conexión fallida.");
        }else{
            //Mensaje de conexion exitosa
            System.out.println("Conexión establecida (localhost)");
        }
        return c;
    }
}
