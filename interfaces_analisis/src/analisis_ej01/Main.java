package analisis_ej01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Turismo turismo = new Turismo("Seat", "Ibiza", "Rojo", "8738DHC", 5, TipoUso.PARTICULAR);

        System.out.println("=== Estado inicial ===");
        System.out.println(turismo);

        System.out.println("\n=== Arrancando ===");
        turismo.arrancar();

        System.out.print("\nIntroduce la velocidad objetivo (km/h): ");
        int velocidadObjetivo = scanner.nextInt();

        System.out.println("\n=== Acelerando ===");
        while (turismo.getVelocidadActual() < velocidadObjetivo) {
            turismo.setVelocidadActual(turismo.getVelocidadActual() + 10);
            if (turismo.getVelocidadActual() > velocidadObjetivo) {
                turismo.setVelocidadActual(velocidadObjetivo);
            }
            int marchaRecomendada = turismo.marchaRecomendada();
            while (turismo.getMarchaActual() < marchaRecomendada) {
                turismo.subirMarcha();
            }
            System.out.println("Velocidad: " + turismo.getVelocidadActual() + " km/h | Marcha: " + turismo.getMarchaActual() + "ª");
        }

        System.out.print("\nIntroduce el tiempo que mantener la velocidad (segundos): ");
        int tiempo = scanner.nextInt();
        System.out.println("\n=== Manteniendo " + velocidadObjetivo + " km/h durante " + tiempo + " segundos ===");
        try {
            Thread.sleep(tiempo * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Tiempo transcurrido.");

        System.out.println("\n=== Desacelerando ===");
        while (turismo.getVelocidadActual() > 0) {
            turismo.setVelocidadActual(Math.max(0, turismo.getVelocidadActual() - 10));
            int marchaRecomendada = turismo.getVelocidadActual() == 0 ? 1 : turismo.marchaRecomendada();
            while (turismo.getMarchaActual() > marchaRecomendada) {
                turismo.bajarMarcha();
            }
            System.out.println("Velocidad: " + turismo.getVelocidadActual() + " km/h | Marcha: " + turismo.getMarchaActual() + "ª");
        }

        System.out.println("\n=== Punto muerto y apagando motor ===");
        turismo.bajarMarcha();
        turismo.parar();

        System.out.println("\n=== Estado final ===");
        System.out.println(turismo);

        scanner.close();
    }
}