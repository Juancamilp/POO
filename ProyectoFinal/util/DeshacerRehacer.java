package util;

import estructuras.MiPila;

public class DeshacerRehacer<T> {
    private MiPila<T> pilaDeshacer;
    private MiPila<T> pilaRehacer;

    public DeshacerRehacer() {
        pilaDeshacer = new MiPila<>();
        pilaRehacer = new MiPila<>();
    }

    public void registrarOperacion(T estado) {
        pilaDeshacer.push(estado);
        pilaRehacer = new MiPila<>();
    }

    public T deshacer() {
        if (pilaDeshacer.estaVacia()) {
            System.out.println("Error: PilaDeshacerVaciaException");
            return null;
        }
        T estado = pilaDeshacer.pop();
        pilaRehacer.push(estado);
        return estado;
    }

    public T rehacer() {
        if (pilaRehacer.estaVacia()) {
            System.out.println("Error: PilaRehacerVaciaException");
            return null;
        }
        T estado = pilaRehacer.pop();
        pilaDeshacer.push(estado);
        return estado;
    }
}
