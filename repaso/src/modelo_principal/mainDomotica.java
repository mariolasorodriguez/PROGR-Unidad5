package modelo_principal;

import modelo_domotica.*;

import java.util.Arrays;

public class mainDomotica {
    public static void main(String[] args) {
        DispositivoInteligente[] catalogo = new DispositivoInteligente[4];

        catalogo[0] = new Altavoz("Echo Dot", "Amazon", 59.90, "Alexa");
        catalogo[1] = new Luces("Hue White", "Philips", 29.50, "Blanco Cálido");
        catalogo[2] = new Termostato("Nest Learning", "Google", 249.00, 21.5);
        catalogo[3] = new Camara("Arlo Pro 4", "Arlo", 199.99, "2K HDR");

        System.out.println("### Catálogo ordenado por precio:");
        Arrays.sort(catalogo);
        for (DispositivoInteligente d : catalogo) {
            System.out.println(d.toString());
        }

        System.out.println("\n### Iniciando pruebas de dispositivos...");
        for (DispositivoInteligente d : catalogo) {
            System.out.println("\n>>> Probando: " + d.getNombreComercial());

            d.encenderDispositivo();

            try {
                if (d instanceof Altavoz) {
                    Altavoz a = (Altavoz) d;
                    a.subirNivel();
                    a.subirNivel();
                    System.out.println("Asistente: " + a.getNombreAsistente());

                } else if (d instanceof Luces) {
                    Luces l = (Luces) d;
                    l.subirNivel();
                    l.setColor("Azul Neón");
                    System.out.println("Brillo subido y color cambiado.");

                } else if (d instanceof Termostato) {
                    Termostato t = (Termostato) d;
                    t.cambiarModoFuncionamiento();
                    t.activarAlerta("Revisión de caldera pendiente");

                } else if (d instanceof Camara) {
                    Camara c = (Camara) d;
                    c.iniciarGrabacion();
                    c.activarAlerta("Movimiento detectado en zona norte");
                }
            } catch (DispositivoApagadoException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(d.toString());
        }

        System.out.println("\n### Apartado D: Forzando error en dispositivo apagado...");
        Altavoz pruebaError = new Altavoz("HomePod mini", "Apple", 99.00, "Siri");

        pruebaError.apagarDispositivo();
        try {
            pruebaError.subirNivel();
        } catch (DispositivoApagadoException e) {
            System.err.println("Captura esperada: " + e.getMessage());
        }

    }
}


