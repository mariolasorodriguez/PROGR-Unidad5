package zoo;

/**
 * Interfaz para animales que requieren control de vacunación.
 */
public interface Vacunable {

    public void vacunar(String nombreVacuna) throws AnimalNoDisponibleException;
    public String getUltimaVacuna();
    public boolean necesitaVacuna();
}