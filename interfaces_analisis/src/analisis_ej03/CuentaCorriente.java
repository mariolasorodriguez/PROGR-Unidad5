package analisis_ej03;

public class CuentaCorriente extends CuentaBancaria {

    private static final int MAX_TRANSACCIONES = 100;

    private double        porcentajeTransaccion;
    private Transaccion[] transacciones;
    private int           numTransacciones;

    public CuentaCorriente(String numeroCuenta, Titular titular, double porcentajeTransaccion) {
        super(numeroCuenta, titular);
        this.porcentajeTransaccion = porcentajeTransaccion;
        this.transacciones         = new Transaccion[MAX_TRANSACCIONES];
        this.numTransacciones      = 0;
    }

    public void añadirTransaccion(Transaccion transaccion) {
        if (numTransacciones >= MAX_TRANSACCIONES) {
            System.out.println("No se pueden registrar más transacciones.");
            return;
        }
        double comision = transaccion.getImporte() * porcentajeTransaccion / 100;
        double total    = transaccion.getImporte() + comision;
        if (total > saldo) {
            System.out.println("Saldo insuficiente para la transacción.");
            return;
        }
        saldo -= total;
        transacciones[numTransacciones++] = transaccion;
        System.out.println("Transacción registrada: " + transaccion.getConcepto() +
                " | Importe: " + transaccion.getImporte() +
                "€ | Comisión: " + comision +
                "€ | Saldo actual: " + saldo + "€");
    }

    public int getNumeroTransacciones() { return numTransacciones; }

    public double getPorcentajeTransaccion() { return porcentajeTransaccion; }
    public void setPorcentajeTransaccion(double porcentajeTransaccion) {
        this.porcentajeTransaccion = porcentajeTransaccion;
    }

    @Override
    public String toString() {
        String resultado = "CuentaCorriente{numero='" + numeroCuenta +
                "', saldo=" + saldo +
                "€, titulares=" + titularesToString() +
                ", comision=" + porcentajeTransaccion +
                "%, transacciones=[";
        for (int i = 0; i < numTransacciones; i++) {
            resultado += transacciones[i];
            if (i < numTransacciones - 1) resultado += ", ";
        }
        return resultado + "]}";
    }
}