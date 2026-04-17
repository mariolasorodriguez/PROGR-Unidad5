package modelo_domotica;

public interface Alertable {

    public void activarAlerta(String mensaje) throws DispositivoApagadoException;

    public void desactivarAlerta() throws DispositivoApagadoException;

    public boolean isAlertaActiva();
}
