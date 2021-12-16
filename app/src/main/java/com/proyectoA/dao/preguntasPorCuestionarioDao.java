package com.proyectoA.dao;

import java.sql.*;
import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.obj.preguntasPorCuestionario;
import java.util.ArrayList;
import java.util.List;

public class preguntasPorCuestionarioDao {

    private static final String tabla = "preguntasporcuestionario";

    public static List <preguntasPorCuestionario> getPreguntasByCuestionario(int idCuestionario){

        List <preguntasPorCuestionario> preguntas=new ArrayList<>();

        Statement statement;

        try{
            statement = ConexionBD.conectar().createStatement();
            ResultSet rs=statement.executeQuery("select * from "+ tabla + " where id = " + idCuestionario);

            if(!rs.next()){
                System.out.println("no hubo una coincidencia con la base de datos");
                return null;
            }else{
                preguntasPorCuestionario aux = new preguntasPorCuestionario(rs.getInt("id"), rs.getString("Nombre_Cuestionario"), rs.getString("vigencia"), rs.getInt("numero_de_pregunta"), rs.getString("pregunta"), rs.getInt("puntaje"));
                    preguntas.add(aux);
                        System.out.println(aux.getPregunta());
            while(rs.next()){
                aux = new preguntasPorCuestionario(rs.getInt("id"), rs.getString("Nombre_Cuestionario"), rs.getString("vigencia"), rs.getInt("numero_de_pregunta"), rs.getString("pregunta"), rs.getInt("puntaje"));
                    preguntas.add(aux);
                        System.out.println(aux.getPregunta());
                    }
            }
        }catch(SQLException e){
            System.out.println("estado SQL:" + e.getSQLState());
            System.out.println("codigo de error:" + e.getErrorCode());
            System.out.println(e.getMessage());
        }

        return preguntas;
        
        }
}
