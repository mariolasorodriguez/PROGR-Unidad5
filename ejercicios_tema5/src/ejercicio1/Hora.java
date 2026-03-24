package ejercicio1;

public class Hora {
    private int hora;
    private int minuto;

    public Hora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    /**
     * Metodo que incrementa la hora en un minuto.
     */
    void incrementar() {
        if (minuto == 59) {
            minuto = 0;
            if (hora == 23) {
                hora = 0;
            } else {
                hora++;
            }
        } else {
            minuto++;
        }
    }

    boolean setMinutos(int valor) {
        boolean modificado = false;
        if (minuto != valor) {
            this.minuto = valor;
            modificado = true;
        }
        return modificado;
    }

    boolean setHora(int valor) {
        this.hora = valor;
        if (valor < 0 || valor > 23) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return +hora + ":" + minuto;
    }
}
