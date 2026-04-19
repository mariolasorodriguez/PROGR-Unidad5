package zoo;

/**
 * Excepción lanzada cuando se intenta operar con un animal
 * que está en cuarentena o no disponible.
 */
public class AnimalNoDisponibleException extends Exception {

    public AnimalNoDisponibleException() {
        super("Error: El animal no está disponible para esta operación.");
    }
}
