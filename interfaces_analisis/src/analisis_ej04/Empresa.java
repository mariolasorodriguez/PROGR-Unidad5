package analisis_ej04;

public class Empresa extends Contacto {

    private String paginaWeb;

    public Empresa(String nombre, String telefono, String paginaWeb) {
        super(nombre, telefono);
        this.paginaWeb = paginaWeb;
    }

    public String getPaginaWeb() { return paginaWeb; }
    public void setPaginaWeb(String paginaWeb) { this.paginaWeb = paginaWeb; }

    @Override
    public String toString() {
        return "Empresa{nombre='" + nombre + "', telefono='" + telefono +
                "', paginaWeb='" + paginaWeb + "'}";
    }
}