package co.edu.uvpalmira.urss.Backend.Exceptions;

public class EntityNotFoundException extends RuntimeException {

    /**
     * Constructor que acepta un mensaje descriptivo.
     * @param message El mensaje que describe la entidad no encontrada.
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}