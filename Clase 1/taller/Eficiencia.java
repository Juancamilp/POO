package taller;

public class Eficiencia {

    public static void main(String[] args) {
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double l1 = 5.1, l2 = 6.9, l3 = 4.3;
        double precioLitro = 1.35, p1 = 2.5, p2 = 3.0, p3 = 2.0, deprecPorKm = 0.08;
        double fCO2 = 2.68;

        double costoComb = (l1 + l2 + l3) * precioLitro;
        double deprec = (d1 + d2 + d3) * deprecPorKm;
        double peajes = p1 + p2 + p3;
        double costoDirecto = costoComb + deprec + peajes;
        double costoPorKm = costoDirecto / (d1 + d2 + d3);

        double kmltotal = (d1 + d2 + d3) / (l1 + l2 + l3);
        double COTotal = (l1 + l2 + l3) * fCO2;
        double COporKm = COTotal / (d1 + d2 + d3);

        double v1 = d1 / 0.9, v2 = d2 / 1.4, v3 = d3 / 0.8;
        double vmedia = (v1 + v2 + v3) / 3.0;
        double sigma = Math.sqrt(
                ((v1 - vmedia) * (v1 - vmedia) + (v2 - vmedia) * (v2 - vmedia) + (v3 - vmedia) * (v3 - vmedia)) / 3.0);

        double w1 = 0.25, w2 = 0.25, w3 = 0.25, w4 = 0.25;  
        double score = w1 * (1 / costoPorKm) + w2 * kmltotal + w3 * (1 / COporKm) + w4 * (1 / (1 + sigma));

        System.out.printf("Score=%.4f%n", score);
    }
}