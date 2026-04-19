package mandos;

/**
 * Representa un mando a distancia de aire acondicionado.
 * Controla el modo (FRÍO/CALOR), la temperatura y la velocidad
 * del ventilador (0–5, sube y baja de 1 en 1).
 * Implementa Ajustable para la gestión de la velocidad.
 */
public class MandoAireAcondicionado extends MandoDistancia implements Ajustable {

    private final String MODO_FRIO = "FRÍO";
    private final String MODO_CALOR = "CALOR";
    final int VELOCIDAD_MAXIMA = 5;
    final int VELOCIDAD_MINIMA = 0;
    final int INCREMENTO = 1;

    private String modo;
    private double temperatura;
    private int velocidad;

    /**
     * Constructor del mando de aire acondicionado.
     * El modo se inicializa a FRÍO y la velocidad a 0 por defecto.
     * @param modelo       Modelo del mando.
     * @param anchura      Anchura en cm.
     * @param altura       Altura en cm.
     * @param precio       Precio en euros.
     * @param temperatura  Temperatura inicial deseada.
     */
    public MandoAireAcondicionado(String modelo, double anchura, double altura,
                                  double precio, double temperatura) {
        super(modelo, anchura, altura, precio);
        // Valores por defecto según el enunciado
        this.modo = MODO_FRIO;
        this.temperatura = temperatura;
        this.velocidad = 0;
    }

    public String getModo() { return modo; }
    public double getTemperatura() { return temperatura; }
    public int getVelocidad() { return velocidad; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }

    /**
     * Alterna el modo de funcionamiento entre FRÍO y CALOR.
     */
    public void cambiarModo() {
        // Si está en FRÍO pasamos a CALOR y viceversa
        if (this.modo.equals(MODO_FRIO)) {
            this.modo = MODO_CALOR;
        } else {
            this.modo = MODO_FRIO;
        }
    }

    /**
     * Sube la velocidad del ventilador de 1 en 1 sin superar el máximo de 5.
     */
    @Override
    public void subirNivel() {
        this.velocidad += INCREMENTO;
        if (this.velocidad > VELOCIDAD_MAXIMA) {
            this.velocidad = VELOCIDAD_MAXIMA;
        }
    }

    /**
     * Baja la velocidad del ventilador de 1 en 1 sin bajar del mínimo de 0.
     */
    @Override
    public void bajarNivel() {
        this.velocidad -= INCREMENTO;
        if (this.velocidad < VELOCIDAD_MINIMA) {
            this.velocidad = VELOCIDAD_MINIMA;
        }
    }

    /**
     * Devuelve toda la información del mando de aire acondicionado.
     * @return String con los datos base más modo, temperatura y velocidad.
     */
    @Override
    public String toString() {
        return super.toString() + " | [Aire] Modo: " + modo
                + " | " + temperatura + "°C | Vel: " + velocidad + "/" + VELOCIDAD_MAXIMA;
    }
}
