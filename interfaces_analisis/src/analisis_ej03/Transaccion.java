package analisis_ej03;

public class Transaccion {

    private int    dia;
    private int    mes;
    private int    año;
    private String concepto;
    private double importe;

    public Transaccion(int dia, int mes, int año, String concepto, double importe) {
        this.dia      = dia;
        this.mes      = mes;
        this.año      = año;
        this.concepto = concepto;
        this.importe  = importe;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Transaccion{fecha=" + dia + "/" + mes + "/" + año +
                ", concepto='" + concepto + "', importe=" + importe + "€}";
    }
}