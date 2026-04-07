package ejercicio5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner reader = new Scanner(System.in);
    static ArrayList<Poligono> lista = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = Integer.parseInt(reader.nextLine());

            switch (opcion) {
                case 1:
                    introducirTriangulo();
                    break;
                case 2:
                    introducirRectangulo();
                    break;
                case 3:
                    mostrarPoligonos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        reader.close();
    }

    static void mostrarMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1. Introducir triángulo");
        System.out.println("2. Introducir rectángulo");
        System.out.println("3. Mostrar polígonos");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    static void introducirTriangulo() {
        System.out.print("Introduce el lado 1: ");
        double lado1 = Double.parseDouble(reader.nextLine());

        System.out.print("Introduce el lado 2: ");
        double lado2 = Double.parseDouble(reader.nextLine());

        System.out.print("Introduce el lado 3: ");
        double lado3 = Double.parseDouble(reader.nextLine());

        Triangulo t = new Triangulo(lado1, lado2, lado3);
        lista.add(t);
        System.out.println("Triángulo añadido correctamente.");
    }

    static void introducirRectangulo() {
        System.out.print("Introduce la base: ");
        double base = Double.parseDouble(reader.nextLine());

        System.out.print("Introduce la altura: ");
        double altura = Double.parseDouble(reader.nextLine());

        Rectangulo r = new Rectangulo(base, altura);
        lista.add(r);
        System.out.println("Rectángulo añadido correctamente.");
    }

    static void mostrarPoligonos() {
        if (lista.isEmpty()) {
            System.out.println("No hay polígonos almacenados.");
            return;
        }

        System.out.println("\n--- POLÍGONOS ALMACENADOS ---");
        for (int i = 0; i < lista.size(); i++) {
            Poligono p = lista.get(i);
            System.out.println((i + 1) + ". " + p.toString()
                    + " | Área: " + String.format("%.2f", p.area()));
        }
    }
}