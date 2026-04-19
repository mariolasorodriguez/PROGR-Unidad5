package electrodomesticos;

import java.util.Objects;

/**
 * Clase abstracta base para todos los electrodomésticos.
 * Implementa Comparable para ordenar por consumo energético.
 */
public abstract class Electrodomestico implements Comparable<Electrodomestico> {

    protected String marca;
    protected String modelo;
    protected double consumoEnergetico;
    protected boolean encendido;

    public Electrodomestico(String marca, String modelo, double consumoEnergetico) {
        this.marca = marca;
        this.modelo = modelo;
        this.consumoEnergetico = consumoEnergetico;
        this.encendido = false;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getConsumoEnergetico() { return consumoEnergetico; }
    public boolean isEncendido() { return encendido; }

    public abstract void encender() throws DispositivoAveriadoException;
    public abstract void apagar();
    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + " | " + marca + " " + modelo + " | "
                + consumoEnergetico + " kWh | " + (encendido ? "Encendido" : "Apagado");
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Electrodomestico that = (Electrodomestico) other;
        return Objects.equals(marca, that.marca) && Objects.equals(modelo, that.modelo);
    }

    @Override
    public int compareTo(Electrodomestico other) {
        return Double.compare(this.consumoEnergetico, other.consumoEnergetico);
    }
}
