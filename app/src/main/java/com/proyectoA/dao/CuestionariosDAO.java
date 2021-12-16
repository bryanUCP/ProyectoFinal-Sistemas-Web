package com.proyectoA.dao;
import java.sql.*;

import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.obj.Cuestionarios;

public class CuestionariosDAO {
    public static final String TABLA="Cuestionarios";

    public static boolean registrarCuestionarios(Cuestionarios cues){
        boolean exito=false;
        try{
            String query =  " insert into "+TABLA+" (id, fecha_creacion, vigencia, id_profesor, nombre)"
                            + " values (?, ?, ?, ?, ?)";
		
            PreparedStatement preparedStmt = ConexionBD.conectar().prepareStatement(query);
            preparedStmt.setInt(1, cues.getId());
            preparedStmt.setString(2, cues.getFechaCreacion());
            preparedStmt.setString(3, cues.getVigencia());
            preparedStmt.setInt(4, cues.getIdProfesor());
            preparedStmt.setString(5, cues.getNombre());
            preparedStmt.execute();
            System.out.println("Cuestionario creado.");
            exito=true;
        }catch(SQLException e){
            System.out.println("Estado SQL: "+e.getSQLState());
            System.out.println("Código de error: "+e.getErrorCode());
            System.out.println(e.getMessage());
        }
        return exito;
    }
}
