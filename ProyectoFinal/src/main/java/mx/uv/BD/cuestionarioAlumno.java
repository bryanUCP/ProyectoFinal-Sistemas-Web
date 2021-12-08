package mx.uv.BD;

// DTO
public class cuestionarioAlumno{
    private int id;
    private String idAlumno;
    private int idcuesProf;
    private double calificacion;

    public cuestionarioAlumno(int id, String idAlumno, int idcuesProf, double calificacion){
        this.idAlumno = idAlumno;
        this.idcuesProf = idcuesProf;
        this.calificacion = calificacion;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    public String getIdAlumno() {
        return idAlumno;
    }
    public int getIdcuesProf() {
        return idcuesProf;
    }
    public double getCalificacion() {
        return calificacion;
    }
    
    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }
    public void setIdcuesProf(int idcuesProf) {
        this.idcuesProf = idcuesProf;
    }
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    public void setId(int id) {
        this.id = id;
    }
}

