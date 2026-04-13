package analisis_ej01;

public class Turismo extends Vehiculo {

    private int numPlazas;
    private TipoUso tipoUso;

    public Turismo(String marca, String modelo, String color, String matricula,
                   int numPlazas, TipoUso tipoUso) {
        super(marca, modelo, color, matricula);
        this.numPlazas = numPlazas;
        this.tipoUso   = tipoUso;
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
        if (!motorEncendido) {
            System.out.println("El motor ya estaba apagado.");
            return;
        }
        velocidadActual = 0;
        marchaActual    = 0;
        motorEncendido  = false;
        System.out.println("Vehículo parado. Motor apagado.");
    }

    @Override
    public String toString() {
        return super.toString().replace("Vehiculo{", "Turismo{") +
                ", plazas=" + numPlazas + ", uso=" + tipoUso + "}";
    }
}