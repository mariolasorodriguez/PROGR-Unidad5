package modelo_domotica;

/**
 * Representa una cámara de seguridad inteligente en el catálogo.
 * Implementa la interfaz Alertable para la gestión de avisos y seguridad.
 */
public class Camara extends DispositivoInteligente implements Alertable {

    private boolean estaGrabando;
    private boolean alertaActiva;
    private String mensajeAlerta;
    private String resolucion;

    /**
     * Constructor para inicializar una nueva Cámara de seguridad.
     * La grabación y las alertas comienzan desactivadas por defecto.
     * @param nombreComercial Nombre comercial de la cámara.
     * @param marca Marca del dispositivo.
     * @param precio Precio en el catálogo.
     * @param resolucion Resolución de vídeo (ej. "1080p", "4K").
     */
    public Camara(String nombreComercial, String marca, double precio, String resolucion) {
        super(nombreComercial, marca, precio);
        this.estaGrabando = false;
        this.alertaActiva = false;
        this.resolucion = resolucion;
        this.mensajeAlerta = "";
    }

    // GETTERS Y SETTERS
    public boolean isEstaGrabando() {
        return estaGrabando;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getMensajeAlerta() {
        return mensajeAlerta;
    }

    /**
     * Inicia el proceso de grabación de vídeo de la cámara.
     * @throws DispositivoApagadoException si se intenta grabar estando la cámara apagada.
     */
    public void iniciarGrabacion() throws DispositivoApagadoException {
        if (!this.estado)  {
            throw new DispositivoApagadoException();
        }
        this.estaGrabando = true;
    }

    /**
     * Detiene la grabación actual de vídeo.
     * No requiere verificar el estado de encendido porque su acción es cesar una actividad.
     */
    public void detenerGrabacion() {
        this.estaGrabando = false;
    }

    /**
     * Activa una alerta de seguridad en la cámara.
     * @param mensaje El texto descriptivo del incidente.
     * @throws DispositivoApagadoException si la cámara está apagada.
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
     * Desactiva la alerta activa en la cámara y limpia su mensaje.
     * @throws DispositivoApagadoException si la cámara está apagada.
     */
    @Override
    public void desactivarAlerta() throws DispositivoApagadoException {
        if (!this.estado) {
            throw new DispositivoApagadoException();
        }
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    /**
     * Consulta si existe alguna alerta de seguridad activa en el dispositivo.
     * @return true si hay alerta, false en caso contrario.
     */
    @Override
    public boolean isAlertaActiva() {
        return this.alertaActiva;
    }

    /**
     * Enciende la cámara.
     */
    @Override
    public void encenderDispositivo() {
        this.estado = true;
    }

    /**
     * Apaga la camara, deja de grabar y borra la alerta.
     */
    @Override
    public void apagarDispositivo() {
        this.estado = false;
        this.estaGrabando = false;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    /**
     * Devuelve una cadena de texto con toda la información de la cámara de seguridad.
     * @return Información base junto con resolución, estado de grabación y alertas.
     */
    @Override
    public String toString() {
        String infoCamara = super.toString() + " | " + this.resolucion + " | " + (this.estaGrabando ? "Grabando" : "Sin grabar");
        if (this.alertaActiva) {
            infoCamara += "\n | ALERTA: " + this.mensajeAlerta;
        }
        return infoCamara;
    }
}
