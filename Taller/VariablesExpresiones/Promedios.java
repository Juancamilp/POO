package VariablesExpresiones;

public class Promedios {
    public static void main(String[] args) {
        double d1 = 42.0, d2 = 58.5, d3 = 37.2;
        double t1 = 0.9, t2 = 1.4, t3 = 0.8;
        double v1 = d1 / t1, v2 = d2 / t2, v3 = d3 / t3;

        double vmedia = (v1 + v2 + v3) / 3.0;
        double sigma = Math.sqrt(
                ((v1 - vmedia) * (v1 - vmedia) + (v2 - vmedia) * (v2 - vmedia) + (v3 - vmedia) * (v3 - vmedia)) / 3.0);
        double vpond_t = (t1 * v1 + t2 * v2 + t3 * v3) / (t1 + t2 + t3);

        System.out.printf("vmedia=%.3f, sigma=%.3f, vpond_t=%.3f%n", vmedia, sigma, vpond_t);
    }
}
