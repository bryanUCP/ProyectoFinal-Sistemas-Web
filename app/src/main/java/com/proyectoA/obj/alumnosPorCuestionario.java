package com.proyectoA.obj;

public class alumnosPorCuestionario {
    private int ID_CUESTIONARIO;
    private String TITULO;
    private String vigencia;
    private int Numero_Alumnos;
    
    public alumnosPorCuestionario(int iD_CUESTIONARIO, String TITULO, String vigencia, int Numero_Alumnos) {
        setID_CUESTIONARIO(iD_CUESTIONARIO);
        setTITULO(TITULO);
        this.setVigencia(vigencia);
        setNumero_Alumnos(Numero_Alumnos);
    }

    public int getNumero_Alumnos() {
        return Numero_Alumnos;
    }

    public void setNumero_Alumnos(int Numero_Alumnos) {
        this.Numero_Alumnos = Numero_Alumnos;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String tITULO) {
        this.TITULO = tITULO;
    }

    public int getID_CUESTIONARIO() {
        return ID_CUESTIONARIO;
    }

    public void setID_CUESTIONARIO(int iD_CUESTIONARIO) {
        this.ID_CUESTIONARIO = iD_CUESTIONARIO;
    }
}
