package modelo_domotica;

/**
 * Interfaz que define el comportamiento para los dispositivos del catálogo
 * capaces de emitir y gestionar alertas de seguridad o mantenimiento.
 */
public interface Alertable {

    /**
     * Activa una alerta en el dispositivo guardando un mensaje descriptivo.
     * @param mensaje El texto con el motivo o detalle de la alerta.
     * @throws DispositivoApagadoException si el dispositivo está apagado en el momento de activarla.
     */
    public void activarAlerta(String mensaje) throws DispositivoApagadoException;

    /**
     * Desactiva la alerta actual del dispositivo, borrando su mensaje asociado.
     * @throws DispositivoApagadoException si el dispositivo está apagado.
     */
    public void desactivarAlerta() throws DispositivoApagadoException;

    /**
     * Informa sobre el estado actual de las alertas en el dispositivo.
     * @return true si hay una alerta actualmente activa, false en caso contrario.
     */
    public boolean isAlertaActiva();
}
