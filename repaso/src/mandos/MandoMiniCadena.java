package mandos;

/**
 * Representa un mando a distancia de minicadena.
 * Solo puede controlar el volumen, que sube y baja de 10 en 10.
 * Implementa Ajustable para la gestión del volumen.
 */
public class MandoMiniCadena extends MandoDistancia implements Ajustable {

    final int INCREMENTO_VOLUMEN = 10;
    final int VOLUMEN_MAXIMO = 100;
    final int VOLUMEN_MINIMO = 0;

    private int volumen;

    /**
     * Constructor del mando de minicadena.
     * El volumen se inicializa a 30 por defecto.
     * @param modelo  Modelo del mando.
     * @param anchura Anchura en cm.
     * @param altura  Altura en cm.
     * @param precio  Precio en euros.
     */
    public MandoMiniCadena(String modelo, double anchura, double altura, double precio) {
        super(modelo, anchura, altura, precio);
        this.volumen = 30;
    }

    public int getVolumen() { return volumen; }

    /**
     * Sube el volumen de 10 en 10 sin superar el máximo de 100.
     */
    @Override
    public void subirNivel() {
        this.volumen += INCREMENTO_VOLUMEN;
        if (this.volumen > VOLUMEN_MAXIMO) {
            this.volumen = VOLUMEN_MAXIMO;
        }
    }

    /**
     * Baja el volumen de 10 en 10 sin bajar del mínimo de 0.
     */
    @Override
    public void bajarNivel() {
        this.volumen -= INCREMENTO_VOLUMEN;
        if (this.volumen < VOLUMEN_MINIMO) {
            this.volumen = VOLUMEN_MINIMO;
        }
    }

    /**
     * Devuelve toda la información del mando de minicadena.
     * @return String con los datos base más el volumen actual.
     */
    @Override
    public String toString() {
        return super.toString() + " | [MiniCadena] Vol: " + volumen;
    }
}
