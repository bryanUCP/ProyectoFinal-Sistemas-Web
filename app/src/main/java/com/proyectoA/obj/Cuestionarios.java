package com.proyectoA.obj;

public class Cuestionarios {
    private int id;
    private String fecha_creacion;
    private String vigencia;
    private int id_profesor;
    private String nombre;
    public Cuestionarios(int id, String fecha_creacion, String vigencia, int id_profesor, String nombre) {
        this.id = id;
        this.fecha_creacion = fecha_creacion;
        this.vigencia = vigencia;
        this.id_profesor = id_profesor;
        this. nombre = nombre;
    }
    public int getId(){
        return id;
    }
    public String getFechaCreacion(){
        return fecha_creacion;
    }
    public String getVigencia(){
        return vigencia;
    }
    public int getIdProfesor(){
        return id_profesor;
    }
    public String getNombre(){
        return nombre;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setFechaCreacion(String fecha_creacion){
        this.fecha_creacion = fecha_creacion;
    }
    public void setVigencia(String vigencia){
        this.vigencia = vigencia;
    }
    public void setIdProfesor(int id_profesor){
        this.id_profesor = id_profesor;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
}
