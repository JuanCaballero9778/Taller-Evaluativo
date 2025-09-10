# 🧪 Taller Evaluativo SOLID, PROGRAMACION FUNCIONAL, PATRONES, TDD, SPRING, SCRUM 

**Integrantes:**
- Juan Pablo Caballero Castellanos.

**Nombre De la Rama:**
`feature/TallerEvaluativo_JuanCaballero_2025-2`

---
## Pruebas de ejecución "mvn clean compile".

![alt text](docs/imagenes/PruebaEjecucion.png) 

---

## Diagramas

- Diagrama de contexto: Nos permite conocer el sistema sin conocer los procesos internos, encontramos como el usuario puede interactuar con el sistema 'Monitoreo de Stock' y a la vez observamos los sistemas de log y warning que permmiten generar mensajes de alerta o de información.

![alt text](docs/uml/DiagramaContexto.png)

- Diagrama de conceptos: Aqui podemos observar la estructura que va a tener mas adelante en código y sus relaciones (el problema del Stock), el patron de diseño que se va a utilizar que es el observer (Patrón de comportamiento) ya que nos permite que el objeto de update notifique automáticamente a otros objetos cuando cambia su estado, también se utiliza el factory method (Patrón Creacional) para la creación de objetos que en este caso es de los productos.

![alt text](docs/uml/DiagramaDeConceptos.png)

- Diagrama de casos de uso: Podemos observar como el usuario interactua con el sistema y muestra las acciones que puede realizar.

![alt text](docs/uml/CasosDeUso.png)


## Stock 

Princiapalmente se implemento el patrón de Observer (Comportamiento), ya que los agentes de Log y Warning se puedan notificar cada vez que se cambia el stock de un producto, haciendo que StockService no dependa de implementaciones concretas, también se utilizó Factory Method (patrón de creación) ya que nos facilita la creacion de productos y así evitar la construcción de objetos varias veces.

Logre implementar el principio SOLID:

S -> Ya que cada clase tiene su propia responsabilidad (producto, stock, agentes).

O -> Podemos agregar más agentes en el futuro si se desea.

L -> Todas las implementaciones de StockObserver pueden reemplazar la interfaz sin romper funcionalidad.

I -> Ya que utilizamos la interfaz StockObserver que contiene el método update().

D -> StockService depende de la interfaz StockObserver, no de implementaciones concretas.

**Organización del taller en Jira**

![alt text](docs/imagenes/Jira.png)

- HU:

![alt text](docs/imagenes/HU.png)


**Primer Ciclo TDD:**

🔴 Rojo:

![alt text](docs/imagenes/testWarning.png)

![alt text](docs/imagenes/testProduct.png)

![alt text](docs/imagenes/testLog.png)

![alt text](docs/imagenes/testProductFactory.png)

![alt text](docs/imagenes/testCategory.png)

![alt text](docs/imagenes/testObserver.png)

![alt text](docs/imagenes/testStockService.png)

![alt text](docs/imagenes/testE2E.png)

🟢 Verde:

![alt text](docs/imagenes/Category.png)

![alt text](docs/imagenes/Product.png)

![alt text](docs/imagenes/ProductFactory.png)

![alt text](docs/imagenes/StockObserver.png)

![alt text](docs/imagenes/StockService.png)

![alt text](docs/imagenes/LogAgent.png)

![alt text](docs/imagenes/WarningAgent.png)

![alt text](docs/imagenes/MonitoreoStock.png)

## 💻 Compilación pruebas:

![alt text](docs/imagenes/pruebasCompilacion.png)

## Jira

![alt text](docs/imagenes/JiraVerde.png)

![alt text](docs/imagenes/JiraVerde1.png)

## Inyección de dependencias:

- Cuando arranque el contenedor (@componer, @service...), busca un objeto administrado por Spring que coincida con este tipo de clase o interfaz y ahi lo inyecta.

![alt text](docs/imagenes/StockService.png)

![alt text](docs/imagenes/MonitoreoStock.png)

## Cobertura JACOCO

- Aqui encontramos la cobertura y el reporte de jacoco "mvn test".

![alt text](docs/imagenes/JacocoCobertura.png)

![alt text](docs/imagenes/JacocoCobertura1.png)

## Cobertura y reporte SonarQube

- Aqui encontramos el reporte de SonarQube de la cobertura del código "mvn verify sonar:sonar -D sonar.token=sqa_82d59eb660134106374ac9d7b0499..."

![alt text](docs/imagenes/CoberturaSonar.png)

![alt text](docs/imagenes/CompilacionSonar.png)




## Jira finalizado

![alt text](docs/imagenes/JiraFinal.png)

![alt text](docs/imagenes/JiraFinal1.png)

