package zoo;

/**
 * Interfaz para animales que pueden ser domesticados.
 */
public interface Domesticable {

    public void domesticar(String nombreCuidador) throws AnimalNoDisponibleException;
    public void liberarAnimal();
    public boolean isDomesticado();
}