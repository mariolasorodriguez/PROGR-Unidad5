package mandos;

import java.util.Arrays;

public class mainMandos {
    public static void main(String[] args) {
        // Array de tamaño 10 con los distintos tipos de mandos
        MandoDistancia[] tienda = new MandoDistancia[10];

        tienda[0] = new MandoTelevision("Samsung TM1240",    5.0, 19.0, 12.99);
        tienda[1] = new MandoMiniCadena("Sony RMT-CE70L",    4.5, 14.0,  9.99);
        tienda[2] = new MandoAspiradora("Roomba RC500",       6.0,  8.0, 24.99);
        tienda[3] = new MandoAireAcondicionado("Daikin ARC433",  4.0, 16.0, 19.99, 22.0);
        tienda[4] = new MandoTelevision("LG AKB75095307",    5.5, 20.0, 14.99);
        tienda[5] = new MandoMiniCadena("Panasonic N2QAYB",  4.0, 13.5,  8.99);
        tienda[6] = new MandoAspiradora("Dyson RC965",        5.5,  9.0, 29.99);
        tienda[7] = new MandoAireAcondicionado("Mitsubishi RH151", 4.2, 15.0, 22.99, 20.0);
        tienda[8] = new MandoTelevision("Philips SRP1003",   4.8, 18.0, 11.99);
        tienda[9] = new MandoMiniCadena("Pioneer AXD7307",   4.3, 14.5, 10.99);

        // Ordenamos el array alfabéticamente por modelo usando compareTo
        System.out.println("### Tienda ordenada alfabéticamente por modelo:");
        Arrays.sort(tienda);
        for (MandoDistancia m : tienda) {
            System.out.println(m.toString());
        }

        System.out.println("\n### Probando operaciones de los mandos...");
        for (MandoDistancia m : tienda) {
            System.out.println("\n>>> " + m.getModelo());

            // 1. Encender el mando
            m.encender();

            // 2-5. Según el tipo, ejecutar las acciones correspondientes
            if (m instanceof MandoTelevision) {
                MandoTelevision tv = (MandoTelevision) m;
                tv.setCanal(5);            // a. Cambiar el canal
                tv.subirNivel();           // b. Subir el volumen
                tv.bajarNivel();           // c. Bajar el volumen
                System.out.println("TV → Canal: " + tv.getCanal() + " | Volumen: " + tv.getVolumen());

            } else if (m instanceof MandoMiniCadena) {
                MandoMiniCadena mc = (MandoMiniCadena) m;
                mc.subirNivel();           // a. Subir el volumen
                mc.bajarNivel();           // b. Bajar el volumen
                System.out.println("MiniCadena → Volumen: " + mc.getVolumen());

            } else if (m instanceof MandoAspiradora) {
                MandoAspiradora asp = (MandoAspiradora) m;
                asp.subirNivel();          // a. Subir velocidad
                asp.bajarNivel();          // b. Bajar velocidad
                System.out.println("Aspiradora → Velocidad: " + asp.getVelocidad());

            } else if (m instanceof MandoAireAcondicionado) {
                MandoAireAcondicionado aire = (MandoAireAcondicionado) m;
                aire.cambiarModo();        // a. Cambiar el modo
                aire.setTemperatura(24.0); // b. Cambiar la temperatura
                aire.subirNivel();         // c. Subir velocidad
                aire.bajarNivel();         // d. Bajar velocidad
                System.out.println("Aire → Modo: " + aire.getModo()
                        + " | Temp: " + aire.getTemperatura() + "°C"
                        + " | Vel: " + aire.getVelocidad());
            }

            System.out.println(m.toString());
        }
    }
}