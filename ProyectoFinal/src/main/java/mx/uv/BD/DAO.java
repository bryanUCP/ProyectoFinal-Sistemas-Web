package mx.uv.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private conexion conexion = new conexion();
    cuestionarioProfesor cp;

    public String insertarUsuario(Usuario u) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            //String sql = "INSERT INTO usuarios (id, nombre, apellido, email, pasword, rol) VALUES (?, ?, ?, ?, ?, ?)";
            String sql = "INSERT INTO usuarios (nombre, apellido, email, pasword, rol) VALUES (?, ?, ?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setString(1, u.getNom());
            prestm.setString(2, u.getApe());
            prestm.setString(3, u.getEmail());
            prestm.setString(4, u.getPassword());
            prestm.setString(5, u.getRol());
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
    //---------------------------------------------------------------------------------------------------------------

    public Usuario verificarUsuario(String email){
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        conn = conexion.getConnection();
        try{
            String sql = "SELECT * FROM usuarios WHERE email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            rs = stm.executeQuery();
            //rs = stm.executeQuery(sql);

            while (rs.next()){
                Usuario u = new Usuario(rs.getString("nombre"), rs.getString("apellido"),  rs.getString("email"), rs.getString("pasword"), rs.getString("rol"));
                System.out.println(u.getNom()+":"+u.getRol());
                return u;

            }
            return null;   
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Usuario> informacionProfesor(String email){
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Usuario> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT * FROM usuarios where email=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            rs = stm.executeQuery();
            while (rs.next()){
                Usuario u = new Usuario(rs.getString("nombre"), rs.getString("apellido"),  rs.getString("email"), rs.getString("pasword"), rs.getString("rol"));
                System.out.print(u.getEmail());
                resultado.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    stm = null;
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    rs = null;
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }


    /*public List<Usuario> informacionProfesor(String email) {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Usuario> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT * FROM usuarios where email =" + email;
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                Usuario u = new Usuario(rs.getString("nombre"), rs.getString("apellido"),  rs.getString("email"), rs.getString("pasword"), rs.getString("rol"));
                System.out.print(u.getEmail());
                resultado.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    stm = null;
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    rs = null;
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }*/


}




