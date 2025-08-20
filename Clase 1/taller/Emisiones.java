package taller;

public class Emisiones {
    public static void main(String[] args) {
        double l1 = 5.1, l2 = 6.9, l3 = 4.3;
        double fCO2 = 2.68;
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;

        double COTotal = (l1 + l2 + l3) * fCO2;
        double COporKm = COTotal / (d1 + d2 + d3);

        System.out.printf("CO2 Total=%.3f kg, CO2 por km=%.3f%n", COTotal, COporKm);
    }
}
