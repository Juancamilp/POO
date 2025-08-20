package VariablesExpresiones;

public class Viaje {
    public static void main(String[] args) {
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double t1 = 0.9, t2 = 1.4, t3 = 0.8;
        double l1 = 5.1, l2 = 6.9, l3 = 4.3;
        double precioLitro = 1.35;
        double masaCargaKg = 1200;
        double largo = 2.0, ancho = 1.2, alto = 1.1;
        double p1 = 2.5, p2 = 3.0, p3 = 2.0;
        double deprecPorKm = 0.08, volCamionM3 = 10.0;
        double fCO2 = 2.68, galPorLitro = 0.264172;
        double vmin = 30.0, vmax = 90.0;
        double va = 40.0, vb = 80.0, ca = 0.05, cb = 0.09;
        double a = -0.0008, b = 0.08, c = 4.0;

        System.out.println("== Datos base del viaje ==");
        System.out.printf("Distancias (km): d1=%.1f, d2=%.1f, d3=%.1f, total=%.1f%n",
                d1, d2, d3, (d1 + d2 + d3));
        System.out.printf("Tiempos (h): t1=%.1f, t2=%.1f, t3=%.1f, total=%.1f%n",
                t1, t2, t3, (t1 + t2 + t3));
        System.out.printf("Combustible (L): l1=%.1f, l2=%.1f, l3=%.1f, total=%.1f%n",
                l1, l2, l3, (l1 + l2 + l3));

        System.out.printf("Precio por litro: %.2f%n", precioLitro);
        System.out.printf("Carga: masa=%.0f kg, dimensiones=%.1f x %.1f x %.1f m (vol=%.3f m3)%n",
                masaCargaKg, largo, ancho, alto, (largo * ancho * alto));

        System.out.printf("Peajes: p1=%.1f, p2=%.1f, p3=%.1f, total=%.1f%n",
                p1, p2, p3, (p1 + p2 + p3));
        System.out.printf("Depreciacion por km: %.3f%n", deprecPorKm);
        System.out.printf("Volumen util del camion: %.1f m3%n", volCamionM3);

        System.out.printf("Factor CO2 (kg/L): %.2f%n", fCO2);
        System.out.printf("galPorLitro: %.6f%n", galPorLitro);

        System.out.printf("Rango normalizacion velocidad: vmin=%.0f, vmax=%.0f%n", vmin, vmax);
        System.out.printf("Interpolacion mantenimiento: (va=%.0f, ca=%.2f) a (vb=%.0f, cb=%.2f)%n",
                va, ca, vb, cb);
        System.out.printf("Modelo polinomico kml(v)=a*v^2 + b*v + c con a=%.7f, b=%.2f, c=%.1f%n",
                a, b, c);
    }
}