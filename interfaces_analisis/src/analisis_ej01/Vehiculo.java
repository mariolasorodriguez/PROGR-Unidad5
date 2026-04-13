package analisis_ej01;

public abstract class Vehiculo implements Conducible {

    private static final int MARCHA_MINIMA   = 0;
    private static final int MARCHA_MAXIMA   = 5;
    private static final int VELOCIDAD_1     = 30;
    private static final int VELOCIDAD_2     = 50;
    private static final int VELOCIDAD_3     = 70;
    private static final int VELOCIDAD_4     = 100;

    protected String marca;
    protected String modelo;
    protected String color;
    protected String matricula;
    protected boolean motorEncendido;
    protected int marchaActual;
    protected int velocidadActual;

    public Vehiculo(String marca, String modelo, String color, String matricula) {
        this.marca          = marca;
        this.modelo         = modelo;
        this.color          = color;
        this.matricula      = matricula;
        this.motorEncendido = false;
        this.marchaActual   = 0;
        this.velocidadActual = 0;
    }

    @Override
    public void subirMarcha() {
        if (!motorEncendido) {
            System.out.println("El motor está apagado, no se puede subir marcha.");
            return;
        }
        if (marchaActual >= MARCHA_MAXIMA) {
            System.out.println("Ya estás en la marcha máxima.");
            return;
        }
        marchaActual++;
        System.out.println("Marcha subida -> " + marchaActual + "ª");
    }

    @Override
    public void bajarMarcha() {
        if (!motorEncendido) {
            System.out.println("El motor está apagado, no se puede bajar marcha.");
            return;
        }
        if (marchaActual <= MARCHA_MINIMA) {
            System.out.println("Ya estás en punto muerto.");
            return;
        }
        marchaActual--;
        System.out.println("Marcha bajada -> " + (marchaActual == 0 ? "punto muerto" : marchaActual + "ª"));
    }

    public int marchaRecomendada() {
        if      (velocidadActual < VELOCIDAD_1) return 1;
        else if (velocidadActual < VELOCIDAD_2) return 2;
        else if (velocidadActual < VELOCIDAD_3) return 3;
        else if (velocidadActual < VELOCIDAD_4) return 4;
        else                                    return 5;
    }


    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public int getMarchaActual() {
        return marchaActual;
    }

    public boolean isMotorEncendido() {
        return motorEncendido;
    }

    @Override
    public String toString() {
        return "Vehiculo{marca='" + marca + "', modelo='" + modelo + "', color='" + color +
                "', matricula='" + matricula + "', motor=" + (motorEncendido ? "ARRANCADO" : "APAGADO") +
                ", marcha=" + marchaActual + ", velocidad=" + velocidadActual + " km/h}";
    }
}

