package ejercicio1;

public class MainHora {
    public static void main(String[] args) {
        Hora h = new Hora(3, 59);
        System.out.println(h);
        h.incrementar();
        System.out.println(h);

        HoraExacta he = new HoraExacta(3, 5, 59);
        System.out.println(he);
        he.incrementar();
        System.out.println(he);
    }
}
