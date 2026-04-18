package modelo_domotica;

/**
 * Excepción personalizada que se lanza cuando se intenta realizar una
 * operación exclusiva de estado encendido sobre un dispositivo que
 * actualmente se encuentra apagado.
 */
public class DispositivoApagadoException extends Exception {

    /**
     * Constructor por defecto que establece el mensaje de error estándar
     * requerido por las especificaciones del catálogo.
     */
    public DispositivoApagadoException() {
        super("Error: El dispositivo está apagado.");
    }
}
