package electrodomesticos;

/**
 * Representa un microondas. Implementa solo Programable
 * (no suele registrar averías formales).
 */
public class Microondas extends Electrodomestico implements Programable {

    private int potenciaWatios;
    private boolean programado;
    private int minutosPrograma;

    public Microondas(String marca, String modelo, double consumo, int potenciaWatios) {
        super(marca, modelo, consumo);
        this.potenciaWatios = potenciaWatios;
        this.programado = false;
        this.minutosPrograma = 0;
    }

    public int getPotenciaWatios() { return potenciaWatios; }

    @Override
    public void encender() throws DispositivoAveriadoException {
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
    public String getTipo() { return "Microondas"; }

    @Override
    public String toString() {
        return super.toString() + " | " + potenciaWatios + "W"
                + " | " + (programado ? "Programa: " + minutosPrograma + " min" : "Sin programa");
    }
}
