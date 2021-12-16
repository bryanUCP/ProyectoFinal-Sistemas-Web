package com.proyectoA.dao;

import java.sql.*;

import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.obj.Preguntas;

public class PreguntasDAO {
    public static final String TABLA="Preguntas";

    public static boolean registrarPreguntas(Preguntas preg){
        boolean exito=false;
        try{
            String query =  " insert into "+TABLA+" (id, contenido, puntaje, id_cuestionario)"
                            + " values (?, ?, ?, ?)";
		
            PreparedStatement preparedStmt = ConexionBD.conectar().prepareStatement(query);
            preparedStmt.setInt(1, preg.getId());
            preparedStmt.setString(2, preg.getContenido());
            preparedStmt.setInt(3, preg.getPuntaje());
            preparedStmt.setInt(4, preg.getIdCuestionario());
            preparedStmt.execute();
            System.out.println("Pregunta creada.");
            exito=true;
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }

        return exito;
    }
    
}
