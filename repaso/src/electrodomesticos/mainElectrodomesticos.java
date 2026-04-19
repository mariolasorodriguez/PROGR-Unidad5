package electrodomesticos;

import java.util.Arrays;

public class mainElectrodomesticos {
    public static void main(String[] args) {
        Electrodomestico[] hogar = new Electrodomestico[3];

        hogar[0] = new Lavadora("Samsung", "WW90T504DAW", 0.85, 9);
        hogar[1] = new Nevera("LG", "GBB71PZEFN", 1.14, 4.0);
        hogar[2] = new Microondas("Whirlpool", "MWP338SB", 0.90, 900);

        System.out.println("### Electrodomésticos ordenados por consumo:");
        Arrays.sort(hogar);
        for (Electrodomestico e : hogar) {
            System.out.println(e.toString());
        }

        System.out.println("\n### Probando operaciones del hogar...");
        for (Electrodomestico e : hogar) {
            System.out.println("\n>>> " + e.getMarca() + " " + e.getModelo());
            try {
                e.encender();
                System.out.println("Encendido.");

                if (e instanceof Programable) {
                    Programable p = (Programable) e;
                    p.programarCiclo(45);
                    System.out.println("Ciclo programado: 45 minutos.");
                }
                if (e instanceof Reparable) {
                    Reparable r = (Reparable) e;
                    System.out.println("¿Averiado? " + r.isAveriado());
                }
            } catch (DispositivoAveriadoException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(e.toString());
        }

        System.out.println("\n### Forzando error: lavadora averiada...");
        Lavadora rota = new Lavadora("Bosch", "WAX28EH0ES", 0.73, 10);
        rota.registrarAveria("Motor quemado");
        try {
            rota.encender();
        } catch (DispositivoAveriadoException e) {
            System.err.println("Captura esperada: " + e.getMessage());
        }
    }
}