package analisis_ej04;

public class Main {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        agenda.añadirContacto(new Persona("Ana García",   "600111222", "15/03/1990"));
        agenda.añadirContacto(new Persona("Luis Martín",  "600333444", "22/07/1985"));
        agenda.añadirContacto(new Empresa("Telefónica",   "900111222", "www.telefonica.com"));
        agenda.añadirContacto(new Empresa("Mercadona",    "900333444", "www.mercadona.es"));
        agenda.añadirContacto(new Persona("Ana García",   "600999000", "15/03/1990"));

        System.out.println("\n=== Agenda completa ===");
        agenda.mostrarContactos();

        System.out.println("\n=== Buscar contacto ===");
        Contacto encontrado = agenda.buscarContacto("Telefónica");
        System.out.println(encontrado != null ? encontrado : "No encontrado.");

        System.out.println("\n=== Borrar contacto ===");
        agenda.borrarContacto("Luis Martín");
        agenda.borrarContacto("Inexistente");

        System.out.println("\n=== Agenda tras borrar ===");
        agenda.mostrarContactos();

        System.out.println("\n=== equals ===");
        Contacto c1 = new Persona("Ana García", "600111222", "15/03/1990");
        Contacto c2 = new Empresa("Ana García", "900000000", "www.ana.com");
        System.out.println("Persona y Empresa con mismo nombre → " + c1.equals(c2));
    }
}