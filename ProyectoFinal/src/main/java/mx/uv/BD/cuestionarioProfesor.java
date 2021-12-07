package mx.uv.BD;

// DTO
public class cuestionarioProfesor {
    private int id;
    private String idProfesor;
    private String fecha;
    private String vigencia;
    private String EE;

    public cuestionarioProfesor(int id, String idProfesor, String fecha, String vigencia, String EE) {
        this.idProfesor = idProfesor;
        this.fecha = fecha;
        this.vigencia = vigencia;
        this.EE = EE;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    public String getIdP() {
        return idProfesor;
    }
    public String getFecha() {
        return fecha;
    }
    public String getVigencia() {
        return vigencia;
    }
    public String getEE() {
        return EE;
    }
    
    public void setIdP(String idProfesor) {
        this.idProfesor = idProfesor;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setvigencia(String vigencia) {
        this.vigencia = vigencia;
    }
    public void setEE(String EE) {
        this.EE = EE;
    }
    public void setId(int id) {
        this.id = id;
    }
}

