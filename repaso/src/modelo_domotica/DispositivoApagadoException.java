package modelo_domotica;

public class DispositivoApagadoException extends Exception {
    public DispositivoApagadoException() {
        super("Error: El dispositivo está apagado.");
    }
}
