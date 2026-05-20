package main;

import java.util.Scanner;
import modelo.Estudiante;
import util.GestionEstudiantes;
import util.GestionMaterias;
import util.HorarioAula;
import util.ProcesamientoBatch;
import excepciones.EstudianteNoEncontradoException;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionEstudiantes gestionEstudiantes = new GestionEstudiantes();
        GestionMaterias gestionMaterias = new GestionMaterias();
        HorarioAula horario = new HorarioAula();
        ProcesamientoBatch batch = new ProcesamientoBatch(gestionEstudiantes, gestionMaterias);

        int opcion;
        do {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar materia");
            System.out.println("3. Inscribir estudiante en materia");
            System.out.println("4. Registrar nota");
            System.out.println("5. Reservar horario");
            System.out.println("6. Liberar horario");
            System.out.println("7. Consultar disponibilidad");
            System.out.println("8. Reporte académico");
            System.out.println("9. Procesar archivo CSV");
            System.out.println("10. Ver información de estudiante");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: //
                    System.out.print("ID estudiante: ");
                    String idEst = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    gestionEstudiantes.registrarEstudiante(new Estudiante(idEst, nombre));
                    System.out.println("Estudiante registrado.");
                    break;

                case 2:
                    System.out.print("Código materia: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombre materia: ");
                    String nombreMat = sc.nextLine();
                    gestionMaterias.registrarMateria(codigo, nombreMat);
                    System.out.println("Materia registrada.");
                    break;

                case 3:
                    System.out.print("ID estudiante: ");
                    idEst = sc.nextLine();
                    System.out.print("Código materia: ");
                    codigo = sc.nextLine();
                    try {
                        Estudiante est = gestionEstudiantes.buscarEstudiante(idEst);
                        gestionMaterias.inscribirEstudiante(codigo, est);
                        System.out.println("Inscripción realizada.");
                    } catch (EstudianteNoEncontradoException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("ID estudiante: ");
                    idEst = sc.nextLine();
                    try {
                        Estudiante est = gestionEstudiantes.buscarEstudiante(idEst);
                        System.out.print("Semestre (0-9): ");
                        int semestre = sc.nextInt();
                        System.out.print("Materia índice (0-19): ");
                        int indice = sc.nextInt();
                        System.out.print("Nota: ");
                        double nota = sc.nextDouble();
                        sc.nextLine();
                        est.notas[semestre][indice] = nota;
                        System.out.println("Nota registrada.");
                    } catch (EstudianteNoEncontradoException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Día (0=Domingo..6=Sábado): ");
                        int dia = sc.nextInt();
                        System.out.print("Hora inicio: ");
                        int hora = sc.nextInt();
                        System.out.print("Duración: ");
                        int duracion = sc.nextInt();
                        sc.nextLine();
                        horario.reservar(dia, hora, duracion);
                        System.out.println("Horario reservado correctamente.");
                    } catch (Exception ex) {
                        System.out.println("Error al reservar horario: " + ex.getMessage());
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Día: ");
                        int dia = sc.nextInt();
                        System.out.print("Hora inicio: ");
                        int hora = sc.nextInt();
                        System.out.print("Duración: ");
                        int duracion = sc.nextInt();
                        sc.nextLine();
                        horario.liberar(dia, hora, duracion);
                        System.out.println("Horario liberado correctamente.");
                    } catch (Exception ex) {
                        System.out.println("Error al liberar horario: " + ex.getMessage());
                    }
                    break;

                case 7:
                    System.out.print("Día: ");
                    int dia = sc.nextInt();
                    System.out.print("Hora: ");
                    int hora = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Disponible: " + horario.consultarDisponibilidad(dia, hora));
                    break;

                case 8:
                    System.out.print("ID estudiante: ");
                    idEst = sc.nextLine();
                    try {
                        Estudiante est = gestionEstudiantes.buscarEstudiante(idEst);
                        System.out.println("=== REPORTE ACADÉMICO ===");
                        System.out.println("Promedio: " + est.calcularPromedio());
                        System.out.println("Materias aprobadas: " + est.contarAprobadas());
                        System.out.println("Materias reprobadas: " + est.contarReprobadas());
                        est.mostrarHistorial();
                    } catch (EstudianteNoEncontradoException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 9:
                    try {
                        System.out.print("Ruta archivo CSV: ");
                        String ruta = sc.nextLine();
                        batch.cargarArchivo(ruta);
                        batch.procesar();
                        System.out.println("Archivo procesado correctamente.");
                    } catch (Exception ex) {
                        System.out.println("Error al procesar archivo: " + ex.getMessage());
                    }
                    break;

                case 10:
                    System.out.print("ID estudiante: ");
                    idEst = sc.nextLine();
                    try {
                        Estudiante est = gestionEstudiantes.buscarEstudiante(idEst);
                        est.mostrarInformacion();
                        est.mostrarHistorial();
                    } catch (EstudianteNoEncontradoException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case 11:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 11);

        sc.close();
    }
}