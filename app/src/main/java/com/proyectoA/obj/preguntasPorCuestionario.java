package com.proyectoA.obj;

public class preguntasPorCuestionario {
    private int id;
    private String Nombre_Cuestionario;
    private String vigencia;
    private int numero_de_pregunta;
    private String pregunta;
    private int puntaje;
    
    public preguntasPorCuestionario(int id, String Nombre_Cuestionario, String vigencia, int numero_de_pregunta,
            String pregunta, int puntaje) {
        this.setId(id);
        this.setNombre_cuestionario(Nombre_Cuestionario);
        this.setVigencia(vigencia);
        this.setNumero_de_pregunta(numero_de_pregunta);
        this.setPregunta(pregunta);
        this.setPuntaje(puntaje);
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getNumero_de_pregunta() {
        return numero_de_pregunta;
    }

    public void setNumero_de_pregunta(int numero_de_pregunta) {
        this.numero_de_pregunta = numero_de_pregunta;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getNombre_cuestionario() {
        return Nombre_Cuestionario;
    }

    public void setNombre_cuestionario(String Nombre_Cuestionario) {
        this.Nombre_Cuestionario = Nombre_Cuestionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
