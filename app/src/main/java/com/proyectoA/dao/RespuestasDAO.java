package com.proyectoA.dao;
import java.sql.*;

import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.obj.Respuestas;

public class RespuestasDAO {
    private static final String TABLA="Respuestas";

    public static boolean registrarRespuestas(Respuestas resp){
        boolean exito=false;
        try{
            String query =  " insert into "+TABLA+" (id, contenido, id_pregunta,id_alumno, puntaje)"
                            + " values (?, ?, ?, ?, ?)";
        
            PreparedStatement preparedStmt = ConexionBD.conectar().prepareStatement(query);
            preparedStmt.setInt(1, resp.getId());
            preparedStmt.setString(2, resp.getContenido());
            preparedStmt.setInt(3, resp.getIdPregunta());
            preparedStmt.setInt(4, resp.getIdAlumno());
            preparedStmt.setInt(5, resp.getPuntaje());
            preparedStmt.execute();
            System.out.println("Respuesta guardada.");
            exito=true;
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return exito;
    }
    
}
