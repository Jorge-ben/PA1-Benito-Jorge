# Análisis del caso (Actividad 1)

## Problema
Una microempresa necesita un programa por consola para registrar productos, mostrar su información,
validar stock y ejecutar operaciones básicas de control.

## Alcance según el sílabo (sesiones 1-4)
Solo clases, atributos, constructores, métodos, `if`, `if-else`, anidados, `switch`, `while`, `do-while`, `for`,
contadores y acumuladores. Por eso **no** se usan arreglos, `ArrayList`, herencia ni excepciones.

## Clases identificadas
| Clase | Rol |
|---|---|
| `Producto` | Modela el producto: sus datos y las operaciones sobre ellos. |
| `Main` | Ejecutora: menú, lectura de datos, contadores y acumuladores de la sesión. |

## Clase `Producto`
**Atributos de instancia:** `codigo` (String), `nombre` (String), `precio` (double), `stock` (int).
**Atributos de clase:** `STOCK_MINIMO = 5` (constante), `totalProductosCreados` (contador).

**Constructores:** `Producto()` y `Producto(codigo, nombre, precio, stock)`.

| Método | Retorno | Función |
|---|---|---|
| `mostrarInformacion()` | void | Imprime la ficha del producto |
| `calcularValorInventario()` | double | precio × stock |
| `hayStockSuficiente(int)` | boolean | Valida cantidad > 0 y ≤ stock |
| `calcularPrecioConDescuento(double)` | double | Aplica un porcentaje de descuento |
| `obtenerEstadoStock()` | String | SIN STOCK / STOCK BAJO / STOCK NORMAL |
| `vender(int)` | boolean | Descuenta stock si es posible |
| `reponer(int)` | boolean | Suma stock si la cantidad es válida |
| getters | — | Acceso a atributos privados |

## Clase `Main`
- Variables acumuladoras: `productosRegistrados`, `ventasRealizadas`, `unidadesVendidas` (contadores/acumuladores enteros) y `montoTotalVendido` (acumulador decimal).
- Métodos auxiliares: `mostrarMenu`, `leerEntero`, `leerDecimal`, `leerTexto` (validan con `while`).

## Diagrama de clases (texto)
```
+---------------------------------------+
|               Producto                |
+---------------------------------------+
| - codigo: String                      |
| - nombre: String                      |
| - precio: double                      |
| - stock: int                          |
| + STOCK_MINIMO: int {static final}    |
| - totalProductosCreados: int {static} |
+---------------------------------------+
| + Producto()                          |
| + Producto(codigo, nombre, precio,    |
|            stock)                     |
| + mostrarInformacion(): void          |
| + calcularValorInventario(): double   |
| + hayStockSuficiente(int): boolean    |
| + calcularPrecioConDescuento(double)  |
|                            : double   |
| + obtenerEstadoStock(): String        |
| + vender(int): boolean                |
| + reponer(int): boolean               |
| + getters...                          |
+---------------------------------------+
              ^ usa
              |
+---------------------------------------+
|                 Main                  |
| + main(String[]): void                |
| + mostrarMenu(): void                 |
| + leerEntero / leerDecimal /          |
|   leerTexto                           |
+---------------------------------------+
```

## Flujo principal
`Inicio → do { mostrar menú → leer opción → switch(opción) } while (opción ≠ 0) → Fin`

## Mapa de temas del sílabo → dónde se aplican
| Tema | Dónde |
|---|---|
| Objetos y clases | `Producto`, `new Producto(...)` en `Main` |
| Atributos de clase e instancia | `STOCK_MINIMO`, `totalProductosCreados` / `codigo`, `precio`... |
| Atributos locales y globales | Variables locales en `main`; atributos de la clase |
| Constructores | Los dos constructores de `Producto` |
| Métodos con y sin retorno | `mostrarInformacion` (void) vs. `vender`, `calcular...` |
| if / if-else / anidados | `obtenerEstadoStock`, ventas en `Main` (if dentro de if) |
| switch | Menú de `Main` |
| while | `leerEntero`, `leerDecimal`, `leerTexto` |
| do-while | Bucle del menú |
| for | Tabla de descuentos (opción 6) |
| Contadores y acumuladores | Resumen de la sesión (opción 7) |
