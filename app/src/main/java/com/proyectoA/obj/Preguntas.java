package com.proyectoA.obj;

public class Preguntas {
    private int id;
    private String contenido;
    private int puntaje;
    private int id_cuestionario;

    public Preguntas(int id, String contenido, int puntaje, int id_cuestionario) {
        this.id = id;
        this.contenido = contenido;
        this.puntaje = puntaje;
        this.id_cuestionario = id_cuestionario;
    }
    
    public int getId(){
        return id;
    }
    public String getContenido(){
        return contenido;
    }
    public int getPuntaje(){
        return puntaje;
    }
    public int getIdCuestionario(){
        return id_cuestionario;
    }
    
    public void setid(int id){
        this.id = id;
    }
    public void setContenido( String contenido){
        this.contenido = contenido;
    }
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    public void setIdCuestionario(int id_cuestionario){
        this.id_cuestionario = id_cuestionario;
    }

    
}
