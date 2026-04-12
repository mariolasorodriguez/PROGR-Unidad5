package analisis_ej01;

public class Motocicleta extends Vehiculo {

    private static final int CC_CARNET = 125;

    private int cilindrada;

    public Motocicleta(String marca, String modelo, String color, String matricula, int cilindrada) {
        super(marca, modelo, color, matricula);
        this.cilindrada = cilindrada;
    }

    public boolean requiereCarnet() {
        return cilindrada >= CC_CARNET;
    }

    @Override
    public void arrancar() {
        if (motorEncendido) {
            System.out.println("El motor ya está encendido.");
            return;
        }
        motorEncendido = true;
        marchaActual   = 1;
        System.out.println("Motor arrancado. Primera marcha engranada.");
    }


    @Override
    public void parar() {
        velocidadActual = 0;
        marchaActual    = 0;
        motorEncendido  = false;
        System.out.println("Moto parada. Motor apagado.");
    }

    @Override
    public String toString() {
        return super.toString().replace("Vehiculo{", "Motocicleta{") +
                ", cilindrada=" + cilindrada + "CC, carnet=" + requiereCarnet() + "}";
    }
}
