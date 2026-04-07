package ejercicio5;

public abstract class Poligono {

    public Poligono(int numeroLados) {
        this.numeroLados = numeroLados;
    }

    protected int numeroLados;

    @Override
    public String toString() {
        return "Numero de lados del poligono: " + numeroLados;
    }

    public abstract double area();
}
