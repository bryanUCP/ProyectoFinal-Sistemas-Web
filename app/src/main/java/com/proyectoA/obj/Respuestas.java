package com.proyectoA.obj;

public class Respuestas {
    private int id;
    private String contenido;
    private int id_pregunta;
    private int id_alumno;
    private int puntaje;

    public Respuestas(int id, String contenido, int id_pregunta, int id_alumno, int puntaje) {
        this.id = id;
        this.contenido = contenido;
        this.id_pregunta = id_pregunta;
        this.id_alumno = id_alumno;
        this.puntaje = puntaje;
    }
    public int getId(){
        return id;
    }
    public String getContenido(){
        return contenido;
    }
    public int getIdPregunta(){
        return id_pregunta;
    }
    public int getIdAlumno(){
        return id_alumno;
    }
    public int getPuntaje(){
        return puntaje;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setContenido(String contenido){
        this.contenido = contenido;
    }
    public void setIdPregunta(int id_pregunta){
        this.id_pregunta = id_pregunta;
    }
    public void setIdAlumno(int id_alumno){
        this.id_alumno = id_alumno;
    }
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
}
