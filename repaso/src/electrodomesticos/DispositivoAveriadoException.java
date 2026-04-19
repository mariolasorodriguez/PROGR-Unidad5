package electrodomesticos;

/**
 * Excepción lanzada cuando se intenta operar con un
 * electrodoméstico que está averiado.
 */
public class DispositivoAveriadoException extends Exception {

    public DispositivoAveriadoException() {
        super("Error: El electrodoméstico está averiado y no puede operar.");
    }
}


