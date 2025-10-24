package co.edu.uvpalmira.urss.Backend.modelo;

public class Persona {
    
    private String nombre;
    private int edad;
    
    private int identificacion;
    
    private String genero;

    public Persona(String nombre, int edad, int identificacion, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.identificacion= identificacion;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

}
