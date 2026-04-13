package analisis_ej03;

public abstract class CuentaBancaria implements Operable {

    private static final int MAX_TITULARES = 3;

    protected String    numeroCuenta;
    protected double    saldo;
    protected Titular[] titulares;
    protected int       numTitulares;

    public CuentaBancaria(String numeroCuenta, Titular titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo        = 0.0;
        this.titulares    = new Titular[MAX_TITULARES];
        this.numTitulares = 0;
        titulares[numTitulares++] = titular;
    }

    @Override
    public void ingresar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a ingresar debe ser positiva.");
            return;
        }
        saldo += cantidad;
        System.out.println("Ingreso de " + cantidad + "€ realizado. Saldo actual: " + saldo + "€");
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser positiva.");
            return;
        }
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente. Saldo actual: " + saldo + "€");
            return;
        }
        saldo -= cantidad;
        System.out.println("Retirada de " + cantidad + "€ realizada. Saldo actual: " + saldo + "€");
    }

    public void añadirTitular(Titular titular) {
        if (numTitulares >= MAX_TITULARES) {
            System.out.println("No se pueden añadir más titulares. Máximo: " + MAX_TITULARES);
            return;
        }
        titulares[numTitulares++] = titular;
        System.out.println("Titular " + titular.getNombre() + " añadido.");
    }

    public void borrarTitular(String dni) {
        if (numTitulares == 1) {
            System.out.println("No se puede borrar el único titular de la cuenta.");
            return;
        }
        for (int i = 0; i < numTitulares; i++) {
            if (titulares[i].getDni().equals(dni)) {
                titulares[i] = titulares[numTitulares - 1];
                titulares[numTitulares - 1] = null;
                numTitulares--;
                System.out.println("Titular con DNI " + dni + " eliminado.");
                return;
            }
        }
        System.out.println("No se encontró ningún titular con DNI " + dni);
    }

    public double getSaldo() { return saldo; }
    public String getNumeroCuenta() { return numeroCuenta; }

    @Override
    public abstract String toString();

    protected String titularesToString() {
        String resultado = "[";
        for (int i = 0; i < numTitulares; i++) {
            resultado += titulares[i].getNombre() + " " + titulares[i].getApellidos();
            if (i < numTitulares - 1) resultado += ", ";
        }
        return resultado + "]";
    }
}
