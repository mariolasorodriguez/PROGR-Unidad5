package ejercicio5;

public abstract class Poligono {

    private int numeroLados;

    public Poligono(int numeroLados) {
        this.numeroLados = numeroLados;
    }

    public int getNumeroLados() {
        return numeroLados;
    }

    public abstract double area();

    @Override
    public String toString() {
        return "Número de lados: " + numeroLados;
    }
}