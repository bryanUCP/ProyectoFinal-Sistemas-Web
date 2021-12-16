package com.proyectoA.obj;

public class alumnoCuestionarios {
    private int id;
    private int id_alumno;
    private int id_cuestionario;
    private int puntaje;
    
    public alumnoCuestionarios(int id, int id_alumno, int id_cuestionario, int puntaje) {
        this.id = id;
        this.setId_alumno(id_alumno);
        this.setId_cuestionario(id_cuestionario);
        this.setPuntaje(puntaje);
    }
    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public int getId_cuestionario() {
        return id_cuestionario;
    }
    public void setId_cuestionario(int id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }
    public int getId_alumno() {
        return id_alumno;
    }
    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    
}

