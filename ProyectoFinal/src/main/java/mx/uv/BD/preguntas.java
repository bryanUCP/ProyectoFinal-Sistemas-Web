package mx.uv.BD;

// DTO
public class preguntas {
    private int id;
    private int idcuesProf;
    private String contenido;

    public preguntas(int id, int idcuesProf, String contenido) {
        this.id = id;
        this.idcuesProf = idcuesProf;
        this.contenido = contenido;
    }
    
    public int getId() {
        return id;
    }
    public int getIdcuestProf() {
        return idcuesProf;
    }
    public String getContenido() {
        return contenido;
    }

    public void setIdcuesProf(int idcuesProf) {
        this.idcuesProf = idcuesProf;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public void setId(int id) {
        this.id = id;
    }
}

