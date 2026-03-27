package ejercicio1;

/**
 * Clase que
 */
public class HoraExacta extends Hora {

    private int segundo;

    public HoraExacta(int hora, int minuto, int segundo) {
        super(hora, minuto);
        if (segundo < 0 || segundo > 59) {
            throw new IllegalArgumentException("Segundo invalido");
        }
        this.segundo = segundo;
    }

    boolean setSegundo(int valor) {
        boolean modificado = valor >= 0 && valor <= 59;
        if (modificado) {
            this.segundo = valor;
        }
        return modificado;
    }

    public void incrementar() {
        segundo++;
        if (segundo == 60) {
            segundo = 0;
            super.incrementar();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ":" + String.format("%02d", segundo);
    }
}
