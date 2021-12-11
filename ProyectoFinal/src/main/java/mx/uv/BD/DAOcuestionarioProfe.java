package mx.uv.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOcuestionarioProfe {
    private conexion conexion = new conexion();

    public String insertarCuestionarioP(cuestionarioProfesor cp) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO cuestionariosprofesor (id, correoProfesor, nombre, vigencia, EE) VALUES (?, ?, ?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setInt(1, cp.getId());
            prestm.setString(2, cp.getCorreoProfesor());
            prestm.setString(3, cp.getNombre());
            prestm.setString(4, cp.getVigencia());
            prestm.setString(5, cp.getEE());
            if (prestm.executeUpdate() >0) 
                msj = "cuestionario agregado";
            else
                msj = "No se agregó el cuestionario";
            
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
        System.out.println(cp.getCorreoProfesor());
        System.out.println(cp.getNombre());
        return msj;
    }


}