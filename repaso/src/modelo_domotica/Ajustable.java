package modelo_domotica;

public interface Ajustable {

    public void subirNivel() throws DispositivoApagadoException;

    public void bajarNivel() throws DispositivoApagadoException;
}
