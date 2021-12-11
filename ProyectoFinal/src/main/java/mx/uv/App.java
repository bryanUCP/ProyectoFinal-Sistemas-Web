package mx.uv;

import static spark.Spark.*;


//import spark.template.velocity.VelocityTemplateEngine;

//import spark.ModelAndView;
//import java.util.HashMap;
//import java.util.Map;

//import java.util.UUID;

import com.google.gson.*;

import mx.uv.BD.DAO;
import mx.uv.BD.DAOcuestionarioProfe;
import mx.uv.BD.DAOpreguntasRespuestas;
import mx.uv.BD.Usuario;
import mx.uv.BD.cuestionarioProfesor;
import mx.uv.BD.preguntasRespuestas;




/**
 * Hello world!
 *
 */

public class App 
{
    private static Gson gson = new Gson();

    public static void main( String[] args )
    {

        /*port(1234);
        //staticFiles.location("/");

        get("/", (req, res) -> {
            res.redirect("/login.html");
            return null;
        });*/

        //Map<String, Object> variables = new HashMap<>();
        
        System.out.println( "Hello World!" );

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        /*------------------ Agregar usuario ---------------------*/
        post("/usuario", (req, res) -> {
            // Insertamos un nuevo usuario
            String json = req.body();
            Usuario u = gson.fromJson(json, Usuario.class);

            DAO dao = new DAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarUsuario(u));
            return respuesta;
        });

        /* -------------------- Agregar cuestionario -------------------------*/
        post("/cuestionarioProfe", (req, res) -> {
            String json = req.body();
            cuestionarioProfesor cp = gson.fromJson(json, cuestionarioProfesor.class);

            DAOcuestionarioProfe daoCP = new DAOcuestionarioProfe();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", daoCP.insertarCuestionarioP(cp));
            return respuesta;
            
        });

        /* -------------------- Agregar pregunta -------------------------*/
        post("/AgregarPregunta", (req, res) -> {
            String json = req.body();
            preguntasRespuestas pr = gson.fromJson(json, preguntasRespuestas.class);

            DAOpreguntasRespuestas daoPR = new DAOpreguntasRespuestas();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", daoPR.insertarPregunta(pr));
            return respuesta;
            
        });

        /*----------------- BUSCAR INFORMACION DEL PROFESOR ------------------*/ 
        get("/InfoProfesor", (req, res) -> {
            before((req2, res2) -> res.type("application/json"));
            String email = req.queryParams("email2"); //Recuperamos los datos del .js
            DAO dao = new DAO();
            return gson.toJson(dao.informacionProfesor(email));
        });

        /* -------------------------- Validacion de login ---------------------------*/
        get("/verificarUsuario", (req, res)->{
            Boolean resultado;
            DAO dao = new DAO();
            Usuario u;
            String email = req.queryParams("email"); //Recuperamos los datos del .js
            String password = req.queryParams("password");
            u = dao.verificarUsuario(email); //los datos los mandamos al DAO
            if(u!=null){
                if(password.equals(String.valueOf(u.getPassword()))){
                    if(u.getRol().equals("Profesor")){
                        resultado = true;
                        return resultado;
                    }else{
                        resultado = false;
                        return resultado;
                    }
                }else{
                    return null;
                }
            }else{
                return null;
            }
        });

    }
}

