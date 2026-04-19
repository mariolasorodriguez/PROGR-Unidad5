package mandos;

/**
 * Representa un mando a distancia de aspiradora.
 * Controla la velocidad de aspiración (0–3), que sube y baja de 1 en 1.
 * Implementa Ajustable para la gestión de la velocidad.
 */
public class MandoAspiradora extends MandoDistancia implements Ajustable {

    final int VELOCIDAD_MAXIMA = 3;
    final int VELOCIDAD_MINIMA = 0;
    final int INCREMENTO = 1;

    private int velocidad;

    /**
     * Constructor del mando de aspiradora.
     * La velocidad se inicializa a 0 (parada) por defecto.
     * @param modelo  Modelo del mando.
     * @param anchura Anchura en cm.
     * @param altura  Altura en cm.
     * @param precio  Precio en euros.
     */
    public MandoAspiradora(String modelo, double anchura, double altura, double precio) {
        super(modelo, anchura, altura, precio);
        // La aspiradora arranca parada
        this.velocidad = 0;
    }

    public int getVelocidad() { return velocidad; }

    /**
     * Sube la velocidad de 1 en 1 sin superar el máximo de 3.
     */
    @Override
    public void subirNivel() {
        this.velocidad += INCREMENTO;
        if (this.velocidad > VELOCIDAD_MAXIMA) {
            this.velocidad = VELOCIDAD_MAXIMA;
        }
    }

    /**
     * Baja la velocidad de 1 en 1 sin bajar del mínimo de 0.
     */
    @Override
    public void bajarNivel() {
        this.velocidad -= INCREMENTO;
        if (this.velocidad < VELOCIDAD_MINIMA) {
            this.velocidad = VELOCIDAD_MINIMA;
        }
    }

    /**
     * Devuelve toda la información del mando de aspiradora.
     * @return String con los datos base más la velocidad actual.
     */
    @Override
    public String toString() {
        return super.toString() + " | [Aspiradora] Vel: " + velocidad + "/" + VELOCIDAD_MAXIMA;
    }
}
