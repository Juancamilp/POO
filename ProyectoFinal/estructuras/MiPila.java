package estructuras;

import java.util.Stack;

public class MiPila<T> {
    private Stack<T> pila;

    public MiPila() {
        pila = new Stack<>();
    }

    public void push(T elemento) {
        pila.push(elemento);
    }

    public T pop() {
        if (pila.isEmpty()) {
            return null;
        }
        return pila.pop();
    }

    public boolean estaVacia() {
        return pila.isEmpty();
    }
}
