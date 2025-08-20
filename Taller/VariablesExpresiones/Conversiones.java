package VariablesExpresiones;

public class Conversiones {
    public static void main(String[] args) {
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double t1 = 0.9, t2 = 1.4, t3 = 0.8;
        double v1 = d1 / t1, v2 = d2 / t2, v3 = d3 / t3;
        double vprom = (d1 * v1 + d2 * v2 + d3 * v3) / (d1 + d2 + d3);

        double galPorLitro = 0.264172;
        double l1 = 5.1, l2 = 6.9, l3 = 4.3;
        double vmin = 30, vmax = 90;

        double vprom_m_s = vprom * 1000 / 3600;
        double galTot = (l1 + l2 + l3) * galPorLitro;
        double vnorm = (vprom - vmin) / (vmax - vmin);

        System.out.printf("vprom=%.2f km/h (%.3f m/s), galTot=%.4f, vnorm=%.3f%n",
                vprom, vprom_m_s, galTot, vnorm);
    }
}
