package modelo_domotica;

/**
 * Representa una luz inteligente en el catálogo.
 * Es una clase concreta que hereda de DispositivoInteligente e implementa la interfaz Ajustable.
 */
public class Luces extends DispositivoInteligente implements Ajustable {

    final int BRILLO_PREDETERMINADO = 50;
    final int MAXIMO_BRILLO = 100;
    final int MINIMO_BRILLO = 0;
    final int BRILLO_INCREMENTADO = 10;

    private String color;
    private int nivelBrillo;

    /**
     * Constructor de las luces inteligentes.
     * El estado empieza en apagado y el brillo en 50 por defecto.
     * @param nombreComercial Nombre comercial de las luces.
     * @param marca Marca de las luces.
     * @param precio Precio de venta.
     * @param color Color inicial de la iluminación.
     */
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

    /**
     * Sube el brillo de 10 en 10, respetando el límite máximo de 100.
     * @throws DispositivoApagadoException si la luz está apagada.
     */
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

    /**
     * Baja el brillo de 10 en 10, respetando el límite mínimo de 0.
     * @throws DispositivoApagadoException si la luz está apagada.
     */
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

    /**
     * Enciende las luces cambiando su estado interno a verdadero.
     */
    @Override
    public void encenderDispositivo() {
        this.estado = true;
    }

    /**
     * Apaga las luces cambiando su estado interno a falso.
     */
    @Override
    public void apagarDispositivo() {
        this.estado = false;
    }

    /**
     * Devuelve una cadena de texto con toda la información de la luz.
     * @return Información base del dispositivo junto con su color y brillo actual.
     */
    @Override
    public String toString() {
        return super.toString() + " | " + this.color + " | " + this.nivelBrillo;
    }
}
