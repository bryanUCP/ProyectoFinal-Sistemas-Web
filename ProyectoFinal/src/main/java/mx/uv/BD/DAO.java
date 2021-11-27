package mx.uv.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;

public class DAO {
    private conexion conexion = new conexion();

    public String insertarUsuario(Usuario u) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO usuarios (id, nombre, apellido, email, password, rol) VALUES (?, ?, ?, ?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setString(1, u.getId());
            prestm.setString(2, u.getNom());
            prestm.setString(3, u.getApe());
            prestm.setString(4, u.getEmail());
            prestm.setString(5, u.getPassword());
            prestm.setString(6, u.getRol());
            if (prestm.executeUpdate() >0) 
                msj = "Usuario agregado";
            else
                msj = "No se agregó el usuario";
            
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
        return msj;
    }
}
//---------------------------------------------------------------------------------------------------------------


