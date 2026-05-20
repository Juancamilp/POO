package util;

import modelo.Estudiante;
import excepciones.EstudianteNoEncontradoException;

import java.io.BufferedReader;
import java.io.FileReader;

public class ProcesamientoBatch {
    private String rutaArchivo;
    private GestionEstudiantes gestionEstudiantes;
    private GestionMaterias gestionMaterias;
    private int exitosas;
    private int fallidas;

    public ProcesamientoBatch(GestionEstudiantes ge, GestionMaterias gm) {
        this.gestionEstudiantes = ge;
        this.gestionMaterias = gm;
        this.exitosas = 0;
        this.fallidas = 0;
    }

    public void cargarArchivo(String ruta) {
        this.rutaArchivo = ruta;
    }

    public void procesar() throws Exception {
        exitosas = 0;
        fallidas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String encabezado = br.readLine(); // primera línea
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (encabezado.contains("codigo_materia")) {
                    String idEstudiante = datos[0];
                    String codigoMateria = datos[1];
                    try {
                        Estudiante est = gestionEstudiantes.buscarEstudiante(idEstudiante);
                        gestionMaterias.inscribirEstudiante(codigoMateria, est);
                        exitosas++;
                    } catch (Exception ex) {
                        fallidas++;
                    }
                } else if (encabezado.contains("nota")) {
                    String idEstudiante = datos[0];
                    int semestre = Integer.parseInt(datos[1]);
                    int materiaIndice = Integer.parseInt(datos[2]);
                    double nota = Double.parseDouble(datos[3]);
                    try {
                        Estudiante est = gestionEstudiantes.buscarEstudiante(idEstudiante);
                        est.notas[semestre][materiaIndice] = nota;
                        exitosas++;
                    } catch (EstudianteNoEncontradoException ex) {
                        fallidas++;
                    } catch (Exception ex) {
                        fallidas++;
                    }
                }
            }
        }

        System.out.println("=== RESUMEN ===");
        System.out.println("Exitosas: " + exitosas);
        System.out.println("Fallidas: " + fallidas);
    }
}
