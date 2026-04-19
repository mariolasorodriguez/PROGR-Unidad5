package electrodomesticos;

/**
 * Interfaz para electrodomésticos que pueden sufrir averías.
 */
public interface Reparable {

    public void registrarAveria(String descripcion);
    public void reparar();
    public boolean isAveriado();
}