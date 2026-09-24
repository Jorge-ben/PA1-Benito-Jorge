# Pruebas realizadas

| N.º | Caso | Entrada | Resultado esperado | Resultado obtenido |
|---|---|---|---|---|
| 1 | Operar sin registrar | Opción 3 al iniciar | Mensaje "Primero debe registrar un producto" | ✅ Correcto |
| 2 | Precio no numérico | Precio: `abc` | Mensaje de error y se vuelve a pedir | ✅ Correcto |
| 3 | Registro válido | P001, Laptop, 1500.50, 10 | "Producto registrado correctamente" | ✅ Correcto |
| 4 | Mostrar información | Opción 2 | Ficha con valor de inventario S/ 15005.00 | ✅ Correcto |
| 5 | Venta válida | Vender 3 | Total S/ 4501.50; stock 7 | ✅ Correcto |
| 6 | Venta mayor al stock | Vender 20 (stock 7) | "Stock insuficiente. Disponible: 7" | ✅ Correcto |
| 7 | Alerta de stock bajo | Vender 3 más (stock 4) | Alerta STOCK BAJO | ✅ Correcto |
| 8 | Reponer stock | Reponer 4 | Stock 8 | ✅ Correcto |
| 9 | Verificar stock | Cantidad 5 | "SI hay stock suficiente" | ✅ Correcto |
| 10 | Simulación de descuentos | Opción 6 | Tabla 5 %–30 % (S/ 1425.48 … S/ 1050.35) | ✅ Correcto |
| 11 | Resumen | Opción 7 | 2 ventas, 7 unidades, S/ 10503.50 | ✅ Correcto |
| 12 | Opción inválida | Opción 9 | "Opcion invalida" y vuelve al menú | ⚠️ Pendiente de ejecutar |
| 13 | Cantidad 0 o negativa | Vender 0 | "El valor debe ser mayor o igual a 1" | ⚠️ Pendiente de ejecutar |
| 14 | Campo vacío | Código vacío (Enter) | "El campo no puede estar vacio" | ⚠️ Pendiente de ejecutar |

> Los casos 1 a 11 fueron ejecutados en una sola corrida de prueba del programa. Los casos 12 a 14 se
> verifican por lectura del código; **ejecútalos y agrega la evidencia (capturas de pantalla) en `docs/capturas/`.**
