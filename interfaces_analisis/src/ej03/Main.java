package ej03;

public class Main {

    public static void main(String[] args) {

        Perro perro = new Perro("Rex","Pastor Aleman",30.5, "Marrón");
        Gato gato = new Gato("Sepecito","Siamés",4.5, "Blanco" );

        mostrarPerro(perro);
        mostrarGato(gato);

        demostrarPolimorfismoVivir(new Vivir[] {perro, gato});
        demostrarPolimorfismoAnimalDomestico(new AnimalDomestico[] {perro, gato});
    }

    private  static void mostrarPerro(Perro perro) {
        System.out.println("=== PERRO ===");
        System.out.println(perro);
        perro.comer();
        perro.dormir();
        perro.hacerRuido();
        imprimirObediencia(perro.getNombre(), perro.hacerCaso());
        perro.vacunar();
        perro.sacaPaseo();
        System.out.println();
    }

    private  static void mostrarGato(Gato gato) {
        System.out.println("=== GATO ===");
        System.out.println(gato);
        gato.comer();
        gato.dormir();
        gato.hacerRuido();
        imprimirObediencia(gato.getNombre(), gato.hacerCaso());
        gato.vacunar();
        gato.toserBolaPelo();
        System.out.println();
    }

    private static void imprimirObediencia(String nombre, boolean obedece) {
        System.out.println(nombre + (obedece ? " hace caso" : " no hace caso"));
    }

    private static void demostrarPolimorfismoVivir(Vivir[] animales) {
        System.out.println("=== POLIMORFISMO Vivir[] ===");
        for  (Vivir animal : animales) {
            animal.hacerRuido();
        }
        System.out.println();
    }

    private static void demostrarPolimorfismoAnimalDomestico(AnimalDomestico[] animales) {
        System.out.println("=== POLIMORFISMO AnimalDomestico[] ===");
        for  (AnimalDomestico animal : animales) {
            imprimirObediencia(animal.getNombre(), animal.hacerCaso());
        }
        System.out.println();
    }
}
