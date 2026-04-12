package analisis_ej03;

public class Main {

    public static void main(String[] args) {

        Titular t1 = new Titular("12345678A", "Ana",   "García López",  "600111222");
        Titular t2 = new Titular("87654321B", "Luis",  "Martín Ruiz",   "600333444");
        Titular t3 = new Titular("11223344C", "Marta", "Sánchez Pérez", "600555666");

        System.out.println("=== Cuenta de Ahorro ===\n");
        CuentaAhorro ahorro = new CuentaAhorro("ES001", t1, 15.0, 2.5);

        ahorro.ingresar(1000);
        ahorro.añadirTitular(t2);
        ahorro.retirar(200);
        System.out.println("Saldo con interés: " + ahorro.calcularSaldoConInteres() + "€");
        ahorro.aplicarCuotaMantenimiento();
        ahorro.borrarTitular("87654321B");
        System.out.println("\n" + ahorro);

        System.out.println("\n=== Cuenta Corriente ===\n");
        CuentaCorriente corriente = new CuentaCorriente("ES002", t2, 0.5);

        corriente.ingresar(2000);
        corriente.añadirTitular(t3);
        corriente.añadirTransaccion(new Transaccion(10, 4, 2026, "Luz",     80.0));
        corriente.añadirTransaccion(new Transaccion(10, 4, 2026, "Netflix", 15.0));
        corriente.retirar(500);
        System.out.println("Número de transacciones: " + corriente.getNumeroTransacciones());
        System.out.println("\n" + corriente);
    }
}