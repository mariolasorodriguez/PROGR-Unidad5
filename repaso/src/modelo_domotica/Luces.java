package modelo_domotica;

public class Luces extends DispositivoInteligente implements Ajustable {

    final int BRILLO_PREDETERMINADO = 50;
    final int MAXIMO_BRILLO = 100;
    final int MINIMO_BRILLO = 0;
    final int BRILLO_INCREMENTADO = 10;

    private String color;
    private int nivelBrillo;

    public Luces(String nombreComercial, String marca, double precio, String color) {
        super(nombreComercial, marca, precio);
        this.color = color;
        this.nivelBrillo = BRILLO_PREDETERMINADO;
    }

    // GETTERS Y SETTERS

    public String getColor() {
        return color;
    }

    public int getNivelBrillo() {
        return nivelBrillo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void subirNivel() throws DispositivoApagadoException {
        if (!this.estado) {
            throw new DispositivoApagadoException();
        }

        this.nivelBrillo += BRILLO_INCREMENTADO;
        if (this.nivelBrillo > MAXIMO_BRILLO) {
            this.nivelBrillo = MAXIMO_BRILLO;
        }
    }

    @Override
    public void bajarNivel() throws DispositivoApagadoException {
        if (!this.estado) {
            throw new DispositivoApagadoException();
        }

        this.nivelBrillo -= BRILLO_INCREMENTADO;
        if (this.nivelBrillo < MINIMO_BRILLO) {
            this.nivelBrillo = MINIMO_BRILLO;
        }
    }

    @Override
    public void encenderDispositivo() {
        this.estado = true;
    }

    @Override
    public void apagarDispositivo() {
        this.estado = false;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + this.color + " | " + this.nivelBrillo;
    }
}
