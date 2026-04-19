package zoo;

/**
 * Representa un perro. Implementa Domesticable y Vacunable.
 */
public class Perro extends Animal implements Domesticable, Vacunable {

    private String raza;
    private boolean domesticado;
    private String nombreCuidador;
    private String ultimaVacuna;
    private boolean necesitaVacuna;

    public Perro(String nombre, int edad, double peso, String raza) {
        super(nombre, "Canis lupus familiaris", edad, peso);
        this.raza = raza;
        this.domesticado = false;
        this.nombreCuidador = "";
        this.ultimaVacuna = "";
        this.necesitaVacuna = true;
    }

    public String getRaza() { return raza; }

    @Override
    public void domesticar(String nombreCuidador) throws AnimalNoDisponibleException {
        if (this.enCuarentena) {
            throw new AnimalNoDisponibleException();
        }
        this.domesticado = true;
        this.nombreCuidador = nombreCuidador;
    }

    @Override
    public void liberarAnimal() {
        this.domesticado = false;
        this.nombreCuidador = "";
    }

    @Override
    public boolean isDomesticado() { return domesticado; }

    @Override
    public void vacunar(String nombreVacuna) throws AnimalNoDisponibleException {
        if (this.enCuarentena) {
            throw new AnimalNoDisponibleException();
        }
        this.ultimaVacuna = nombreVacuna;
        this.necesitaVacuna = false;
    }

    @Override
    public String getUltimaVacuna() { return ultimaVacuna; }

    @Override
    public boolean necesitaVacuna() { return necesitaVacuna; }

    @Override
    public String getTipoAnimal() { return "Perro"; }

    @Override
    public String toString() {
        String info = super.toString() + " | Raza: " + raza
                + " | " + (domesticado ? "Cuidador: " + nombreCuidador : "Sin domesticar");
        if (!ultimaVacuna.isEmpty()) info += " | Vacuna: " + ultimaVacuna;
        return info;
    }
}