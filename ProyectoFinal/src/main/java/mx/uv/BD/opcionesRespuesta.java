package mx.uv.BD;

// DTO
public class opcionesRespuesta {
    private int id;
    private int idPreg;
    private String contenido;
    private int idTipo;

    public opcionesRespuesta(int id, int idPreg, String contenido, int idTipo) {
        this.id = id;
        this.idPreg= idPreg;
        this.contenido = contenido;
        this.idTipo = idTipo;
    }
    
    public int getId() {
        return id;
    }
    public int getIdPreg() {
        return idPreg;
    }
    public String getContenido() {
        return contenido;
    }
    public int getIdTipo() {
        return idTipo;
    }

    public void setIdPreg(int idPreg) {
        this.idPreg = idPreg;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
}

