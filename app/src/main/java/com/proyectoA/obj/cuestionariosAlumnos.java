package com.proyectoA.obj;

public class cuestionariosAlumnos {
    private int IdAlumno;
    private String alumno;
    private String cuestionario;
    private int IdCuestionario;
    
    public cuestionariosAlumnos(int idAlumno, String alumno, String cuestionario, int idCuestionario) {
        setIdAlumno(idAlumno);
        this.setAlumno(alumno);
        this.setCuestionario(cuestionario);
        setIdCuestionario(idCuestionario);
    }

    public int getIdCuestionario() {
        return IdCuestionario;
    }

    public void setIdCuestionario(int idCuestionario) {
        this.IdCuestionario = idCuestionario;
    }

    public String getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(String cuestionario) {
        this.cuestionario = cuestionario;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.IdAlumno = idAlumno;
    }
}
