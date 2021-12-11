package mx.uv.BD;

// DTO
public class preguntasRespuestas {
    private int id;
    private String nombreCuestionario;
    private String pregunta;
    private String res1;
    private String res2;
    private String res3;
    private String res4;
    private String respuestaCorrecta;

    public preguntasRespuestas(int id, String nombreCuestionario, String pregunta, String res1, String res2,
    String res3, String res4, String respuestaCorrecta) {
        this.id = id;
        this.nombreCuestionario = nombreCuestionario;
        this.pregunta = pregunta;
        this.res1 = res1;
        this.res2 = res2;
        this.res3 = res3;
        this.res4 = res4;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNombreCuestionario(String nombreCuestionario) {
        this.nombreCuestionario = nombreCuestionario;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public void setRes1(String res1){
        this.res1=res1;
    }
    public void setRes2(String res2){
        this.res2=res2;
    }
    public void setRes3(String res3){
        this.res3=res3;
    }
    public void setRes4(String res4){
        this.res4=res4;
    }
    public void setRespuestaCorrecta(String respuestaCorrecta){
        this.respuestaCorrecta=respuestaCorrecta;
    }
    


    public int getId() {
        return id;
    }
    public String getNombreCuestionario() {
        return nombreCuestionario;
    }
    public String getPregunta() {
        return pregunta;
    }
    public String getRes1() {
        return res1;
    }
    public String getRes2() {
        return res2;
    }
    public String getRes3() {
        return res3;
    }
    public String getRes4() {
        return res4;
    }
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    
}

