package util;

public class HorarioAula {
    private boolean[][] horarios;

    public HorarioAula() {
        horarios = new boolean[7][24];
    }

    public void reservar(int dia, int horaInicio, int duracion) throws Exception {
        if (dia < 0 || dia >= 7) {
            throw new Exception("Día inválido.");
        }
        if (horaInicio < 0 || horaInicio >= 24) {
            throw new Exception("Hora inválida.");
        }
        if (horaInicio + duracion > 24) {
            throw new Exception("La duración excede el rango de horas disponibles.");
        }

        for (int h = horaInicio; h < horaInicio + duracion; h++) {
            if (horarios[dia][h]) {
                throw new Exception("El horario ya está ocupado.");
            }
        }

        for (int h = horaInicio; h < horaInicio + duracion; h++) {
            horarios[dia][h] = true;
        }
    }

    public void liberar(int dia, int horaInicio, int duracion) throws Exception {
        if (dia < 0 || dia >= 7 || horaInicio < 0 || horaInicio >= 24 || horaInicio + duracion > 24) {
            throw new Exception("Parámetros inválidos.");
        }

        for (int h = horaInicio; h < horaInicio + duracion; h++) {
            horarios[dia][h] = false;
        }
    }

    public boolean consultarDisponibilidad(int dia, int hora) {
        if (dia < 0 || dia >= 7 || hora < 0 || hora >= 24) {
            return false;
        }
        return !horarios[dia][hora];
    }
}
