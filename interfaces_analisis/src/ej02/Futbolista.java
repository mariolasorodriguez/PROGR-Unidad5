package ej02;

public class Futbolista implements Comparable<Futbolista> {

    private int numeroCamiseta;
    private String nombre;
    private int edad;
    private int numeroGoles;

    public Futbolista(int numeroCamiseta, String nombre, int edad, int numeroGoles) {
        this.numeroCamiseta = numeroCamiseta;
        this.nombre = nombre;
        this.edad = edad;
        this.numeroGoles = numeroGoles;
    }

    @Override
    public int compareTo(Futbolista otro) {
        int comparacionCamiseta = Integer.compare(this.numeroCamiseta, otro.numeroCamiseta);
        if (comparacionCamiseta != 0) {
            return comparacionCamiseta;
        }
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Futbolista))
            return false;
        Futbolista otro = (Futbolista) obj;
        return this.numeroCamiseta == otro.numeroCamiseta && this.nombre.equals(otro.nombre);
    }

    @Override
    public String toString() {
        return "Futbolista{camiseta=" + numeroCamiseta
                + ", nombre='" + nombre + "'"
                + ", edad=" + edad
                + ", goles=" + numeroGoles + "}";
    }
}

