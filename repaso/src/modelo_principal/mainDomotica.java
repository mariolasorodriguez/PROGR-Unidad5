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
        for (DispositivoInteligente dispositivo : catalogo) {
            System.out.println(dispositivo.toString());
        }

        System.out.println("\n### Iniciando pruebas de dispositivos...");
        for (DispositivoInteligente dispositivo : catalogo) {
            System.out.println("\n>>> Probando: " + dispositivo.getNombreComercial());

            dispositivo.encenderDispositivo();

            try {
                if (dispositivo instanceof Altavoz) {
                    Altavoz a = (Altavoz) dispositivo;
                    a.subirNivel();
                    a.subirNivel();
                    System.out.println("Asistente: " + a.getNombreAsistente());

                } else if (dispositivo instanceof Luces) {
                    Luces l = (Luces) dispositivo;
                    l.subirNivel();
                    l.setColor("Azul Neón");
                    System.out.println("Brillo subido y color cambiado.");

                } else if (dispositivo instanceof Termostato) {
                    Termostato t = (Termostato) dispositivo;
                    t.cambiarModoFuncionamiento();
                    t.activarAlerta("Revisión de caldera pendiente");

                } else if (dispositivo instanceof Camara) {
                    Camara c = (Camara) dispositivo;
                    c.iniciarGrabacion();
                    c.activarAlerta("Movimiento detectado en zona norte");
                }
            } catch (DispositivoApagadoException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(dispositivo.toString());
        }

        System.out.println("\n### Apartado D: Forzando error en dispositivo apagado...");
        Altavoz pruebaError = new Altavoz("HomePod mini", "Apple", 99.00, "Siri");

        pruebaError.apagarDispositivo();
        try {
            pruebaError.subirNivel();
        } catch (DispositivoApagadoException e) {
            System.err.println("Captura esperada: " + e.getMessage());
        }

        /* Con arraylist
        public static void main(String[] args) {
        //Declarar tabla y rellenarla con uno de cada tipo
        List<Dispositivo> catalogo = new ArrayList<>();

        catalogo.add(new Altavoz("Echo Dot", "Amazon", 59.99, "Alexa"));
        catalogo.add(new Luz("Hue Bulb", "Philips", 19.50, "Blanco Cálido"));
        catalogo.add(new Termostato("Nest", "Google", 249.00, 21.5));
        catalogo.add(new Camara("Stick Up Cam", "Ring", 99.00, "1080p"));

        //Ordenar la tabla por precio e imprimirla
        Collections.sort(catalogo);
        System.out.println("--- CATÁLOGO ORDENADO POR PRECIO ---");
        for (Dispositivo d : catalogo) {
            System.out.println(d);
        }
        System.out.println();

        //Recorrer la tabla, encender y aplicar acciones específicas
        System.out.println("--- EJECUTANDO ACCIONES ---");
        for (Dispositivo d : catalogo) {
            try {
                d.encender(); // Todos se encienden primero

                // Usamos instanceof para saber qué acciones específicas hacer
                if (d instanceof Altavoz) {
                    Altavoz a = (Altavoz) d;
                    a.subir(); // Subir volumen dos veces
                    a.subir();
                    System.out.println("Asistente del altavoz: " + a.getAsistente());
                }
                else if (d instanceof Luz) {
                    Luz l = (Luz) d;
                    l.subir();
                    l.setColor("Azul");
                }
                else if (d instanceof Termostato) {
                    Termostato t = (Termostato) d;
                    t.cambiarModo("Invierno");
                    t.emitirAlerta("Temperatura baja");
                }
                else if (d instanceof Camara) {
                    Camara c = (Camara) d;
                    c.iniciarGrabacion();
                    c.emitirAlerta("Movimiento detectado");
                }

                System.out.println(d);

            } catch (DispositivoApagadoException e) {
                System.out.println(e.getMessage()); //
            }
        }
        System.out.println();

        // d) Escoge un altavoz, apágalo e intenta subir volumen
        System.out.println("--- PRUEBA DE ERROR (APAGADO) ---");
        Altavoz prueba = new Altavoz("HomePod", "Apple", 349.00, "Siri");
        prueba.apagar();
        try {
            prueba.subir();
        } catch (DispositivoApagadoException e) {
            System.out.println("Captura del error: " + e.getMessage());
        }
    }
         */

    }
}


