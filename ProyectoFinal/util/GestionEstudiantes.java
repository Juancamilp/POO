package util;

import modelo.Estudiante;
import excepciones.EstudianteNoEncontradoException;
import java.util.HashMap;

public class GestionEstudiantes {
    private HashMap<String, Estudiante> estudiantes;

    public GestionEstudiantes() {
        estudiantes = new HashMap<>();
    }

    public void registrarEstudiante(Estudiante e) {
        estudiantes.put(e.getId(), e);
        System.out.println("Estudiante registrado exitosamente.");
    }

    public Estudiante buscarEstudiante(String id) throws EstudianteNoEncontradoException {
        if (!estudiantes.containsKey(id)) {
            throw new EstudianteNoEncontradoException("No existe estudiante con ID: " + id);
        }
        return estudiantes.get(id);
    }

    public void eliminarEstudiante(String id) {
        estudiantes.remove(id);
        System.out.println("Estudiante eliminado.");
    }

    public void listarEstudiantes() {
        for (Estudiante e : estudiantes.values()) {
            e.mostrarInformacion();
        }
    }
}
