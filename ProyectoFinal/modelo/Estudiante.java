package modelo;

import java.util.ArrayList;

public class Estudiante {
    private String id;
    private String nombre;
    public double[][] notas;
    private ArrayList<String> historialMateriales;

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.notas = new double[10][20];
        this.historialMateriales = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInformacion() {
        System.out.println("Estudiante: " + nombre + " (ID: " + id + ")");
    }

    public void agregarMaterialAlHistorial(String material) {
        historialMateriales.add(material);
    }

    public double calcularPromedio() {
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] > 0) {
                    suma += notas[i][j];
                    contador++;
                }
            }
        }
        return contador > 0 ? suma / contador : 0;
    }

    public int contarAprobadas() {
        int aprobadas = 0;
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] >= 3.0) {
                    aprobadas++;
                }
            }
        }
        return aprobadas;
    }

    public int contarReprobadas() {
        int reprobadas = 0;
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] > 0 && notas[i][j] < 3.0) {
                    reprobadas++;
                }
            }
        }
        return reprobadas;
    }

    public void mostrarHistorial() {
        System.out.println("Historial académico de " + nombre + " (" + id + "):");
        boolean tieneNotas = false;
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] > 0) {
                    System.out.println("Semestre " + i + ", Materia " + j + ": " + notas[i][j]);
                    tieneNotas = true;
                }
            }
        }
        if (!tieneNotas) {
            System.out.println("No hay notas registradas.");
        }

        if (!historialMateriales.isEmpty()) {
            System.out.println("Materiales utilizados:");
            for (String m : historialMateriales) {
                System.out.println("- " + m);
            }
        } else {
            System.out.println("No hay materiales registrados.");
        }
    }
}
