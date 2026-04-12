package analisis_ej04;

public abstract class Contacto {

    protected String nombre;
    protected String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre   = nombre;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contacto)) return false;
        Contacto otro = (Contacto) obj;
        return this.nombre.equals(otro.nombre);
    }

    @Override
    public abstract String toString();
}