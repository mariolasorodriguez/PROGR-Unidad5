package mandos;

/**
 * Interfaz que agrupa el comportamiento de subir y bajar un nivel numérico
 * (volumen o velocidad) en los mandos a distancia compatibles.
 * Cada subclase implementa el incremento que le corresponde.
 */
public interface Ajustable {

    /**
     * Sube el nivel del dispositivo según su incremento predeterminado,
     * respetando el valor máximo establecido.
     */
    public void subirNivel();

    /**
     * Baja el nivel del dispositivo según su decremento predeterminado,
     * respetando el valor mínimo establecido.
     */
    public void bajarNivel();
}