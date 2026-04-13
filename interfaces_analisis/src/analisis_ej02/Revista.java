package analisis_ej02;

public class Revista extends Ficha {

    private static final int DIAS_PRESTAMO = 10;

    private int numeroRevista;
    private int añoPublicacion;


    public Revista(int id, String titulo, int numeroRevista, int añoPublicacion) {
        super(id, titulo);
        this.numeroRevista   = numeroRevista;
        this.añoPublicacion = añoPublicacion;
    }

    public int getNumeroRevista() {
        return numeroRevista;
    }

    public void setNumeroRevista(int numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    @Override
    public int prestar() {
        return DIAS_PRESTAMO;
    }

    @Override
    public String toString() {
        return "Revista{id=" + id + ", titulo='" + titulo + "', numero=" + numeroRevista +
                ", año=" + añoPublicacion + ", prestamo=" + DIAS_PRESTAMO + " días}";
    }
}