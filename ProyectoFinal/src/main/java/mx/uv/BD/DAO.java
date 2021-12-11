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
        String resultado="";
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



    /*public String verificarUsuario(String email, String password){
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        String resultado="";
        conn = conexion.getConnection();
        try{
            String sql = "SELECT * FROM usuarios WHERE email = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, email);
            rs = stm.executeQuery();
            //rs = stm.executeQuery(sql);

            while (rs.next()){
                Usuario u = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),  rs.getString("email"), rs.getString("pasword"), rs.getString("rol"));
                if(u.getPassword().equals(password)){
                    if(u.getRol().equals("Profesor")){
                        //cp.setIdP(u.getId());
                        System.out.println(u.getNom());
                        resultado = "Profesor";
                        return resultado;
                    }

                    if(u.getRol().equals("Estudiante")){
                        System.out.println(u.getNom());
                        resultado = "Estudiante";
                        return resultado;
                    }
                }else{
                    System.out.println("Password incorrecto");
                    return null;
                }

            }
            return null;   
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }*/
}




