package co.edu.uvpalmira.urss.Backend.Exceptions;

public class CategoryNotFoundException extends RuntimeException {

    /**
     * Constructor que acepta el ID de la categoría no encontrada.
     * @param id El identificador de la categoría que no se pudo encontrar.
     */
    public CategoryNotFoundException(Long id) {
        // Llama al constructor de RuntimeException con un mensaje descriptivo
        super("Categoría con ID " + id + " no encontrada. Por favor, verifica el ID.");
    }

    // Opcional: Si quieres un constructor que reciba un mensaje personalizado
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
