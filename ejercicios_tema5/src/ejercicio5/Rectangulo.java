package ejercicio5;

public class Rectangulo extends Poligono{

    public Rectangulo(int numeroLados) {
        super(numeroLados);
    }

    @Override
    public double area() {
        return Math.pow(this.numeroLados, 2);
    }
}
