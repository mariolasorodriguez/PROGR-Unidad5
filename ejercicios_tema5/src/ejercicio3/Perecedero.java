package ejercicio3;

public class Perecedero extends Producto {
    private int diasCaducar;

    public Perecedero(String nombre, double precio, int diasCaducar) {
        super(nombre, precio);
        this.diasCaducar = diasCaducar;
    }

    public int getDiasCaducar() { return diasCaducar; }
    public void setDiasCaducar(int diasCaducar) { this.diasCaducar = diasCaducar; }

    @Override
    public double calcular(int cantidad) {
        double total = super.calcular(cantidad);

        if (diasCaducar == 1) {
            total = total / 4;
        } else if (diasCaducar == 2) {
            total = total / 3;
        } else if (diasCaducar == 3) {
            total = total / 2;
        }

        return total;
    }

    @Override
    public String toString() {
        return super.toString() + ", Días para caducar: " + diasCaducar;
    }
}
