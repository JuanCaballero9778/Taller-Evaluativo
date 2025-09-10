# 🧪 Taller Evaluativo SOLID, PROGRAMACION FUNCIONAL, PATRONES, TDD, SPRING, SCRUM 

**Integrantes:**
- Juan Pablo Caballero Castellanos.

**Nombre De la Rama:**
`feature/TallerEvaluativo_JuanCaballero_2025-2`

---
## Pruebas de ejecución (Lab 3 parte 1), parte 1.

![alt text](docs/imagenes/pruebaEjecucion.png) 

---

## Diagramas

- Diagrama de contexto: Nos permite conocer el sistema sin conocer los procesos internos, encontramos como el usuario puede interactuar con el sistema 'Monitoreo de Stock' y a la vez observamos los sistemas de log y warning que permmiten generar mensajes de alerta o de información.

![alt text](docs/imagenes/DiagramaContexto.png)

- Diagrama de conceptos: Aqui podemos observar la estructura que va a tener mas adelante en código y sus relaciones (el problema del Stock), el patron de diseño que se va a utilizar que es el observer (Patrón de comportamiento) ya que nos permite que el objeto de update notifique automáticamente a otros objetos cuando cambia su estado, también se utiliza el factory method (Patrón Creacional) para la creación de objetos que en este caso es de los productos.

![alt text](docs/imagenes/DiagramaDeConceptos.png)

- Diagrama de casos de uso: Podemos observar como el usuario interactua con el sistema y muestra las acciones que puede realizar.

![alt text](docs/imagenes/CasosDeUso.png)


## Stock 

Princiapalmente se implemento el patrón de Observer (Comportamiento), ya que los agentes de Log y Warning se puedan notificar cada vez que se cambia el stock de un producto, haciendo que StockService no dependa de implementaciones concretas, también se utilizó Factory Method (patrón de creación) ya que nos facilita la creacion de productos y así evitar la construcción de objetos varias veces.

Logre implementar el principio SOLID:

S -> Ya que cada clase tiene su propia responsabilidad (producto, stock, agentes).

O -> Podemos agregar más agentes en el futuro si se desea.

L -> Todas las implementaciones de StockObserver pueden reemplazar la interfaz sin romper funcionalidad.

I -> Ya que utilizamos la interfaz StockObserver que contiene el método update().

D -> StockService depende de la interfaz StockObserver, no de implementaciones concretas.