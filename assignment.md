# Simulación de una Academia de Magia

## Requisitos del Sistema

### 1. Director de la Academia
- Al iniciar el programa, se debe registrar al director de la academia.
- Este director será único durante la ejecución del programa (aplicar el patrón Singleton).

### 2. Hechizos
- Cada hechizo debe tener los siguientes atributos:
    - **Nombre**
    - **Nivel de dificultad** (por ejemplo: básico, intermedio, avanzado)
    - **Elemento mágico asociado** (por ejemplo: fuego, agua, tierra, aire)
- El sistema debe permitir registrar varios hechizos disponibles para que los estudiantes los aprendan.

### 3. Estudiantes
- Cada estudiante debe proporcionar la siguiente información:
    - **Nombre**
    - **Edad**
    - **Nivel de habilidad** (por ejemplo: principiante, intermedio, experto)
- Al intentar aprender un hechizo, se debe verificar que el nivel de habilidad del estudiante sea suficiente para el nivel de dificultad del hechizo.
- Si no cumple, se debe lanzar una **excepción personalizada** con un mensaje adecuado (por ejemplo: "El estudiante no tiene el nivel necesario para aprender este hechizo").

### 4. Aprendizaje de Hechizos
- Cada intento de aprendizaje debe incluir:
    - Información del estudiante
    - Hechizo que desea aprender
- El sistema debe verificar que el estudiante no intente aprender el mismo hechizo dos veces.
- Si lo intenta, se debe lanzar una **excepción personalizada** con un mensaje adecuado (por ejemplo: "El estudiante ya ha aprendido este hechizo").

---

## Diseño del Sistema

### Clases Necesarias
- Crear las clases necesarias para representar los conceptos del sistema:
    - **Director**
    - **Hechizo**
    - **Estudiante**
    - **Aprendizaje**

### Implementaciones
- Implementar el patrón **Singleton** para la clase `Director`.
- Crear **excepciones personalizadas** para manejar los siguientes errores:
    - Nivel de habilidad insuficiente.
    - Intentos de aprendizaje duplicados.

---

## Flujo del Programa

1. Registrar al director al iniciar el programa.
2. Permitir el registro de varios hechizos disponibles en la academia.
3. Solicitar la información de los estudiantes y los hechizos que desean aprender.
4. Verificar que:
    - El nivel de habilidad del estudiante sea suficiente para el nivel de dificultad del hechizo.
    - Un estudiante no intente aprender el mismo hechizo dos veces.
5. Registrar el aprendizaje si todos los datos son correctos.