package electrodomesticos;

/**
 * Representa una nevera. Implementa solo Reparable
 * (no tiene ciclos programables).
 */
public class Nevera extends Electrodomestico implements Reparable {

    private double temperaturaActual;
    private boolean averiada;
    private String descripcionAveria;

    public Nevera(String marca, String modelo, double consumo, double temperaturaActual) {
        super(marca, modelo, consumo);
        this.temperaturaActual = temperaturaActual;
        this.averiada = false;
        this.descripcionAveria = "";
    }

    public double getTemperaturaActual() { return temperaturaActual; }

    public void ajustarTemperatura(double nuevaTemp) throws DispositivoAveriadoException {
        if (this.averiada) {
            throw new DispositivoAveriadoException();
        }
        this.temperaturaActual = nuevaTemp;
    }

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
    }

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
    public String getTipo() { return "Nevera"; }

    @Override
    public String toString() {
        String info = super.toString() + " | " + temperaturaActual + "°C";
        if (averiada) info += " | AVERÍA: " + descripcionAveria;
        return info;
    }
}
