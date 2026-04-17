package modelo_domotica;

public class Termostato extends DispositivoInteligente implements Alertable {

    private final String MODO_INVIERNO = "Invierno";
    private final String MODO_VERANO = "Verano";


    private double temperaturaObjetivo;
    private String modoFuncionamiento;
    private boolean alertaActiva;
    private String mensajeAlerta;

    public Termostato(String nombreComercial, String marca, double precio, double temperaturaObjetivo) {
        super(nombreComercial, marca, precio);
        this.temperaturaObjetivo = temperaturaObjetivo;
        this.modoFuncionamiento = MODO_INVIERNO;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    // GETTERS Y SETTERS

    public double getTemperaturaObjetivo() {
        return temperaturaObjetivo;
    }

    public void setTemperaturaObjetivo(double temperaturaObjetivo) {
        this.temperaturaObjetivo = temperaturaObjetivo;
    }

    public String getModoFuncionamiento() {
        return modoFuncionamiento;
    }

    public String getMensajeAlerta() {
        return mensajeAlerta;
    }

    /**
     * Alterna el modo de funcionamiento entre Invierno y Verano
     */
    public void cambiarModoFuncionamiento(){
        if (this.modoFuncionamiento.equals(MODO_INVIERNO)) {
            this.modoFuncionamiento = MODO_VERANO;
        } else {
            this.modoFuncionamiento = MODO_INVIERNO;
        }
    }

    /**
     * Metodo que activa la alerta
     * @param mensaje recibe mensaje de alerta
     * @throws DispositivoApagadoException lanza excepcion si el dispositivo está apagado
     */
    @Override
    public void activarAlerta(String mensaje) throws DispositivoApagadoException {
        if (!this.estado) {
            throw new DispositivoApagadoException();
        }
        this.alertaActiva = true;
        this.mensajeAlerta = mensaje;
    }

    /**
     * Metodo para desactivar la alerta
     * @throws DispositivoApagadoException lanza excepcion si el dispositivo está apagado
     */
    @Override
    public void desactivarAlerta() throws DispositivoApagadoException {
        if (!this.estado) {
            throw new DispositivoApagadoException();
        }
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    @Override
    public boolean isAlertaActiva() {
        return this.alertaActiva;
    }

    @Override
    public void encenderDispositivo() {
        this.estado = true;
    }

    @Override
    public void apagarDispositivo() {
        this.estado = false;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    @Override
    public String toString() {
        String infoTermostato = super.toString() + " | " + temperaturaObjetivo + "ºC | " + modoFuncionamiento;
        if (this.alertaActiva) {
            infoTermostato += "\n | ALERTA: " + mensajeAlerta;
        }
        return infoTermostato;
    }
}
