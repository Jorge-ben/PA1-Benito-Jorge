/**
 * Clase del dominio: representa un producto de la microempresa.
 * Temas usados (sesiones 1-4): atributos de instancia y de clase,
 * constructores, metodos con y sin retorno, estructuras selectivas.
 */
public class Producto {

    // Atributo de clase (constante compartida por todos los objetos)
    public static final int STOCK_MINIMO = 5;

    // Atributo de clase (contador compartido)
    private static int totalProductosCreados = 0;

    // Atributos de instancia
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor por defecto: reutiliza el constructor completo con this(...)
    public Producto() {
        this("SIN-CODIGO", "Sin nombre", 0.0, 0);
    }

    // Constructor con parametros
    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        totalProductosCreados++;
    }

    // ---------- Getters ----------
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public static int getTotalProductosCreados() { return totalProductosCreados; }

    // ---------- Metodos que NO devuelven valor ----------
    public void mostrarInformacion() {
        System.out.println("--------------------------------");
        System.out.println("Codigo : " + codigo);
        System.out.println("Nombre : " + nombre);
        System.out.printf("Precio : S/ %.2f%n", precio);
        System.out.println("Stock  : " + stock + " unidades");
        System.out.println("Estado : " + obtenerEstadoStock());
        System.out.printf("Valor en inventario: S/ %.2f%n", calcularValorInventario());
        System.out.println("--------------------------------");
    }

    // ---------- Metodos que SI devuelven valor ----------
    public double calcularValorInventario() {
        return precio * stock;
    }

    public boolean hayStockSuficiente(int cantidad) {
        return cantidad > 0 && cantidad <= stock;
    }

    public double calcularPrecioConDescuento(double porcentaje) {
        return precio - (precio * porcentaje / 100);
    }

    public String obtenerEstadoStock() {
        String estado;
        if (stock == 0) {
            estado = "SIN STOCK";
        } else if (stock < STOCK_MINIMO) {
            estado = "STOCK BAJO (reponer pronto)";
        } else {
            estado = "STOCK NORMAL";
        }
        return estado;
    }

    /** Descuenta stock si es posible. Devuelve true si la venta se realizo. */
    public boolean vender(int cantidad) {
        if (hayStockSuficiente(cantidad)) {
            stock -= cantidad;
            return true;
        }
        return false;
    }

    /** Aumenta stock. Devuelve true si la cantidad era valida. */
    public boolean reponer(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
            return true;
        }
        return false;
    }
}
