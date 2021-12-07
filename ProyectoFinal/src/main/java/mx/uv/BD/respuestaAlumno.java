package mx.uv.BD;

// DTO
public class respuestaAlumno{
    private int id;
    private int idAlumnoCues;
    private int idOpcion;
    private String contenido;

    public respuestaAlumno(int id, int idAlumnoCues, int idOpcion, String contenido){
        this.idAlumnoCues = idAlumnoCues;
        this.idOpcion = idOpcion;
        this.contenido = contenido;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    public int getIdAlumnoCues() {
        return idAlumnoCues;
    }
    public int getIdOpcion() {
        return idOpcion;
    }
    public String getContenido() {
        return contenido;
    }
    
    public void setIdAlumnoCues(int idAlumnoCues) {
        this.idAlumnoCues = idAlumnoCues;
    }
    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public void setId(int id) {
        this.id = id;
    }
}


