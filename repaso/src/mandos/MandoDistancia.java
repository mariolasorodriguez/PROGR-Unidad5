package mandos;

import java.util.Objects;

/**
 * Clase abstracta que representa la base de cualquier mando a distancia
 * del catálogo de la tienda.
 * Implementa Comparable para ordenar los mandos alfabéticamente por modelo.
 */
public abstract class MandoDistancia implements Comparable<MandoDistancia> {

    protected String modelo;
    protected double anchura;
    protected double altura;
    protected double precio;
    protected boolean encendido;

    /**
     * Constructor base para inicializar los atributos comunes de todos los mandos.
     * El mando se crea apagado por defecto.
     * @param modelo   Nombre comercial del modelo del mando.
     * @param anchura  Anchura del mando en centímetros.
     * @param altura   Altura del mando en centímetros.
     * @param precio   Precio de venta en euros.
     */
    public MandoDistancia(String modelo, double anchura, double altura, double precio) {
        this.modelo = modelo;
        this.anchura = anchura;
        this.altura = altura;
        this.precio = precio;
        this.encendido = false;
    }

    // GETTERS
    public String getModelo() { return modelo; }
    public double getAnchura() { return anchura; }
    public double getAltura() { return altura; }
    public double getPrecio() { return precio; }
    public boolean isEncendido() { return encendido; }

    /**
     * Enciende el mando cambiando su estado a true.
     */
    public void encender() {
        // Activamos el botón de encendido
        this.encendido = true;
    }

    /**
     * Apaga el mando cambiando su estado a false.
     */
    public void apagar() {
        // Desactivamos el botón de encendido
        this.encendido = false;
    }

    /**
     * Devuelve una representación en texto con la información general del mando.
     * @return Cadena con modelo, dimensiones, precio y estado.
     */
    @Override
    public String toString() {
        return modelo + " | " + anchura + "cm x " + altura + "cm | "
                + precio + "€ | " + (encendido ? "Encendido" : "Apagado");
    }

    /**
     * Dos mandos son iguales si tienen el mismo modelo.
     * @param obj Objeto con el que comparar.
     * @return true si el modelo coincide exactamente.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        MandoDistancia that = (MandoDistancia) obj;
        return Objects.equals(modelo, that.modelo);
    }

    /**
     * Compara mandos por orden alfabético de su modelo.
     * @param other El otro mando con el que comparar.
     * @return Valor negativo, cero o positivo según el orden.
     */
    @Override
    public int compareTo(MandoDistancia other) {
        // Delegamos la comparación alfabética al método compareTo de String
        return this.modelo.compareTo(other.modelo);
    }
}
