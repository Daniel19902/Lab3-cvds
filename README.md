# Lab3-cvds
Edward Daniel Porras Martin
Daniel Felipe Hernández Mancipe

# Clases de equivalencia

## Crear un proyecto con Maven
`mvn archetype:generate`

## Compilar y Ejecutar
- Ejecute los comandos necesarios de Maven, para compilar el proyecto y verificar que el proyecto se creó correctamente y los cambios realizados al archivo pom no generan inconvenientes.\
`mvn compile`
- Busque el comando requerido para ejecutar las pruebas unitarias de un proyecto desde Maven y ejecútelo sobre el proyecto. Se debe ejecutar la clase AppTest con resultado exitoso.\
`mvn -Dtest=edu.eci.cvds.tdd.AppTest test`

## Ejecutar las pruebas
Dos opciones:
- Para compilar el código, empaquetarlo en su formato distribuible (como un JAR) y ejecutar pruebas:\
`mvn package`
- Para ejecutar todas las clases de prueba:\
`mvn test`

# Ejercicio "Descuento de tarifas"

## Realizar diseño de pruebas
1. Se debería arrojar una excepción de tipo `ExcepcionParametrosInvalidos` cuando:
    - `tarifaBase < 0`
    - `diasAntelacion < 0`
    - `edad < 0`
2. En la siguiente tabla enumere un conjunto de clases de equivalencia que -según usted- creen una
   buena división del conjunto de datos de entrada de la función anterior:

   | Número | Clase de equivalencia (en lenguaje natural o matemático) | Resultado (correcto / incorrecto) |
   | :---: | :---: | :---: |
   | 1 | `tarifaBase < 0` | 50 / -1 |
   | 2 | `diasAntelacion < 0` | 1 / -1 |
   | 3 | `edad < 0` | 18 / -1 |
3. Para cada clase de equivalencia, defina un caso de prueba específico, definiendo: parámetros de
   entrada y resultados esperados.

   | Número | Parámetros de entrada | Resultados esperados |
   | :---: | :---: | :---: |
   | 1 | `tarifaBase = -1, diasAntelacion = 1, edad = 18` | `ExcepcionParametrosInvalidos` |
   | 2 | `tarifaBase = 50, diasAntelacion = -1, edad = 18` | `ExcepcionParametrosInvalidos` |
   | 3 | `tarifaBase = 50, diasAntelacion = 1, edad = -1` | `ExcepcionParametrosInvalidos` |
4. A partir de las clases de equivalencia identificadas en el punto 2, identifique las condiciones límite o
   de frontera de las mismas.
   
   | Número | Condiciones límite |
   | :---: | :---: |
   | 1 | `tarifaBase < 0` |
   | 2 | `diasAntelacion < 0` |
   | 3 | `edad < 0` |
5. Para cada una de las condiciones de frontera anteriores, defina casos de prueba específicos.

   | Número | Parámetros de entrada | Resultados esperados |
   | :---: | :---: | :---: |
   | 1 | `tarifaBase = -0.1, diasAntelacion = 1, edad = 18` | `ExcepcionParametrosInvalidos` |
   | 2 | `tarifaBase = 50, diasAntelacion = -1, edad = 18` | `ExcepcionParametrosInvalidos` |
   | 3 | `tarifaBase = 50, diasAntelacion = 1, edad = -1` | `ExcepcionParametrosInvalidos` |
