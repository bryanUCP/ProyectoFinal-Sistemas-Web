package mx.uv.BD;

// DTO
public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String rol;

    public Usuario(String nombre, String apellido, String email, String password, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    

    public String getNom() {
        return nombre;
    }
    public String getApe() {
        return apellido;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRol() {
        return rol;
    }
    
    public void setNom(String nombre) {
        this.nombre = nombre;
    }
    public void setApe(String apellido) {
        this.apellido = apellido;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
