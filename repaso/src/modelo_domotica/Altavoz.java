package modelo_domotica;

public class Altavoz  extends DispositivoInteligente implements Ajustable {

    final int VOLUMEN_PREDETERMINADO = 30;
    final int MAXIMO_VOLUMEN = 100;
    final int MINIMO_VOLUMEN = 0;
    final int VOLUMEN_INCREMENTADO = 5;

    private String nombreAsistente;
    private int nivelVolumen;

    /**
     * Constructor que hereda atributos de la clase padre junto a los atributos de la clase Altavoz
     * @param nombreComercial nombre del Altavoz
     * @param marca marca del Altavoz
     * @param precio precio del Altavoz
     * @param nombreAsistente nombre del Asistente inteligente
     */
    public Altavoz(String nombreComercial, String marca, double precio, String nombreAsistente) {
        super(nombreComercial, marca, precio);
        this.nombreAsistente = nombreAsistente;
        this.nivelVolumen = VOLUMEN_PREDETERMINADO;
    }

    // GETTERS Y SETTERS

    public String getNombreAsistente() {
        return nombreAsistente;
    }

    public int getNivelVolumen() {
        return nivelVolumen;
    }

    public void setNombreAsistente(String nombreAsistente) {
        this.nombreAsistente = nombreAsistente;
    }

    /**
     * Sube el volumen de 5 en 5, con un límite máximo de 100.
     * @throws DispositivoApagadoException si el altavoz está apagado.
     */
    @Override
    public void subirNivel() throws DispositivoApagadoException {
        if (!this.estado) {
            throw new DispositivoApagadoException();
        }

        this.nivelVolumen += VOLUMEN_INCREMENTADO;
        if (this.nivelVolumen > MAXIMO_VOLUMEN) {
            this.nivelVolumen = MAXIMO_VOLUMEN;
        }
    }

    /**
     * Baja el volumen de 5 en 5, con un límite mínimo de 0.
     * @throws DispositivoApagadoException si el altavoz está apagado.
     */
    @Override
    public void bajarNivel() throws DispositivoApagadoException {
        if (!this.estado) {
            throw new DispositivoApagadoException();
        }

        this.nivelVolumen -= VOLUMEN_INCREMENTADO;
        if (this.nivelVolumen < MINIMO_VOLUMEN) {
            this.nivelVolumen = MINIMO_VOLUMEN;
        }
    }

    /**
     * Metodo que enciende el dispositivo, cambiando el estado a true
     */
    @Override
    public void encenderDispositivo() {
        this.estado = true;
    }

    /**
     * Metodo que apaga el dispositivo, cambiando el estado a false
     */
    @Override
    public void apagarDispositivo() {
        this.estado = false;
    }

    /**
     * Metodo toString de clase padre + atributos de Altavoz
     * @return toString del dispositivo inteligente que contiene nombre marca precio y estado, junto a los atributos de la clase altavoz
     */
    @Override
    public String toString() {
        return super.toString() + " | " + this.nombreAsistente + " | " + this.nivelVolumen;
    }
}
