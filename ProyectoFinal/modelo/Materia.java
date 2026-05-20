package modelo;

import java.util.ArrayList;

public class Materia {
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> inscritos;

    public Materia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.inscritos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void inscribirEstudiante(Estudiante est) {
        inscritos.add(est);
        est.agregarMaterialAlHistorial("Inscrito en materia: " + nombre + " (" + codigo + ")");
    }

    public void mostrarInscritos() {
        if (inscritos.isEmpty()) {
            System.out.println("No hay estudiantes inscritos en " + nombre);
        } else {
            System.out.println("Estudiantes inscritos en " + nombre + ":");
            for (Estudiante e : inscritos) {
                System.out.println("- " + e.getNombre() + " (ID: " + e.getId() + ")");
            }
        }
    }
}
