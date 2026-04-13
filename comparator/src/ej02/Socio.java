package ej02;

import java.util.Objects;

public class Socio {
    private String nombre;
    private String apellidos;
    private int edad;

    public Socio(String nombre, int edad, String apellidos) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + apellidos + ", " + edad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return edad == socio.edad && Objects.equals(nombre, socio.nombre) && Objects.equals(apellidos, socio.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, edad);
    }
}
