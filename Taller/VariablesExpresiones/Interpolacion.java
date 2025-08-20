package VariablesExpresiones;

public class Interpolacion {
    public static void main(String[] args) {
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double t1 = 0.9, t2 = 1.4, t3 = 0.8;
        double v1 = d1 / t1, v2 = d2 / t2, v3 = d3 / t3;
        double vprom = (d1 * v1 + d2 * v2 + d3 * v3) / (d1 + d2 + d3);

        double va = 40, vb = 80, ca = 0.05, cb = 0.09;
        double c_vprom = ca + (cb - ca) * (vprom - va) / (vb - va);
        double costoMant = c_vprom * (d1 + d2 + d3);

        System.out.printf("c(vprom)=%.5f, costoMant=%.3f%n", c_vprom, costoMant);
    }
}
