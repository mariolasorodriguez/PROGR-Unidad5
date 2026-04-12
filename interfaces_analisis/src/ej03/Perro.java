package ej03;

public class Perro extends AnimalDomestico{

    private static final double PROBABILIDAD_OBEDIENCIA = 0.90;
    public Perro(String nombre, String raza, double peso, String color) {
        super(nombre, raza, peso, color);
    }

    @Override
    public boolean hacerCaso() {
        return Math.random() < PROBABILIDAD_OBEDIENCIA;
    }

    @Override
    public void hacerRuido() {
        System.out.println(getNombre() + " dice ¡Guau!");
    }

    public void sacaPaseo() {
        System.out.println(getNombre() + " está dando un paseo");
    }
}
