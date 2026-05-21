# PRIORITY-QUEUE-HEAP — Atención de Pacientes (Emergencias)

Proyecto para simular el sistema de atención de pacientes en la sección de Emergencias de un hospital utilizando **colas con prioridad**.

**Universidad del Valle de Guatemala**  
**CC2003 – Algoritmos y Estructura de Datos**  

---

## Descripción del problema

Cuando un paciente llega a Emergencias se registra:

- **Nombre**
- **Descripción del síntoma/enfermedad**
- **Código de emergencia**: una letra de **A a E**
  - **A** = prioridad más alta (se atiende primero)
  - **E** = prioridad más baja (se atiende después)

Los pacientes se cargan desde un archivo de texto llamado **`pacientes.txt`** (campos separados por comas).  
Ejemplo:

```
Juan Perez, fractura de pierna, C
Maria Ramirez, apendicitis, A
Lorenzo Toledo, chikunguya, E
Carmen Sarmientos, dolores de parto, B
```

El sistema permite pedir el **siguiente paciente** (el de mayor prioridad).

---

## Estructura del proyecto

El código se encuentra en el módulo Maven `demo/`:

- `demo/src/main/java/org/heap/`
  - `Paciente.java` (implementa `Comparable`)
  - `PriorityQueue.java` (interfaz ADT)
  - `VectorHeap.java` (implementación de heap / priority queue)
  - `TXTReader.java` (lector de `pacientes.txt`)
  - `Main.java` (versión usando `VectorHeap`)
  - `PriorityQueueMain.java` (versión usando `java.util.PriorityQueue`)
- `demo/src/main/resources/`
  - `pacientes.txt`

---

## Implementación

### a) Clase `Paciente`

- Contiene: nombre, enfermedad/síntoma, prioridad.
- Implementa `Comparable<Paciente>` para que se pueda ordenar por prioridad.
- La prioridad **A** debe considerarse “menor” que **B**, etc. para que un **min-heap** atienda primero la A.

### b) `VectorHeap<E extends Comparable<E>>`

- Implementa la interfaz `PriorityQueue<E>`.
- Usa la estructura de datos **heap** para insertar y remover el elemento mínimo (mayor prioridad).

Métodos principales:
- `insert(E item)`
- `removeMin()`
- `peekMin()`
- `isEmpty()`
- `size()`


### d) Versión con Java Collection Framework (JCF)

Se implementa una segunda versión usando:

- `java.util.PriorityQueue<Paciente>`

Operaciones equivalentes:
- insertar: `offer(...)`
- atender/remover: `poll()`
- ver siguiente: `peek()`

---

## Cómo ejecutar

### Requisitos
- Java 17+
- Maven (si deseas compilar/ejecutar desde terminal)

### Ejecutar desde IDE
1. Abre el proyecto.
2. Entra a `demo/`.
3. Ejecuta:
   - `org.heap.Main` (versión VectorHeap)
   - `org.heap.PriorityQueueMain` (versión JCF)

### Ejecutar desde terminal (Maven)
Desde la carpeta `demo/`:

```bash
mvn compile
```

Luego ejecuta el main desde tu IDE o configura el plugin `exec-maven-plugin` si deseas correrlo por consola.

---

## Uso del programa (menú)

El programa muestra un menú:

1. Insertar paciente  
2. Atender paciente con mayor prioridad  
3. Mostrar paciente con mayor prioridad  
4. Salir  

---

## Autor

- Jimena Vásquez 25092