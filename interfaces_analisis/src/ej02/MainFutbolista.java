package ej02;

import java.util.Arrays;

public class MainFutbolista {

    public static void main(String[] args) {

        Futbolista[] futbolistas = {
                new Futbolista(10, "Messi",    36, 50),
                new Futbolista(7,  "Ronaldo",  38, 48),
                new Futbolista(9,  "Benzema",  35, 30),
                new Futbolista(7,  "Fali",   25, 40),
                new Futbolista(11, "Neymar",   31, 25)
        };

        System.out.println("=== equals ===");
        Futbolista a = new Futbolista(7, "Ronaldo", 38, 48);
        Futbolista b = new Futbolista(7, "Ronaldo", 99,  0);
        Futbolista c = new Futbolista(7, "Fali",  25, 40);
        System.out.println("Ronaldo == Ronaldo (distinta edad/goles) → " + a.equals(b));
        System.out.println("Ronaldo == Fali (misma camiseta)      → " + a.equals(c));

        System.out.println("\n=== Tabla antes de ordenar ===");
        Arrays.stream(futbolistas).forEach(System.out::println);

        Arrays.sort(futbolistas);

        System.out.println("\n=== Tabla despues de ordenar ===");
        Arrays.stream(futbolistas).forEach(System.out::println);
    }
}