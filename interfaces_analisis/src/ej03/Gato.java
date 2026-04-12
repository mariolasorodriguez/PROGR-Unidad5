package ej03;

public class Gato extends AnimalDomestico {

    private static final double PROBABILIDAD_OBEDIENCIA = 0.05;
    public Gato(String nombre, String raza, double peso, String color) {
        super(nombre, raza, peso, color);
    }

    @Override
    public boolean hacerCaso() {
        return Math.random() < PROBABILIDAD_OBEDIENCIA;
    }

    @Override
    public void hacerRuido() {
        System.out.println(getNombre() + " dice ¡Miau!");
    }

    public void toserBolaPelo() {
        System.out.println(getNombre() + " está tosiendo pelo");
    }


}
