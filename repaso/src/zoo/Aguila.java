package zoo;

/**
 * Representa un águila. Implementa Vacunable.
 */
public class Aguila extends Animal implements Vacunable {

    private double envergadura;
    private String ultimaVacuna;
    private boolean necesitaVacuna;

    public Aguila(String nombre, int edad, double peso, double envergadura) {
        super(nombre, "Aquila chrysaetos", edad, peso);
        this.envergadura = envergadura;
        this.ultimaVacuna = "";
        this.necesitaVacuna = true;
    }

    public double getEnvergadura() { return envergadura; }

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
    public String getTipoAnimal() { return "Águila"; }

    @Override
    public String toString() {
        return super.toString() + " | Envergadura: " + envergadura + "m"
                + " | Vacuna: " + (ultimaVacuna.isEmpty() ? "Pendiente" : ultimaVacuna);
    }
}