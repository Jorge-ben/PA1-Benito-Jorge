# Sistema básico de registro y control de productos (consola)

**Curso:** Programación Orientada a Objetos (código 30626) — PA1
**Institución:** ISIL - Instituto San Ignacio de Loyola
**Docente:** Wilder Julio Espinoza Bravo
**Sección:** 3663
**Fecha:** 23/09/2026

## Integrante
1. Jorge Jerson Benito Mayhua 

## Video de exposición
MI LINK DE VIDEO: 

## Descripción breve
Programa en Java que ayuda a una microempresa a registrar un producto, mostrar su información,
validar stock, vender, reponer y simular descuentos mediante un menú por consola.
Usa únicamente los temas de las sesiones 1 a 4: clases, atributos, constructores, métodos y
estructuras de control (`if`, `if-else`, anidados, `switch`, `while`, `do-while`, `for`, contadores y acumuladores).

## Estructura del repositorio
```
PA1-Benito Jorge/
├── src/
│   ├── Producto.java   # clase del dominio
│   └── Main.java       # clase ejecutora con main y menú
├── docs/
│   ├── analisis.md         # clases, atributos y métodos definidos
│   └── pruebas.md          # casos de prueba realizados
└── README.md
```

## Instrucciones mínimas de ejecución
Requisito: JDK 17 o superior instalado.
```bash
cd src
javac Producto.java Main.java
java Main
```
También puede abrirse la carpeta `src` en un IDE (IntelliJ, Eclipse, NetBeans, VS Code) y ejecutar `Main`.
Nota: los decimales se escriben con **punto** (ejemplo: `12.50`).

## Menú del programa
| Opción | Acción |
|---|---|
| 1 | Registrar producto (código, nombre, precio, stock) |
| 2 | Mostrar información del producto |
| 3 | Vender producto (valida stock, acumula ventas) |
| 4 | Reponer stock |
| 5 | Verificar si hay stock suficiente |
| 6 | Simular descuentos del 5 % al 30 % |
| 7 | Resumen de la sesión (contadores y acumuladores) |
| 0 | Salir |

## Decisiones de modelado y por qué
- **Una clase de dominio (`Producto`)** con atributos privados (encapsulamiento) y una clase ejecutora (`Main`),
  para separar la lógica del negocio de la interacción con el usuario.
- **Dos constructores:** uno por defecto (que reutiliza al otro con `this(...)`) y uno con parámetros,
  para crear productos vacíos o completos sin duplicar código.
- **Atributos de clase:** `STOCK_MINIMO` (constante para la alerta de stock bajo) y `totalProductosCreados`
  (contador compartido por todos los objetos).
- **Métodos con retorno** (`calcularValorInventario`, `hayStockSuficiente`, `obtenerEstadoStock`, `vender`, `reponer`)
  para que `Main` decida qué mostrar; **método sin retorno** (`mostrarInformacion`) para imprimir la ficha.
- **`do-while` + `switch`** para el menú, porque debe ejecutarse al menos una vez y hay varias opciones.
- **`while`** en los métodos de lectura para repetir la petición hasta que el dato sea válido.
- **`for`** para la tabla de descuentos, porque el número de repeticiones es conocido.
- **Contadores y acumuladores** (ventas, unidades, monto) para el resumen de la sesión.
- **No se usan arreglos ni colecciones** porque no forman parte de los temas hasta la semana 4; por eso el sistema
  gestiona un producto activo a la vez y acumula los resultados de la sesión.

## Pruebas
Ver `docs/pruebas.md`.

