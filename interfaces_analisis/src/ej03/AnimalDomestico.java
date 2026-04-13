package ej03;

public abstract class AnimalDomestico implements Vivir {

    public AnimalDomestico(String nombre, String raza, double peso, String color) {
        this.nombre = nombre;
        this.raza = raza;
        this.peso = peso;
        this.color = color;
    }

    protected String nombre;
    protected String raza;
    protected double peso;
    protected String color;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void comer() {
        System.out.println(nombre + " está comiendo");
    }

    @Override
    public void dormir() {
        System.out.println(nombre + " está durmiendo");
    }

    public void vacunar() {
        System.out.println(nombre + " ha sido vacunado/a");
    }

    public abstract boolean hacerCaso();

    @Override
    public abstract void hacerRuido();

    @Override
    public String toString() {
        return nombre + ", " + raza + ", " + peso + "kg, " + color;
    }
}
