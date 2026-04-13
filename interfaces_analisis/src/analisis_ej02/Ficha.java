package analisis_ej02;

public abstract class Ficha implements Prestable {

    protected int id;
    protected String titulo;

    public Ficha(int id, String titulo) {
        this.id     = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public abstract int prestar();

    @Override
    public abstract String toString();
}
