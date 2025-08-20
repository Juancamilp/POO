package taller;

public class Volumen {
    public static void main(String[] args) {
        double masaCargaKg = 1200;
        double largo = 2.0, ancho = 1.2, alto = 1.1;
        double volCamionM3 = 10.0;

        double volumenM3 = largo * ancho * alto;
        double densidad = masaCargaKg / volumenM3;
        double ocupacion = volumenM3 / volCamionM3;

        System.out.printf("Volumen=%.3f m3, Densidad=%.2f kg/m3, Ocupacion=%.3f%n",
                volumenM3, densidad, ocupacion);
    }
}
