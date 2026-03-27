package ejercicio1;

public class Hora {
    private int hora;
    private int minuto;

    public Hora(int hora, int minuto) {
        if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Hora o minuto inválidos");
        }
        this.hora = hora;
        this.minuto = minuto;
    }

    /**
     * Metodo que incrementa la hora en un minuto.
     */
    void incrementar() {
        if (minuto == 59) {
            minuto = 00;
            if (hora == 23) {
                hora = 00;
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
        boolean valido = false;
        this.hora = valor;
        if (valor < 0 || valor > 23) {
        } else {
            valido = true;
        }
        return valido;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hora, minuto);
    }
}
