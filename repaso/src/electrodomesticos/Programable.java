package electrodomesticos;

/**
 * Interfaz para electrodomésticos con ciclos programables.
 */
public interface Programable {

    public void programarCiclo(int minutos) throws DispositivoAveriadoException;
    public void cancelarPrograma();
    public boolean isProgramado();
}