package modelo_domotica;

import java.util.Objects;

/**
 * Clase abstracta que representa la base de cualquier dispositivo
 * inteligente dentro del catálogo de la empresa.
 * Implementa la interfaz Comparable para permitir la ordenación natural por precio.
 * @author Mario Laso
 * @version 1.0
 */
public abstract class DispositivoInteligente implements Comparable<DispositivoInteligente> {

    protected String nombreComercial;
    protected String marca;
    protected double precio;
    protected boolean estado;

    /**
     * Constructor base para inicializar los atributos comunes de los dispositivos inteligentes.
     * El estado del dispositivo se establece por defecto a apagado (false).
     * * @param nombreComercial El nombre comercial asignado al dispositivo.
     * @param marca           La marca fabricante del dispositivo.
     * @param precio          El precio de venta en el catálogo.
     */
    public DispositivoInteligente(String nombreComercial, String marca, double precio) {
        this.nombreComercial = nombreComercial;
        this.marca = marca;
        this.precio = precio;
        this.estado = false;
    }

    // GETTERS Y SETTERS
    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEstado() {
        return estado;
    }

    /**
     * Enciende el dispositivo.
     * Este metodo es abstracto; la implementación del proceso de encendido
     * se delega a las clases hijas concretas.
     */
    public abstract void encenderDispositivo();

    /**
     * Apaga el dispositivo.
     * Este metodo es abstracto; la implementación del proceso de apagado
     * se delega a las clases hijas concretas.
     */
    public abstract void apagarDispositivo();

    /**
     * Devuelve una representación en formato de cadena de texto con la información
     * general del dispositivo.
     * * @return Una cadena que contiene el nombre comercial, la marca, el precio y el estado.
     */
    @Override
    public String toString() {
        return nombreComercial + " | " + marca + " | " + precio + "€ | " + "Estado: " + (estado ? "Encendido" : "Apagado");
    }

    /**
     * Determina si dos dispositivos son el mismo producto dentro del catálogo.
     * Se considera que son iguales si coinciden exactamente en su nombre comercial y en su marca.
     * * @param obj El objeto con el que se va a comparar.
     * @return true si ambos dispositivos son iguales según los criterios de negocio, false en caso contrario.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        DispositivoInteligente that = (DispositivoInteligente) other;
        return Objects.equals(nombreComercial, that.nombreComercial) && Objects.equals(marca, that.marca);
    }

    /**
     * Compara este dispositivo con otro para establecer un orden basado en el precio.
     * * @param otroDispositivo El objeto DispositivoInteligente con el que se va a comparar.
     * @return Un valor negativo si este dispositivo es más barato, cero si tienen el mismo precio,
     * o un valor positivo si este dispositivo es más caro.
     */
    @Override
    public int compareTo(DispositivoInteligente other) {
        return Double.compare(this.precio, other.precio);
    }
}
