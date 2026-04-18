package modelo_domotica;

/**
 * Interfaz que define el comportamiento para ajustar niveles numéricos
 * en los dispositivos inteligentes compatibles.
 */
public interface Ajustable {

    /**
     * Sube el nivel numérico del dispositivo según su incremento predeterminado.
     * @throws DispositivoApagadoException si se intenta ajustar un dispositivo que está apagado.
     */
    public void subirNivel() throws DispositivoApagadoException;

    /**
     * Baja el nivel numérico del dispositivo según su decremento predeterminado.
     * @throws DispositivoApagadoException si se intenta ajustar un dispositivo que está apagado.
     */
    public void bajarNivel() throws DispositivoApagadoException;
}
