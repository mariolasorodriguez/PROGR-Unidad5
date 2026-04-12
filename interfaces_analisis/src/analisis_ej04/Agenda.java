package analisis_ej04;

public class Agenda {

    private static final int MAX_CONTACTOS = 100;

    private Contacto[] contactos;
    private int        numContactos;

    public Agenda() {
        this.contactos    = new Contacto[MAX_CONTACTOS];
        this.numContactos = 0;
    }

    public void añadirContacto(Contacto contacto) {
        if (numContactos >= MAX_CONTACTOS) {
            System.out.println("La agenda está llena.");
            return;
        }
        if (buscarContacto(contacto.getNombre()) != null) {
            System.out.println("Ya existe un contacto con el nombre " + contacto.getNombre());
            return;
        }
        contactos[numContactos++] = contacto;
        System.out.println("Contacto " + contacto.getNombre() + " añadido.");
    }

    public void borrarContacto(String nombre) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getNombre().equals(nombre)) {
                contactos[i] = contactos[numContactos - 1];
                contactos[numContactos - 1] = null;
                numContactos--;
                System.out.println("Contacto " + nombre + " eliminado.");
                return;
            }
        }
        System.out.println("No se encontró ningún contacto con el nombre " + nombre);
    }

    public Contacto buscarContacto(String nombre) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].getNombre().equals(nombre)) {
                return contactos[i];
            }
        }
        return null;
    }

    public void mostrarContactos() {
        if (numContactos == 0) {
            System.out.println("La agenda está vacía.");
            return;
        }
        for (int i = 0; i < numContactos; i++) {
            System.out.println(contactos[i]);
        }
    }
}
