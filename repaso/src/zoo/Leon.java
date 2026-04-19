package zoo;

/**
 * Representa un león. Solo implementa Vacunable
 * (no se puede domesticar).
 */
public class Leon extends Animal implements Vacunable {

    private String habitat;
    private String ultimaVacuna;
    private boolean necesitaVacuna;

    public Leon(String nombre, int edad, double peso, String habitat) {
        super(nombre, "Panthera leo", edad, peso);
        this.habitat = habitat;
        this.ultimaVacuna = "";
        this.necesitaVacuna = true;
    }

    public String getHabitat() { return habitat; }

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
    public String getTipoAnimal() { return "León"; }

    @Override
    public String toString() {
        return super.toString() + " | Hábitat: " + habitat
                + " | Última vacuna: " + (ultimaVacuna.isEmpty() ? "Ninguna" : ultimaVacuna);
    }
}
