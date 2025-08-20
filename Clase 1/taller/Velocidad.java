package taller;

public class Velocidad {
    public static void main(String[] args) {
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double t1 = 0.9, t2 = 1.4, t3 = 0.8;
        double l1 = 5.1, l2 = 6.9, l3 = 4.3;

        double v1 = d1 / t1, v2 = d2 / t2, v3 = d3 / t3;
        double vprom = (d1 * v1 + d2 * v2 + d3 * v3) / (d1 + d2 + d3);

        double kml1 = d1 / l1, kml2 = d2 / l2, kml3 = d3 / l3;
        double kmltotal = (d1 + d2 + d3) / (l1 + l2 + l3);

        System.out.printf("v1=%.2f, v2=%.2f, v3=%.2f, vprom=%.2f%n", v1, v2, v3, vprom);
        System.out.printf("kml1=%.2f, kml2=%.2f, kml3=%.2f, kmltotal=%.3f%n", kml1, kml2, kml3, kmltotal);
    }
}