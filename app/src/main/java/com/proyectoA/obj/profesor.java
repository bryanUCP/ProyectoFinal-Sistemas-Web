package com.proyectoA.obj;

public class profesor {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private String experiencia;
    
    public profesor(int id, String nombre,String apellido, String correo, String clave, String experiencia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave= clave;
        this.experiencia = experiencia;
    }
    public int getId() {
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getCorreo(){
        return correo;
    }
    public String getClave(){
        return clave;
    }
    public String getExperiencia(){
        return experiencia;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellidos(String apellido){
        this.apellido = apellido;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public void setClave(String clave){
        this.clave = clave;
    }
    public void setExperiencia(String experiencia){
        this.experiencia = experiencia;
    }
    
    
}