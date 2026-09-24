import java.util.Locale;
import java.util.Scanner;

/**
 * Clase ejecutora: menu por consola para registrar y controlar un producto.
 * Temas usados: do-while (menu), switch, if/if-else anidados,
 * while (validacion de datos), for (simulacion de descuentos),
 * contadores y acumuladores.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // permite escribir decimales con punto (12.50)

        Producto productoActual = null;

        // Contadores y acumuladores de la sesion
        int productosRegistrados = 0;
        int ventasRealizadas = 0;
        int unidadesVendidas = 0;
        double montoTotalVendido = 0;
        int opcion;

        System.out.println("=== SISTEMA BASICO DE CONTROL DE PRODUCTOS ===");

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Elija una opcion: ", 0);

            switch (opcion) {
                case 1:
                    String codigo = leerTexto(sc, "Codigo del producto: ");
                    String nombre = leerTexto(sc, "Nombre del producto: ");
                    double precio = leerDecimal(sc, "Precio unitario (S/): ", 0.01);
                    int stock = leerEntero(sc, "Stock inicial: ", 0);
                    productoActual = new Producto(codigo, nombre, precio, stock);
                    productosRegistrados++;
                    System.out.println(">> Producto registrado correctamente.");
                    break;

                case 2:
                    if (productoActual == null) {
                        System.out.println(">> Primero debe registrar un producto (opcion 1).");
                    } else {
                        productoActual.mostrarInformacion();
                    }
                    break;

                case 3:
                    if (productoActual == null) {
                        System.out.println(">> Primero debe registrar un producto (opcion 1).");
                    } else {
                        int cantidadVenta = leerEntero(sc, "Cantidad a vender: ", 1);
                        if (productoActual.vender(cantidadVenta)) {
                            double subtotal = cantidadVenta * productoActual.getPrecio();
                            ventasRealizadas++;
                            unidadesVendidas += cantidadVenta;
                            montoTotalVendido += subtotal;
                            System.out.printf(">> Venta realizada. Total: S/ %.2f%n", subtotal);
                            if (productoActual.getStock() < Producto.STOCK_MINIMO) {
                                System.out.println(">> ALERTA: " + productoActual.obtenerEstadoStock());
                            }
                        } else {
                            System.out.println(">> Stock insuficiente. Disponible: "
                                    + productoActual.getStock());
                        }
                    }
                    break;

                case 4:
                    if (productoActual == null) {
                        System.out.println(">> Primero debe registrar un producto (opcion 1).");
                    } else {
                        int cantidadRepo = leerEntero(sc, "Cantidad a reponer: ", 1);
                        if (productoActual.reponer(cantidadRepo)) {
                            System.out.println(">> Stock actualizado: " + productoActual.getStock());
                        }
                    }
                    break;

                case 5:
                    if (productoActual == null) {
                        System.out.println(">> Primero debe registrar un producto (opcion 1).");
                    } else {
                        int cantidadConsulta = leerEntero(sc, "Cantidad requerida: ", 1);
                        if (productoActual.hayStockSuficiente(cantidadConsulta)) {
                            System.out.println(">> SI hay stock suficiente.");
                        } else {
                            System.out.println(">> NO hay stock suficiente.");
                        }
                        System.out.println("Estado actual: " + productoActual.obtenerEstadoStock());
                    }
                    break;

                case 6:
                    if (productoActual == null) {
                        System.out.println(">> Primero debe registrar un producto (opcion 1).");
                    } else {
                        System.out.println("Descuento | Precio final");
                        for (int d = 5; d <= 30; d += 5) {
                            System.out.printf("   %2d%%    | S/ %.2f%n", d,
                                    productoActual.calcularPrecioConDescuento(d));
                        }
                    }
                    break;

                case 7:
                    System.out.println("===== RESUMEN DE LA SESION =====");
                    System.out.println("Productos registrados : " + productosRegistrados);
                    System.out.println("Objetos Producto creados (atributo de clase): "
                            + Producto.getTotalProductosCreados());
                    System.out.println("Ventas realizadas     : " + ventasRealizadas);
                    System.out.println("Unidades vendidas     : " + unidadesVendidas);
                    System.out.printf("Monto total vendido   : S/ %.2f%n", montoTotalVendido);
                    break;

                case 0:
                    System.out.println("Fin del programa. Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println(">> Opcion invalida. Intente nuevamente.");
            }
        } while (opcion != 0);

        sc.close();
    }

    // ---------- Metodos auxiliares ----------
    static void mostrarMenu() {
        System.out.println();
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar informacion del producto");
        System.out.println("3. Vender producto");
        System.out.println("4. Reponer stock");
        System.out.println("5. Verificar stock disponible");
        System.out.println("6. Simular descuentos");
        System.out.println("7. Resumen de la sesion");
        System.out.println("0. Salir");
    }

    /** Repite la lectura (while) hasta recibir un entero >= minimo. */
    static int leerEntero(Scanner sc, String mensaje, int minimo) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine();
                if (valor >= minimo) {
                    return valor;
                }
                System.out.println("El valor debe ser mayor o igual a " + minimo + ".");
            } else {
                sc.nextLine();
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    /** Repite la lectura (while) hasta recibir un decimal >= minimo. */
    static double leerDecimal(Scanner sc, String mensaje, double minimo) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                double valor = sc.nextDouble();
                sc.nextLine();
                if (valor >= minimo) {
                    return valor;
                }
                System.out.println("El valor debe ser mayor o igual a " + minimo + ".");
            } else {
                sc.nextLine();
                System.out.println("Ingrese un numero valido (use punto decimal).");
            }
        }
    }

    /** Repite la lectura (while) hasta recibir texto no vacio. */
    static String leerTexto(Scanner sc, String mensaje) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = sc.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("El campo no puede estar vacio.");
            }
        }
        return texto.trim();
    }
}
