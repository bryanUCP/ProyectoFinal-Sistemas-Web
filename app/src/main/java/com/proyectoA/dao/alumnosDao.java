package com.proyectoA.dao;
import java.sql.*;

import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.obj.alumnos;

public class alumnosDao {
    private static final String TABLA="alumnos";
    public static boolean registrarAlumno(alumnos usuarioAlumno){
        boolean exito=false;
        try{
            String query =  " insert into "+TABLA+" (id, nombre,apellido, correo, clave)"
                            + " values (?, ?, ?, ?, ?)";
		
            PreparedStatement preparedStmt = ConexionBD.conectar().prepareStatement(query);
            preparedStmt.setInt(1, usuarioAlumno.getId());
            preparedStmt.setString(2, usuarioAlumno.getNombre());
            preparedStmt.setString(3, usuarioAlumno.getApellido());
            preparedStmt.setString(4, usuarioAlumno.getCorreo());
            preparedStmt.setString(5, usuarioAlumno.getClave());
            preparedStmt.execute();
            System.out.println("Alumno creado.");
            exito=true;
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return exito;
    }

    public static alumnos getAlumnoByCorreo(String correo){
        alumnos aux = null;

        Statement statement;

        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ TABLA + " where correo = '" + correo + "';");

            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                return null;
            }else{
               aux = new alumnos(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"));
                   
                        System.out.println(aux.getNombre());
            }
        }catch(SQLException e){
            System.out.println("estado SQL:" + e.getSQLState());
            System.out.println("codigo de error:" + e.getErrorCode());
            System.out.println(e.getMessage());
        }

        return aux;

    }



    public static alumnos getAlumno(String correo, String clave){
        alumnos aux = null;

        Statement statement;

        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ TABLA + " where correo = '" + correo + "' and clave = '" + clave + "';");

            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                System.out.println("correo" + correo + "clave" + clave);
                return null;
            }else{
               aux = new alumnos(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"));
                   
                        System.out.println(aux.getNombre());
            }
        }catch(SQLException e){
            System.out.println("estado SQL:" + e.getSQLState());
            System.out.println("codigo de error:" + e.getErrorCode());
            System.out.println(e.getMessage());
        }





        return aux;

        


    }

    public static alumnos getAlumnoById(int id){
        alumnos aux = null;

        Statement statement;

        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ TABLA + " where id = '" + id + "';");

            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                return null;
            }else{
               aux = new alumnos(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"));
                   
                        System.out.println(aux.getNombre());
            }
        }catch(SQLException e){
            System.out.println("estado SQL:" + e.getSQLState());
            System.out.println("codigo de error:" + e.getErrorCode());
            System.out.println(e.getMessage());
        }

        return aux;

    }

    
    
}




    

    

