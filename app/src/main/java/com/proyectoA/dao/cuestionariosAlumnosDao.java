package com.proyectoA.dao;

import java.sql.*;
import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.obj.cuestionariosAlumnos;
import java.util.ArrayList;
import java.util.List;

public class cuestionariosAlumnosDao {

    private static final String tabla = "cuestionarioalumnos";

    public static List <cuestionariosAlumnos> getPreguntasByCuestionario(int IdCuestionario){

        List <cuestionariosAlumnos> alumnos=new ArrayList<>();

        Statement statement;

        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ tabla + " where idCuestionario = " + IdCuestionario);

            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                return null;
            }else{
                cuestionariosAlumnos aux = new cuestionariosAlumnos(rs.getInt("IdAlumno"), rs.getString("alumno"), rs.getString("cuestionario"), rs.getInt("IdCuestionario"));
                    alumnos.add(aux);
                        System.out.println(aux.getAlumno());
            while(rs.next()){
                aux = new cuestionariosAlumnos(rs.getInt("IdAlumno"), rs.getString("alumno"), rs.getString("cuestionario"), rs.getInt("IdCuestionario"));
                    alumnos.add(aux);
                        System.out.println(aux.getAlumno());
                    }
            }
        }catch(SQLException e){
            System.out.println("estado SQL:" + e.getSQLState());
            System.out.println("codigo de error:" + e.getErrorCode());
            System.out.println(e.getMessage());
        }

        return alumnos;
        
        }

        public static List <cuestionariosAlumnos> getCuestionariosByAlumno(int IdAlumno){

            List <cuestionariosAlumnos> alumnos=new ArrayList<>();
    
            Statement statement;
    
            try{
                statement = ConexionBD.conectar().createStatement();
                ResultSet rs=statement.executeQuery("select * from "+ tabla + " where idAlumno = " + IdAlumno);
    
                if(!rs.next()){
                    System.out.println("no hubo una coincidencia con la base de datos");
                    return null;
                }else{
                    cuestionariosAlumnos aux = new cuestionariosAlumnos(rs.getInt("IdAlumno"), rs.getString("alumno"), rs.getString("cuestionario"), rs.getInt("IdCuestionario"));
                        alumnos.add(aux);
                            System.out.println(aux.getCuestionario());
                while(rs.next()){
                    aux = new cuestionariosAlumnos(rs.getInt("IdAlumno"), rs.getString("alumno"), rs.getString("cuestionario"), rs.getInt("IdCuestionario"));
                        alumnos.add(aux);
                            System.out.println(aux.getCuestionario());
                        }
                }
            }catch(SQLException e){
                System.out.println("estado SQL:" + e.getSQLState());
                System.out.println("codigo de error:" + e.getErrorCode());
                System.out.println(e.getMessage());
            }
    
            return alumnos;
            
            }

}
