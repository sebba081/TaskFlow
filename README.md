# TaskFlow – Gestor de Tareas Inteligente

## 🔍 Descripción del sistema
TaskFlow es una aplicación de escritorio en Java que permite a los usuarios crear, administrar y recibir notificaciones sobre tareas. El sistema está diseñado con 4 patrones de diseño GoF para asegurar flexibilidad, extensibilidad y buen mantenimiento del código. Las tareas pueden ser normales o urgentes, y pueden ser decoradas con recordatorios y etiquetas. Además, se pueden ordenar por prioridad, fecha o estado gracias a estrategias intercambiables.

## ❓ Problema que resuelve
Muchos gestores de tareas no son suficientemente extensibles o requieren duplicar código para nuevas funcionalidades. TaskFlow resuelve este problema usando patrones que permiten escalar funcionalidades sin alterar la estructura base.

---

## 🔧 Tecnologías utilizadas
- Java 17
- Java Collections Framework
- Patrón de arquitectura modular (paquetes separados por patrón)

---

## 🔷 Patrones aplicados

### 1. Factory Method (Creacional)
**Ubicación**: `src/factory`

**Propósito**: Crear tareas según su tipo (normal o urgente) sin acoplar el código a una clase específica.

**Ejemplo**:
```java
Tarea tarea = TareaFactory.crearTarea("urgente", "Entregar evaluación", LocalDate.now());
```

### 2. Decorator (Estructural)
**Ubicación**: `src/decorator`

**Propósito**: Añadir funcionalidades adicionales como recordatorios o etiquetas sin modificar la clase `Tarea` original.

**Ejemplo**:
```java
Tarea tareaConRecordatorio = new RecordatorioDecorator(tarea);
```

### 3. Observer (Comportamiento)
**Ubicación**: `src/observer`

**Propósito**: Notificar automáticamente a observadores (por ejemplo, consola) cuando se crea o modifica una tarea.

**Ejemplo**:
```java
sistemaTareas.agregarObservador(new ConsolaObservador());
```

### 4. Strategy (Libre elección)
**Ubicación**: `src/strategy`

**Propósito**: Permitir cambiar dinámicamente el algoritmo de ordenamiento de tareas (por prioridad, fecha, etc).

**Ejemplo**:
```java
ordenador.setEstrategia(new OrdenarPorPrioridad());
ordenador.ordenar(listaDeTareas);
```

---

## 📊 Diagrama UML de Arquitectura

Este diagrama muestra cómo los distintos patrones de diseño están integrados en el sistema:

![Diagrama UML TaskFlow](img/uml_diagrama.png)

**Explicación de componentes:**

| Patrón           | Clases involucradas                                      | Rol que cumplen                                                        |
|------------------|-----------------------------------------------------------|------------------------------------------------------------------------|
| **Factory Method** | `TareaFactory`, `TareaNormal`, `TareaUrgente`            | Centraliza la creación de tareas según tipo.                          |
| **Decorator**     | `TareaDecorator`, `RecordatorioDecorator`                | Añade funcionalidades sin modificar la clase base `Tarea`.           |
| **Observer**      | `SistemaTareas`, `Observador`, `ConsolaObservador`       | Permite reaccionar cuando se crea una nueva tarea.                    |
| **Strategy**      | `EstrategiaOrdenamiento`, `OrdenarPorPrioridad`, `Ordenador` | Permite cambiar dinámicamente la forma de ordenar las tareas.         |

---

## 📋 Instrucciones de compilación y ejecución

### Requisitos:
- JDK 17 o superior

### Compilar:
```bash
javac -d bin src/**/*.java
```

### Ejecutar:
```bash
java -cp bin main.Main
```

---

## 🏁 Conclusión
TaskFlow demuestra el poder de los patrones de diseño para resolver problemas reales con un código modular, limpio y extensible. Permite evolucionar el sistema sin modificar código existente gracias a principios de diseño sólidos.
