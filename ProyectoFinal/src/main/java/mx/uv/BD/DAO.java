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
    //---------------------------------------------------------------------------------------------------------------

    public String verificarUsuario(String email, String password){
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
                Usuario u = new Usuario(rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"),  rs.getString("email"), rs.getString("password"), rs.getString("rol"));
                if(u.getPassword().equals(password)){
                    if(u.getRol().equals("Profesor")){
                        System.out.println("If profesor");
                        System.out.println(u.getNom());
                        resultado = "Profesor";
                        return resultado;
                    }else{
                        System.out.println("If Estudiante");
                        System.out.println(u.getNom());
                        resultado ="Estudiante";
                        return resultado;   
                    }
                }

            }

            /*while (rs.next()){
                Usuario u = new Usuario(rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"),  rs.getString("email"), rs.getString("password"), rs.getString("rol"));
                if(u.getEmail().equals(email) && u.getPassword().equals(password)  && u.getRol().equals("Profesor")){
                        resultado= "Profesor";
                        System.out.println(u.getEmail());
                        
                    
                    }
                if(u.getEmail().equals(email) && u.getPassword().equals(password)  && u.getRol().equals("Estudiante")){
                        resultado= "Estudiante";
                        System.out.println(u.getEmail());
                    }

            }*/
                
            return resultado;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
}




