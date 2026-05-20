package util;

import java.util.HashMap;
import java.util.ArrayList;
import modelo.Estudiante;

public class GestionMaterias {
    private HashMap<String, String> materias;
    private HashMap<String, ArrayList<Estudiante>> inscripciones;

    public GestionMaterias() {
        materias = new HashMap<>();
        inscripciones = new HashMap<>();
    }

    public void registrarMateria(String codigo, String nombre) {
        materias.put(codigo, nombre);
        inscripciones.put(codigo, new ArrayList<>());
    }

    public void inscribirEstudiante(String codigo, Estudiante est) {
        if (inscripciones.containsKey(codigo)) {
            inscripciones.get(codigo).add(est);
        } else {
            System.out.println("Materia no encontrada.");
        }
    }
}
