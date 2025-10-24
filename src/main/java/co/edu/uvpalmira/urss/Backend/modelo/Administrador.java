package co.edu.uvpalmira.urss.Backend.modelo;

import jakarta.persistence.Entity;
import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
@Entity
public class Administrador extends Persona{
    
    private String usuario;   
    private String contrasena;
    
    public Administrador(String nombre, int edad, int identificacion, String genero, String usuario, String contrasena) {
        super(nombre, edad, identificacion, genero);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getContraseña() {
        return contrasena;
    }
}