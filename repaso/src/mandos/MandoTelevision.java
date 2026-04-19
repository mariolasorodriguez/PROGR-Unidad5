package mandos;

/**
 * Representa un mando a distancia de televisión.
 * Permite controlar el volumen (sube y baja de 5 en 5) y el canal.
 * Implementa Ajustable para la gestión del volumen.
 */
public class MandoTelevision extends MandoDistancia implements Ajustable {

    final int INCREMENTO_VOLUMEN = 5;
    final int VOLUMEN_MAXIMO = 100;
    final int VOLUMEN_MINIMO = 0;

    private int volumen;
    private int canal;

    /**
     * Constructor del mando de televisión.
     * El volumen se inicializa a 50 y el canal a 1 por defecto.
     * @param modelo  Modelo del mando.
     * @param anchura Anchura en cm.
     * @param altura  Altura en cm.
     * @param precio  Precio en euros.
     */
    public MandoTelevision(String modelo, double anchura, double altura, double precio) {
        super(modelo, anchura, altura, precio);
        // Valores iniciales razonables para un mando de TV
        this.volumen = 50;
        this.canal = 1;
    }

    public int getVolumen() { return volumen; }
    public int getCanal() { return canal; }
    public void setCanal(int canal) { this.canal = canal; }

    /**
     * Sube el volumen de 5 en 5 sin superar el máximo de 100.
     */
    @Override
    public void subirNivel() {
        this.volumen += INCREMENTO_VOLUMEN;
        // Si supera el máximo lo fijamos al techo
        if (this.volumen > VOLUMEN_MAXIMO) {
            this.volumen = VOLUMEN_MAXIMO;
        }
    }

    /**
     * Baja el volumen de 5 en 5 sin bajar del mínimo de 0.
     */
    @Override
    public void bajarNivel() {
        this.volumen -= INCREMENTO_VOLUMEN;
        // Si cae por debajo del mínimo lo fijamos al suelo
        if (this.volumen < VOLUMEN_MINIMO) {
            this.volumen = VOLUMEN_MINIMO;
        }
    }

    /**
     * Devuelve toda la información del mando de televisión.
     * @return String con los datos base más volumen y canal actuales.
     */
    @Override
    public String toString() {
        return super.toString() + " | [TV] Vol: " + volumen + " | Canal: " + canal;
    }
}