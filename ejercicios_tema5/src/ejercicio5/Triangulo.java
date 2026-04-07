package ejercicio5;

public class Triangulo extends Poligono {

    public Triangulo(int numeroLados) {
        super(numeroLados);
    }

    @Override
    public double area() {
        return Math.pow(this.numeroLados, 2);
    }
}
