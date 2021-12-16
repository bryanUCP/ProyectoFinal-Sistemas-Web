package com.proyectoA.dao;

import java.sql.*;

import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.obj.alumnoCuestionarios;

public class alumnoCuestionarioDAO {
    private static final String TABLA="alumnoCuestionarios";

    public static boolean registrarAlumnoCuestionario(alumnoCuestionarios cuesAlum){
        boolean exito=false;
        try{
            String query =  " insert into "+TABLA+" (id, id_alumno, id_cuestionario, puntaje)"
                            + " values (?, ?, ?, ?)";
        
            PreparedStatement preparedStmt = ConexionBD.conectar().prepareStatement(query);
            preparedStmt.setInt(1, cuesAlum.getId());
            preparedStmt.setInt(2, cuesAlum.getId_alumno());
            preparedStmt.setInt(3, cuesAlum.getId_cuestionario());
            preparedStmt.setInt(4, cuesAlum.getPuntaje());
            preparedStmt.execute();
            System.out.println("cuestionario asignado al alumno.");
            exito=true;
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return exito;
    }
}
