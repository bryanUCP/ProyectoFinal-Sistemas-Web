package com.proyectoA;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import com.google.gson.Gson;
import com.proyectoA.conexion.ConexionBD;
import com.proyectoA.dao.CuestionariosDAO;
import com.proyectoA.dao.PreguntasDAO;
import com.proyectoA.dao.RespuestasDAO;
import com.proyectoA.dao.alumnoCuestionarioDAO;
import com.proyectoA.dao.alumnosDao;
import com.proyectoA.dao.alumnosPorCuestionarioDao;
import com.proyectoA.dao.cuestionariosAlumnosDao;
import com.proyectoA.dao.preguntasPorCuestionarioDao;
import com.proyectoA.dao.profesorDAO;
import com.proyectoA.obj.Cuestionarios;
import com.proyectoA.obj.Preguntas;
import com.proyectoA.obj.Respuestas;
import com.proyectoA.obj.alumnoCuestionarios;
import com.proyectoA.obj.alumnos;
import com.proyectoA.obj.alumnosPorCuestionario;
import com.proyectoA.obj.cuestionariosAlumnos;
import com.proyectoA.obj.preguntasPorCuestionario;
import com.proyectoA.obj.profesor;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();

        staticFiles.location("/");
        init();
        get("/home", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");

            System.out.println("pagina home");
            System.out.println(req.host());

            return new ModelAndView(model, "/registroAlumnoForm.vm");

        }, new VelocityTemplateEngine());

        post("/registrar", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");


            alumnos a = gson.fromJson(req.body(), alumnos.class);
            String nombres = a.getNombre();
            String apellidos = a.getApellido();
            String correo = a.getCorreo();
            String clave = a.getClave();

            System.out.println(nombres + "" + apellidos + "" + correo + "" + clave);


             ConexionBD.conectar();

             if(alumnosDao.registrarAlumno(new alumnos(0, nombres, apellidos, correo, clave))){
                 System.out.println("alumno registrado con exito!");
             }else{
                System.out.println("ocurrio un problema");
             }
            
            return "que tal";
            

        });

        get("/registrarProfesorForm", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");

            System.out.println("pagina para registrar profesores");
            System.out.println(req.host());

            return new ModelAndView(model, "/registroDocenteForm.vm");

        }, new VelocityTemplateEngine());

        post("/registrarProfesor", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");


            profesor p = gson.fromJson(req.body(), profesor.class);
            String nombres = p.getNombre();
            String apellidos = p.getApellido();
            String correo = p.getCorreo();
            String clave = p.getClave();
            String experiencia = p.getExperiencia();

            System.out.println(nombres + "" + apellidos + "" + correo + "" + clave + "" + experiencia);


             //ConexionBD.conectar();

             if(profesorDAO.registrarProfesor(new profesor(0, nombres, apellidos, correo, clave, experiencia))){
                 System.out.println("profesor registrado con exito!");
             }else{
                System.out.println("ocurrio un problema");
             }
            
            return true;
            

        });

        get("/registrarCuestionarioForm", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");

            String correo = req.queryParams("correo");
            profesor prof = profesorDAO.getProfesorByCorreo(correo);
            model.put("prof", prof);

            System.out.println("cuestionario");
            System.out.println(req.host());

            return new ModelAndView(model, "/crearCuestionarioForm.vm");

        }, new VelocityTemplateEngine());

        post("/registrarCuestionario", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");


            Cuestionarios c = gson.fromJson(req.body(), Cuestionarios.class);
            String fechaCreacion = c.getFechaCreacion();
            String vigencia = c.getVigencia();
            String nombre = c.getNombre();
            

            System.out.println(fechaCreacion + "" + vigencia + "" + nombre);
            

             ConexionBD.conectar();

             if(CuestionariosDAO.registrarCuestionarios(new Cuestionarios(0, fechaCreacion, vigencia, 1, nombre))){
                 System.out.println("pcuestionario registrado con exito!");
             }else{
                System.out.println("ocurrio un problema");
             }
            
            return true;
            
        });

        get("/registrarPreguntasForm", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");

            System.out.println("preguntas");
            System.out.println(req.host());

            String idC = req.queryParams("id");
            model.put("cuestionario", idC);

            return new ModelAndView(model, "/insertarPreguntasForm.vm");


        }, new VelocityTemplateEngine());

        post("/registrarPreguntas", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");


            Preguntas pr = gson.fromJson(req.body(), Preguntas.class);
            String pregunta = pr.getContenido();
            int puntaje = pr.getPuntaje();
            int cuestionario = pr.getIdCuestionario();
            

            System.out.println(pregunta + "" + puntaje);


             if(PreguntasDAO.registrarPreguntas(new Preguntas(0, pregunta, puntaje, cuestionario))){
                 System.out.println("pregunta registrada con exito!");
             }else{
                System.out.println("ocurrio un problema");
             }
            
            return true;
            

        });

        get("/contestarPreguntaForm", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");

            System.out.println("preguntas");
            System.out.println(req.host());

            List <preguntasPorCuestionario> preguntas= preguntasPorCuestionarioDao.getPreguntasByCuestionario(4);
            model.put("preguntas", preguntas);
            return new ModelAndView(model, "/contestarPreguntasForm.vm");

        }, new VelocityTemplateEngine());

        post("/registrarPreguntas", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");


            Preguntas pr = gson.fromJson(req.body(), Preguntas.class);
            String pregunta = pr.getContenido();
            int puntaje = pr.getPuntaje();
            

            System.out.println(pregunta + "" + puntaje);


             ConexionBD.conectar();

             if(PreguntasDAO.registrarPreguntas(new Preguntas(0, pregunta, puntaje, 2))){
                 System.out.println("pregunta registrada con exito!");
             }else{
                System.out.println("ocurrio un problema");
             }
            
            return true;

        });

        get("/listaAlumnos", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");

            System.out.println("preguntas");
            System.out.println(req.host());

            List <cuestionariosAlumnos> alumnos= cuestionariosAlumnosDao.getPreguntasByCuestionario(1);
            profesor profesor = profesorDAO.getProfesorByCorreo("rojano@gmail.com");
            model.put("alumnos", alumnos);
            return new ModelAndView(model, "/listaCuestionarioAlumnos.vm");

        }, new VelocityTemplateEngine());

        get("/acceso", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");

            System.out.println("pagina acceso");
            System.out.println(req.host());

            return new ModelAndView(model, "/accesoUsuariosForm.vm");

        }, new VelocityTemplateEngine());

        post("/accesoUsuarios", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "bryan");
            

            profesor pro = gson.fromJson(req.body(), profesor.class);
            pro = profesorDAO.getProfesor(pro.getCorreo(), pro.getClave());

             if(pro == null){
                 System.out.println("error de acceso");
                 alumnos alu = gson.fromJson(req.body(), alumnos.class);
                 alumnos aux = alumnosDao.getAlumno(alu.getCorreo(), alu.getClave());

                 if(aux == null){
                   res.body("error");
                 }else{
                res.body("alumno");


                 }
             }else{

                System.out.println("Bienvenido Profesor" + pro.getNombre());
                res.body("profesor");

  
             }
                return res.body();
        
            });

        get("/homeProfesor", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            
            alumnos aux = null;
            profesor pro = null;

            System.out.println("pagina home");
            System.out.println(req.queryParams("correo"));
            String correo = req.queryParams("correo");
            
            

             pro = profesorDAO.getProfesorByCorreo(correo);
             aux = alumnosDao.getAlumnoByCorreo(correo);
             String template = "";

             
             
        
           
            List <cuestionariosAlumnos> cuestionariosAlumnos;
            List <alumnosPorCuestionario> cuestionarios;
            if(pro == null){
                
                if(aux==null){
                    template = "/accesoUsuariosForm.vm";
                }else{
                    model.put("alumno", aux);
                    cuestionariosAlumnos = cuestionariosAlumnosDao.getCuestionariosByAlumno(aux.getId());
                    model.put("cuestionariosAlumnos", cuestionariosAlumnos); 
                    template = "/homeAlumnoForm.vm";
                }

            }else{
                template = "/homeProfesorForm.vm";
                model.put("profesor", pro);
                cuestionarios= alumnosPorCuestionarioDao.getCuestionariosByProfesor(pro.getId());
                model.put("cuestionarios", cuestionarios);
            }
            
            return new ModelAndView(model, template);

        }, new VelocityTemplateEngine());

        get("/homeAlumno", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            System.out.println("pagina home");
            System.out.println(req.host());


        

            return new ModelAndView(model, "/homeAlumnoForm.vm");

        }, new VelocityTemplateEngine());


    }
}