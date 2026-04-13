package analisis_ej02;

public class Libro extends Ficha {

    private static final int DIAS_PRESTAMO = 15;

    private String autor;
    private String editorial;


    public Libro(int id, String titulo, String autor, String editorial) {
        super(id, titulo);
        this.autor     = autor;
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public int prestar() {
        return DIAS_PRESTAMO;
    }

    @Override
    public String toString() {
        return "Libro{id=" + id + ", titulo='" + titulo + "', autor='" + autor +
                "', editorial='" + editorial + "', prestamo=" + DIAS_PRESTAMO + " días}";
    }
}
