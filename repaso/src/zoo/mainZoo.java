package zoo;

import java.util.Arrays;

public class mainZoo {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[3];

        zoo[0] = new Leon("Simba", 5, 190.0, "Sabana africana");
        zoo[1] = new Perro("Rex", 3, 30.0, "Pastor Alemán");
        zoo[2] = new Aguila("Zeus", 8, 6.5, 2.1);

        System.out.println("### Animales ordenados por edad:");
        Arrays.sort(zoo);
        for (Animal a : zoo) {
            System.out.println(a.toString());
        }

        System.out.println("\n### Probando operaciones del zoo...");
        for (Animal a : zoo) {
            System.out.println("\n>>> " + a.getNombre());
            try {
                if (a instanceof Vacunable) {
                    Vacunable v = (Vacunable) a;
                    if (v.necesitaVacuna()) {
                        v.vacunar("Rabia + Moquillo");
                        System.out.println("Vacuna aplicada.");
                    }
                }
                if (a instanceof Domesticable) {
                    Domesticable d = (Domesticable) a;
                    d.domesticar("Carlos Pérez");
                    System.out.println("Domesticado por: Carlos Pérez");
                }
            } catch (AnimalNoDisponibleException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(a.toString());
        }

        System.out.println("\n### Forzando error: animal en cuarentena...");
        Perro enCuarentena = new Perro("Bobby", 2, 15.0, "Labrador");
        enCuarentena.ponerEnCuarentena();
        try {
            enCuarentena.vacunar("Parvovirus");
        } catch (AnimalNoDisponibleException e) {
            System.err.println("Captura esperada: " + e.getMessage());
        }
    }
}