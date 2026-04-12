package analisis_ej01;

public class Camion extends Vehiculo {

    private double pesoMaxAutorizado;
    private boolean mercanciaPeligrosa;

    public Camion(String marca, String modelo, String color, String matricula,
                  double pesoMaxAutorizado, boolean mercanciaPeligrosa) {
        super(marca, modelo, color, matricula);
        this.pesoMaxAutorizado  = pesoMaxAutorizado;
        this.mercanciaPeligrosa = mercanciaPeligrosa;
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
        System.out.println("Camión parado. Motor apagado.");
    }

    @Override
    public String toString() {
        return super.toString().replace("Vehiculo{", "Camion{") +
                ", pesoMax=" + pesoMaxAutorizado + "t, peligrosa=" + mercanciaPeligrosa + "}";
    }
}