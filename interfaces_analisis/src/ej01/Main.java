package ej01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Socio s1 = new Socio(10, "Ana",   30);
        Socio s2 = new Socio(3,  "Luis",  25);
        Socio s3 = new Socio(7,  "Marta", 40);

        System.out.println("=== compareTo ===");
        System.out.println("s1.compareTo(s2) > 0 → " + (s1.compareTo(s2) > 0));
        System.out.println("s2.compareTo(s1) < 0 → " + (s2.compareTo(s1) < 0));
        System.out.println("s1.compareTo(s1) = 0 → " + (s1.compareTo(s1) == 0));

        Socio[] socios = { s1, s2, s3 };

        System.out.println("\n=== Array antes de ordenar ===");
        Arrays.stream(socios).forEach(System.out::println);

        Arrays.sort(socios);

        System.out.println("\n=== Array despues de ordenar ===");
        Arrays.stream(socios).forEach(System.out::println);
    }
}
