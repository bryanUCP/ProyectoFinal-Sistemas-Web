package com.proyectoA.dao;

import java.sql.*;

import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.obj.profesor;

public class profesorDAO {
    private static final String TABLA="profesor";

    public static boolean registrarProfesor(profesor usuarioDocente){
        boolean exito=false;
        try{
            String query =  " insert into "+TABLA+" (id, nombre, apellido, correo, clave, experiencia)"
                            + " values (?, ?, ?, ?, ?, ?)";
		
            PreparedStatement preparedStmt = ConexionBD.conectar().prepareStatement(query);
            preparedStmt.setInt(1, usuarioDocente.getId());
            preparedStmt.setString(2, usuarioDocente.getNombre());
            preparedStmt.setString(3, usuarioDocente.getApellido());
            preparedStmt.setString(4, usuarioDocente.getCorreo());
            preparedStmt.setString(5, usuarioDocente.getClave());
            preparedStmt.setString(6, usuarioDocente.getExperiencia());
            preparedStmt.execute();
            System.out.println("Docente creado.");
            exito=true;
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return exito;
    }

    public static profesor getProfesorByCorreo(String correo){
        profesor aux = null;

        Statement statement;

        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ TABLA + " where correo = '" + correo + "';");

            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                return null;
            }else{
               aux = new profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"), rs.getString("experiencia"));
                   
                        System.out.println(aux.getNombre());
            }
        }catch(SQLException e){
            System.out.println("estado SQL:" + e.getSQLState());
            System.out.println("codigo de error:" + e.getErrorCode());
            System.out.println(e.getMessage());
        }

        return aux;

    }


    public static profesor getProfesor(String correo, String clave){
        profesor aux = null;

        Statement statement;

        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ TABLA + " where correo = '" + correo + "' and clave = '" + clave + "';");

            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                System.out.println("correo" + correo + "clave" + clave);
                return null;
            }else{
               aux = new profesor(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getString("clave"), rs.getString("experiencia"));
                   
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
