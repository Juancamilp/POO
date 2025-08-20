package taller;

public class CostosDirectos {
    public static void main(String[] args) {
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double l1 = 5.1, l2 = 6.9, l3 = 4.3;
        double precioLitro = 1.35;
        double p1 = 2.5, p2 = 3.0, p3 = 2.0;
        double deprecPorKm = 0.08;

        double costoComb = (l1 + l2 + l3) * precioLitro;
        double deprec = (d1 + d2 + d3) * deprecPorKm;
        double peajes = p1 + p2 + p3;
        double costoDirecto = costoComb + deprec + peajes;
        double costoPorKm = costoDirecto / (d1 + d2 + d3);

        System.out.printf("Comb=%.2f, Dep=%.2f, Peajes=%.2f, Directo=%.3f, /km=%.3f%n",
                costoComb, deprec, peajes, costoDirecto, costoPorKm);
    }
}