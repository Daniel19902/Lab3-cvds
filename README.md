# Lab3-cvds
Edward Daniel Porras Martin\
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
   | 1 | `tarifaBase < 0` | incorrecto |
   | 2 | `diasAntelacion < 0` | incorrecto |
   | 3 | `edad <= 0` | incorrecto |
   | 4 | `(0 <= tarifaBase) && (0 <= diasAntelacion <= 20) && (0 < edad < 18)` | correcto |
   | 5 | `(0 <= tarifaBase) && (0 <= diasAntelacion <= 20) && (18 <= edad <= 65)` | correcto |
   | 6 | `(0 <= tarifaBase) && (0 <= diasAntelacion <= 20) && (65 < edad)` | correcto |
   | 7 | `(0 <= tarifaBase) && (20 < diasAntelacion) && (0 < edad < 18)` | correcto |
   | 8 | `(0 <= tarifaBase) && (20 < diasAntelacion) && (18 <= edad <= 65)` | correcto |
   | 9 | `(0 <= tarifaBase) && (20 < diasAntelacion) && (65 < edad)` | correcto |
3. Para cada clase de equivalencia, defina un caso de prueba específico, definiendo: parámetros de
   entrada y resultados esperados.

   | Número | Parámetros de entrada | Resultados esperados |
   | :---: | :---: | :---: |
   | 1 | `tarifaBase = -100, diasAntelacion = any, edad = any` | `ExcepcionParametrosInvalidos` |
   | 2 | `tarifaBase = any, diasAntelacion = -20, edad = any` | `ExcepcionParametrosInvalidos` |
   | 3 | `tarifaBase = any, diasAntelacion = any, edad = -18` | `ExcepcionParametrosInvalidos` |
   | 4 | `tarifaBase = 100, diasAntelacion = 10, edad = 9` | 95 |
   | 5 | `tarifaBase = 100, diasAntelacion = 10, edad = 50` | 100 |
   | 6 | `tarifaBase = 100, diasAntelacion = 10, edad = 80` | 92 |
   | 7 | `tarifaBase = 100, diasAntelacion = 30, edad = 9` | 80 |
   | 8 | `tarifaBase = 100, diasAntelacion = 30, edad = 50` | 85 |
   | 9 | `tarifaBase = 100, diasAntelacion = 30, edad = 80` | 77 |
4. A partir de las clases de equivalencia identificadas en el punto 2, identifique las condiciones límite o
   de frontera de las mismas.
   
   | Número | Condiciones límite |
   | :---: | :---: |
   | 1 | `tarifaBase < 0` |
   | 2 | `diasAntelacion < 0` |
   | 3 | `edad <= 0` |
   | 4 | `(0 <= tarifaBase) && (0 <= diasAntelacion <= 20) && (0 < edad < 18)` |
   | 5 | `(0 <= tarifaBase) && (0 <= diasAntelacion <= 20) && (18 <= edad <= 65)` |
   | 6 | `(0 <= tarifaBase) && (0 <= diasAntelacion <= 20) && (65 < edad)` |
   | 7 | `(0 <= tarifaBase) && (20 < diasAntelacion) && (0 < edad < 18)` |
   | 8 | `(0 <= tarifaBase) && (20 < diasAntelacion) && (18 <= edad <= 65)` |
   | 9 | `(0 <= tarifaBase) && (20 < diasAntelacion) && (65 < edad)` |
5. Para cada una de las condiciones de frontera anteriores, defina casos de prueba específicos.

   | Número | Parámetros de entrada | Resultados esperados |
   | :---: | :---: | :---: |
   | 1 | `tarifaBase = -0.001, diasAntelacion = any, edad = any` | `ExcepcionParametrosInvalidos` |
   | 2 | `tarifaBase = any, diasAntelacion = -1, edad = any` | `ExcepcionParametrosInvalidos` |
   | 3 | `tarifaBase = any, diasAntelacion = any, edad = -1` | `ExcepcionParametrosInvalidos` |
   | 4 | `tarifaBase = 100, diasAntelacion = 0, edad = 1` | 95 |
   | 5 | `tarifaBase = 100, diasAntelacion = 20, edad = 18` | 100 |
   | 6 | `tarifaBase = 100, diasAntelacion = 20, edad = 66` | 92 |
   | 7 | `tarifaBase = 100, diasAntelacion = 21, edad = 17` | 80 |
   | 8 | `tarifaBase = 100, diasAntelacion = 21, edad = 65` | 85 |
   | 9 | `tarifaBase = 100, diasAntelacion = 21, edad = 66` | 77 |
   | 10 | `tarifaBase = 0, diasAntelacion = any, edad = any` | 0 |

## Implementación de las pruebas
Requisito: descargue esta [librería](http://campusvirtual.escuelaing.edu.co/moodle/pluginfile.php/142929/mod_assign/intro/aerodescuentos-1.0.0.jar) y ejecute
```
mvn install:install-file -Dfile=aerodescuentos-1.0.0.jar -DgroupId=edu.eci.cvds -DartifactId=aerodescuentos -Dversion=1.0.0 -Dpackaging=jar
```
