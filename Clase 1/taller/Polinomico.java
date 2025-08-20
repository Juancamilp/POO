package taller;

public class Polinomico {
    public static void main(String[] args) {
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double t1 = 0.9, t2 = 1.4, t3 = 0.8;
        double v1 = d1 / t1, v2 = d2 / t2, v3 = d3 / t3;
        double vprom = (d1 * v1 + d2 * v2 + d3 * v3) / (d1 + d2 + d3);

        double a = -0.0008, b = 0.08, c = 4.0;
        double kmlModelo = a * vprom * vprom + b * vprom + c;
        double litrosModelo = (d1 + d2 + d3) / kmlModelo;

        System.out.printf("kmlModelo=%.3f, litrosModelo=%.3f%n", kmlModelo, litrosModelo);
    }
}
