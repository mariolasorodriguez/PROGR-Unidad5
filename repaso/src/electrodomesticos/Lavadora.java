package electrodomesticos;

/**
 * Representa una lavadora. Implementa Programable y Reparable.
 */
public class Lavadora extends Electrodomestico implements Programable, Reparable {

    private int capacidadKg;
    private boolean programado;
    private int minutosPrograma;
    private boolean averiada;
    private String descripcionAveria;

    public Lavadora(String marca, String modelo, double consumo, int capacidadKg) {
        super(marca, modelo, consumo);
        this.capacidadKg = capacidadKg;
        this.programado = false;
        this.minutosPrograma = 0;
        this.averiada = false;
        this.descripcionAveria = "";
    }

    public int getCapacidadKg() { return capacidadKg; }

    @Override
    public void encender() throws DispositivoAveriadoException {
        if (this.averiada) {
            throw new DispositivoAveriadoException();
        }
        this.encendido = true;
    }

    @Override
    public void apagar() {
        this.encendido = false;
        this.programado = false;
        this.minutosPrograma = 0;
    }

    @Override
    public void programarCiclo(int minutos) throws DispositivoAveriadoException {
        if (this.averiada) {
            throw new DispositivoAveriadoException();
        }
        this.programado = true;
        this.minutosPrograma = minutos;
    }

    @Override
    public void cancelarPrograma() {
        this.programado = false;
        this.minutosPrograma = 0;
    }

    @Override
    public boolean isProgramado() { return programado; }

    @Override
    public void registrarAveria(String descripcion) {
        this.averiada = true;
        this.descripcionAveria = descripcion;
        this.encendido = false;
    }

    @Override
    public void reparar() {
        this.averiada = false;
        this.descripcionAveria = "";
    }

    @Override
    public boolean isAveriado() { return averiada; }

    @Override
    public String getTipo() { return "Lavadora"; }

    @Override
    public String toString() {
        String info = super.toString() + " | " + capacidadKg + " kg"
                + " | " + (programado ? "Programa: " + minutosPrograma + " min" : "Sin programa");
        if (averiada) info += " | AVERÍA: " + descripcionAveria;
        return info;
    }
}
