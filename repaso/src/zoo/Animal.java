package zoo;

import java.util.Objects;

/**
 * Clase abstracta base para todos los animales del zoo.
 * Implementa Comparable para ordenar por edad.
 */
public abstract class Animal implements Comparable<Animal> {

    protected String nombre;
    protected String especie;
    protected int edad;
    protected double peso;
    protected boolean enCuarentena;

    public Animal(String nombre, String especie, int edad, double peso) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.enCuarentena = false;
    }

    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public int getEdad() { return edad; }
    public double getPeso() { return peso; }
    public boolean isEnCuarentena() { return enCuarentena; }

    public void ponerEnCuarentena() { this.enCuarentena = true; }
    public void levantarCuarentena() { this.enCuarentena = false; }

    public abstract String getTipoAnimal();

    @Override
    public String toString() {
        return getTipoAnimal() + " | " + nombre + " (" + especie + ") | "
                + edad + " años | " + peso + " kg | "
                + (enCuarentena ? "EN CUARENTENA" : "Sano");
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Animal that = (Animal) other;
        return Objects.equals(nombre, that.nombre) && Objects.equals(especie, that.especie);
    }

    @Override
    public int compareTo(Animal other) {
        return Integer.compare(this.edad, other.edad);
    }
}
