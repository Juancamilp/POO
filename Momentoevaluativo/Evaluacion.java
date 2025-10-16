package Momentoevaluativo;
/*
    Universidad Cooperativa de Colombia – Campus Cali
    Ingeniería de Sistemas
    Examen Parcial – Programación Orientada a Objetos

    Autor: Juan [Tu Apellido]
    Docente: Ing. Jhon Haide Cano Beltrán

    ===========================================================
    PARTE I – CONCEPTUAL (10%)
    ===========================================================
    1. ¿Qué es la encapsulación y por qué es importante?
       → La encapsulación es el principio de ocultar los datos internos de una clase
         y permitir el acceso solo mediante métodos públicos (getters y setters).
         Es importante porque protege la información y evita modificaciones indebidas.

    2. ¿Qué diferencia hay entre un método y un constructor?
       → Un constructor se ejecuta automáticamente al crear un objeto
         y sirve para inicializar atributos.
         Un método, en cambio, define un comportamiento y se ejecuta manualmente.

    3. ¿Por qué los atributos deben ser privados y no públicos?
       → Para mantener la integridad de los datos y evitar que otras clases
         los modifiquen directamente sin validaciones.

    4. ¿Qué función cumplen los getters y setters?
       → Permiten leer (get) o modificar (set) los atributos privados
         aplicando validaciones o controles.

    5. Verdadero o falso: “Un método setter no debe validar los datos que recibe.”
       → FALSO. Un setter siempre debe validar los datos antes de asignarlos
         para evitar valores erróneos o inconsistentes.
*/

class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria() {
        this.titular = "Sin nombre";
        this.numeroCuenta = "000000";
        this.saldo = 0;
    }

    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        if (titular != null && !titular.isEmpty()) this.titular = titular;
        else this.titular = "Desconocido";

        if (numeroCuenta != null && numeroCuenta.length() >= 6) this.numeroCuenta = numeroCuenta;
        else this.numeroCuenta = "000000";

        if (saldo >= 0) this.saldo = saldo;
        else this.saldo = 0;
    }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { if (titular != null && !titular.isEmpty()) this.titular = titular; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { if (numeroCuenta != null && numeroCuenta.length() >= 6) this.numeroCuenta = numeroCuenta; }

    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
        else System.out.println("Error: el monto a depositar debe ser positivo.");
    }

    public void retirar(double monto) {
        if (monto > 0 && saldo - monto >= -50) saldo -= monto;
        else System.out.println("Error: saldo insuficiente o monto inválido.");
    }

    @Override
    public String toString() {
        return "Titular: " + titular +
               "\nNúmero de cuenta: " + numeroCuenta +
               "\nSaldo: $" + saldo;
    }

    /*
        Preguntas de sustentación:
        1. ¿Por qué el atributo saldo debe ser privado?
           → Para evitar que se cambie directamente sin control ni validación.
        2. ¿Qué ocurriría si se intenta depositar un valor negativo?
           → No se realiza el depósito y se muestra un mensaje de error.
        3. Modificar para permitir un sobregiro máximo de -50:
           → Ya está implementado en el método retirar (saldo - monto >= -50).
    */
}

class Producto {
    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public Producto() {
        this.codigo = "0000";
        this.descripcion = "Sin descripción";
        this.cantidad = 1;
        this.precioUnitario = 0;
    }

    public Producto(String codigo, String descripcion, int cantidad, double precioUnitario) {
        if (codigo != null && !codigo.isEmpty()) this.codigo = codigo;
        else this.codigo = "0000";

        if (descripcion != null && !descripcion.isEmpty()) this.descripcion = descripcion;
        else this.descripcion = "Sin descripción";

        if (cantidad >= 1) this.cantidad = cantidad;
        else this.cantidad = 1;

        if (precioUnitario >= 0) this.precioUnitario = precioUnitario;
        else this.precioUnitario = 0;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { if (codigo != null && !codigo.isEmpty()) this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { if (descripcion != null && !descripcion.isEmpty()) this.descripcion = descripcion; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { if (cantidad >= 1) this.cantidad = cantidad; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { if (precioUnitario >= 0) this.precioUnitario = precioUnitario; }

    public double calcularSubtotal() { return cantidad * precioUnitario; }

    public double aplicarDescuento(double porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 50) {
            double subtotal = calcularSubtotal();
            double descuento = subtotal * (porcentaje / 100.0);
            return subtotal - descuento;
        } else {
            System.out.println("Error: porcentaje de descuento inválido.");
            return calcularSubtotal();
        }
    }

    public void incrementarCantidad(int valor) {
        if (valor > 0) cantidad += valor;
        else System.out.println("Error: valor de incremento inválido.");
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               "\nDescripción: " + descripcion +
               "\nCantidad: " + cantidad +
               "\nPrecio Unitario: $" + precioUnitario +
               "\nSubtotal: $" + calcularSubtotal();
    }

    /*
        Preguntas de sustentación:
        1. ¿Por qué se valida el porcentaje del descuento?
           → Para evitar descuentos fuera del rango permitido (0–50%).
        2. ¿Qué sucede si el precio unitario es negativo?
           → Se asigna 0 para mantener consistencia y evitar errores de cálculo.
        3. Impuesto del 8%:
           → Se suma al total final así:
              totalConImpuesto = aplicarDescuento(porcentaje) * 1.08;
    */
}

public class Evaluacion {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA: CUENTA BANCARIA ===");
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan Pérez", "123456", 1000);
        cuenta1.depositar(500);
        cuenta1.retirar(200);
        System.out.println(cuenta1.toString());

        System.out.println("\n=== PRUEBA: PRODUCTO ===");
        Producto prod1 = new Producto("A01", "Teclado mecánico", 2, 150000);
        prod1.incrementarCantidad(1);

        double subtotal = prod1.calcularSubtotal();
        double totalConDescuento = prod1.aplicarDescuento(10);
        double totalConImpuesto = totalConDescuento * 1.08;

        System.out.println(prod1.toString());
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Total con descuento: $" + totalConDescuento);
        System.out.println("Total con impuesto (8%): $" + totalConImpuesto);

        /*
            Predicción de resultados:
            - Saldo final: 1000 + 500 - 200 = 1300
            - Subtotal producto: 3 × 150000 = 450000
            - Total con descuento (10%): 405000
            - Total con impuesto (8%): 437400
        */
    }
}
