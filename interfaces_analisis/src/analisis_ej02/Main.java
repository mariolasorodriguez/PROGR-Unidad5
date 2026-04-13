package analisis_ej02;

public class Main {

    public static void main(String[] args) {

        Ficha[] fichas = {
                new Libro  (1, "El Quijote",          "Cervantes",      "Planeta"),
                new Revista(2, "HOLA", 245,              2024),
                new DVD    (3, "Torrente Presidente",          "Santiago Segura", 2026, TipoDVD.PELICULA)
        };

        System.out.println("=== Fichas de la biblioteca ===\n");
        for (Ficha ficha : fichas) {
            System.out.println(ficha);
            System.out.println("Días de préstamo: " + ficha.prestar() + " días\n");
        }
    }
}
