package modelo_domotica;

public class Camara extends DispositivoInteligente implements Alertable {

    private boolean estaGrabando;
    private boolean alertaActiva;
    private String mensajeAlerta;
    private String resolucion;

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

    public void iniciarGrabacion() throws DispositivoApagadoException {
        if (!this.estado)  {
            throw new DispositivoApagadoException();
        }
        this.estaGrabando = true;
    }

    public void detenerGrabacion() {
        this.estaGrabando = false;
    }

    @Override
    public void activarAlerta(String mensaje) throws DispositivoApagadoException {
        if (!this.estado) {
            throw new DispositivoApagadoException();
        }
        this.alertaActiva = true;
        this.mensajeAlerta = mensaje;
    }

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
        this.estaGrabando = false;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    @Override
    public String toString() {
        String infoCamara = super.toString() + " | " + this.resolucion + " | " + (this.estaGrabando ? "Grabando" : "Sin grabar");
        if (this.alertaActiva) {
            infoCamara += "\n | ALERTA: " + this.mensajeAlerta;
        }
        return infoCamara;
    }
}
