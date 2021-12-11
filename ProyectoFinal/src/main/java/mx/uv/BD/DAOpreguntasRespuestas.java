package mx.uv.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;


public class DAOpreguntasRespuestas {
    private conexion conexion = new conexion();

    public String insertarPregunta(preguntasRespuestas pr) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO preguntasrespuestas (id, nombreCuestionario, pregunta, res1, res2, res3, res4, respuestaCorrecta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setInt(1, pr.getId());
            prestm.setString(2, pr.getNombreCuestionario());
            prestm.setString(3, pr.getPregunta());
            prestm.setString(4, pr.getRes1());
            prestm.setString(5, pr.getRes2());
            prestm.setString(6, pr.getRes3());
            prestm.setString(7, pr.getRes4());
            prestm.setString(8, pr.getRespuestaCorrecta());
            if (prestm.executeUpdate() >0) 
                msj = "pregunta agregada";
            else
                msj = "No se agregó tu pregunta";
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (prestm != null){
                try {
                    prestm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(pr.getPregunta());
        return msj;
    }


}