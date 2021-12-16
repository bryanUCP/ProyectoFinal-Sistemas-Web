package com.proyectoA.dao;

import java.sql.*;
import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.obj.alumnosPorCuestionario;
import java.util.ArrayList;
import java.util.List;

public class alumnosPorCuestionarioDao {

    private static final String tabla = "alumnosporcuestionario";

    public static List <alumnosPorCuestionario> getAlumnosByCuestionario(int idCuestionario){

        List <alumnosPorCuestionario> cuestionarios=new ArrayList<>();

        Statement statement;

        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ tabla + " where ID_CUESTIONARIO = " + idCuestionario);

            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                return null;
            }else{
                alumnosPorCuestionario aux = new alumnosPorCuestionario(rs.getInt("ID_CUESTIONARIO"), rs.getString("TITULO"), rs.getString("vigencia"), rs.getInt("Numero_Alumnos"));
                    cuestionarios.add(aux);
                        System.out.println(aux.getTITULO());
            while(rs.next()){
                aux = new alumnosPorCuestionario(rs.getInt("ID_CUESTIONARIO"), rs.getString("TITULO"), rs.getString("vigencia"), rs.getInt("Numero_Alumnos"));
                    cuestionarios.add(aux);
                        System.out.println(aux.getTITULO());
                    }
            }
        }catch(SQLException e){
            System.out.println("estado SQL:" + e.getSQLState());
            System.out.println("codigo de error:" + e.getErrorCode());
            System.out.println(e.getMessage());
        }

        return cuestionarios;
        
        }

        public static List <alumnosPorCuestionario> getCuestionariosByProfesor(int idProfesor){

            List <alumnosPorCuestionario> cuestionarios=new ArrayList<>();
    
            Statement statement;
    
            try{
                statement = ConexionBD.conectar().createStatement();
                ResultSet rs=statement.executeQuery("select * from "+ tabla + " where profesor = " + idProfesor);
    
                if(!rs.next()){
                    System.out.println("no hubo una coincidencia con la base de datos");
                    return null;
                }else{
                    alumnosPorCuestionario aux = new alumnosPorCuestionario(rs.getInt("ID_CUESTIONARIO"), rs.getString("TITULO"), rs.getString("vigencia"), rs.getInt("Numero_Alumnos"));
                        cuestionarios.add(aux);
                            System.out.println(aux.getTITULO());
                while(rs.next()){
                    aux = new alumnosPorCuestionario(rs.getInt("ID_CUESTIONARIO"), rs.getString("TITULO"), rs.getString("vigencia"), rs.getInt("Numero_Alumnos"));
                        cuestionarios.add(aux);
                            System.out.println(aux.getTITULO());
                        }
                }
            }catch(SQLException e){
                System.out.println("estado SQL:" + e.getSQLState());
                System.out.println("codigo de error:" + e.getErrorCode());
                System.out.println(e.getMessage());
            }
    
            return cuestionarios;
            
            }
}
