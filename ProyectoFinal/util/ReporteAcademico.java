package util;

import modelo.Estudiante;

public class ReporteAcademico {
    public static void mostrarReporte(Estudiante e) {
        double acumulado = 0;
        int totalMaterias = 0;
        int reprobadas = 0;

        for (int i = 0; i < 10; i++) {
            double suma = 0;
            int materias = 0;
            for (int j = 0; j < 20; j++) {
                if (e.notas[i][j] > 0) {
                    suma += e.notas[i][j];
                    materias++;
                    acumulado += e.notas[i][j];
                    totalMaterias++;
                    if (e.notas[i][j] < 3.0)
                        reprobadas++;
                }
            }
            if (materias > 0) {
                System.out.println("Semestre " + (i + 1) + " Promedio: " + (suma / materias));
            }
        }
        System.out.println("Promedio acumulado: " + (acumulado / totalMaterias));
        System.out.println("Materias reprobadas: " + reprobadas);
    }
}
