package analisis_ej03;

public class CuentaAhorro extends CuentaBancaria {

    private double cuotaMantenimiento;
    private double interesAnual;

    public CuentaAhorro(String numeroCuenta, Titular titular,
                        double cuotaMantenimiento, double interesAnual) {
        super(numeroCuenta, titular);
        this.cuotaMantenimiento = cuotaMantenimiento;
        this.interesAnual       = interesAnual;
    }

    public double calcularSaldoConInteres() {
        return saldo + (saldo * interesAnual / 100);
    }

    public void aplicarCuotaMantenimiento() {
        saldo -= cuotaMantenimiento;
        System.out.println("Cuota de mantenimiento de " + cuotaMantenimiento +
                "€ aplicada. Saldo actual: " + saldo + "€");
    }

    public double getCuotaMantenimiento() { return cuotaMantenimiento; }
    public void setCuotaMantenimiento(double cuotaMantenimiento) {
        this.cuotaMantenimiento = cuotaMantenimiento;
    }

    public double getInteresAnual() { return interesAnual; }
    public void setInteresAnual(double interesAnual) { this.interesAnual = interesAnual; }

    @Override
    public String toString() {
        return "CuentaAhorro{numero='" + numeroCuenta + "', saldo=" + saldo +
                "€, titulares=" + titularesToString() +
                ", cuota=" + cuotaMantenimiento + "€, interes=" + interesAnual + "%}";
    }
}
