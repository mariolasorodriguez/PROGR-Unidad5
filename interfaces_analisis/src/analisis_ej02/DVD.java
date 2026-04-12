package analisis_ej02;

public class DVD extends Ficha {

    private static final int DIAS_PRESTAMO = 5;

    private String director;
    private int año;
    private TipoDVD tipo;


    public DVD(int id, String titulo, String director, int año, TipoDVD tipo) {
        super(id, titulo);
        this.director = director;
        this.año = año;
        this.tipo     = tipo;
    }

    /** @return director del DVD */
    public String getDirector() { return director; }

    /** @param director nuevo director */
    public void setDirector(String director) { this.director = director; }

    /** @return año del DVD */
    public int getAño() { return año; }

    /** @param año nuevo año */
    public void setAño(int año) { this.año = año; }

    /** @return tipo de contenido del DVD */
    public TipoDVD getTipo() { return tipo; }

    /** @param tipo nuevo tipo de contenido */
    public void setTipo(TipoDVD tipo) { this.tipo = tipo; }

    /**
     * Devuelve los días de préstamo de un DVD.
     *
     * @return 5 días
     */
    @Override
    public int prestar() { return DIAS_PRESTAMO; }

    /**
     * Devuelve una representación legible del DVD.
     *
     * @return cadena con todos los atributos
     */
    @Override
    public String toString() {
        return "DVD{id=" + id + ", titulo='" + titulo + "', director='" + director +
                "', año=" + año + ", tipo=" + tipo + ", prestamo=" + DIAS_PRESTAMO + " días}";
    }
}