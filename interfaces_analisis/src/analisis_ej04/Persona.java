package analisis_ej04;

public class Persona extends Contacto {

    private String cumpleaños;

    public Persona(String nombre, String telefono, String cumpleaños) {
        super(nombre, telefono);
        this.cumpleaños = cumpleaños;
    }

    public String getCumpleaños() { return cumpleaños; }
    public void setCumpleaños(String cumpleaños) { this.cumpleaños = cumpleaños; }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', telefono='" + telefono +
                "', cumpleaños='" + cumpleaños + "'}";
    }
}

