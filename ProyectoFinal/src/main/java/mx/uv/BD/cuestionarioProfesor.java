package mx.uv.BD;

// DTO
public class cuestionarioProfesor {
    private int id;
    private String correoProfesor;
    private String nombre;
    private String vigencia;
    private String EE;

    public cuestionarioProfesor(int id, String correoProfesor, String nombre, String vigencia, String EE) {
        this.correoProfesor = correoProfesor;
        this.nombre = nombre;
        this.vigencia = vigencia;
        this.EE = EE;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    public String getCorreoProfesor() {
        return correoProfesor;
    }
    public String getNombre() {
        return nombre;
    }
    public String getVigencia() {
        return vigencia;
    }
    public String getEE() {
        return EE;
    }
    
    public void setCorreoProfesor(String correoProfesor) {
        this.correoProfesor = correoProfesor;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

