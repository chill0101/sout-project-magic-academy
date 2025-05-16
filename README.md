# SOUT Academy - Academia de Magia por consola

## Descripción
- Este proyecto es una simulación de una Academia de Magia, donde los estudiantes pueden aprender hechizos. El sistema incluye la gestión de estudiantes, hechizos y un director de la academia. Se implementan excepciones personalizadas para manejar errores comunes, como intentos de aprendizaje duplicados o niveles de habilidad insuficientes. 
- Realizado como parte de la materia programación avanzada (TP1).
- Se implementan los conceptos solicitados por la consigna y se agregan algunos extras para mejorar la experiencia del usuario. El nombramiento de elementos del código y los comentarios están en inglés, pero la UI se muestra en español para el usuario.
- Se puede tomar este proyecto de base para escalarlo y generar un pequeño sistema de gestión o juego.

## Estructura del Proyecto
- sout-cademy 
  - src
    - academy
      - AcademyManager.java
      - Learnable.java
      - LearningSession.java
      - Spell.java
      - SkillLevel.java
    - exceptions
      - AlreadyTriedToLearn.java
      - DuplicateSpellException.java
      - DuplicateStudentException.java
      - InsufficientSkillLevelException.java
    - interfaces
      - Learnable.java
    - users
      - Director.java
      - Person.java
      - Student.java
    - utils
      - Art.java
      - InputUtils.java

## Clases

### Director 
- Clase simbólica que representa al director de la academia. Se utiliza Singleton.

### Spell
- Clase que representa un hechizo. Contiene atributos nombre, elemento y nivel de habilidad requerido.

### Student
- Clase que representa a un estudiante. Contiene atributos nombre, edad y nivel de habilidad. También tiene una lista de hechizos aprendidos y de hechizos que intentó aprender.

### Academy
- Clase que representa la academia. Contiene métodos para registrar estudiantes, hechizos y el director de la academia. También tiene métodos para mostrar estudiantes y hechizos, así como para iniciar aprendizajes de hechizos.

### LearningSession
- Clase que representa una sesión de aprendizaje. Contiene métodos para verificar si un estudiante puede aprender un hechizo y registrar el aprendizaje de un hechizo.

### Art
- Clase auxiliar que contiene métodos para mostrar mensajes en la consola y no sobrecargar el código de las clases principales. Contiene métodos para mostrar mensajes de error y mensajes de éxito.

## Enum

### SkillLevel
- Enum que representa los niveles de habilidad. Contiene los niveles 1, 2 y 3 accedidos para evaluar si un estudiante puede aprender un hechizo.

## Interface

### Learnable
- Interfaz que define el método `learn`.

### InputUtils
- Clase auxiliar que contiene métodos para manejar la entrada del usuario. Contiene métodos para leer cadenas, enteros y flotantes, así como para mostrar opciones y leer selecciones del usuario.

## Casos de Uso
- Registrar al director de la academia.
- Registrar hechizos disponibles.
- Mostrar hechizos disponibles.
- Registrar estudiantes.
- Mostrar estudiantes.
- Comenzar aprendizajes de hechizos.
- Verificar si el estudiante puede aprender un hechizo.
- Registrar el aprendizaje de un hechizo.
- Mostrar los estudiantes y sus aprendizajes.

## Excepciones Personalizadas
- Se utilizan las excepciones personalizadas `HechizoYaAprendidoException` y `SkillLevelInsuficienteException` para manejar errores específicos relacionados con el aprendizaje de hechizos.
- Se lanza `AlreadyTriedToLearn` cuando un estudiante intenta aprender un hechizo que ya ha aprendido.
- De todas formas, se captura el error pero se permite continuar con el flujo del programa.

## Patrón Singleton
- Se implementa el patrón Singleton para asegurar que solo haya una instancia del director de la academia. 

## Datos de Prueba para introducir
- Se incluyen datos de prueba para facilitar la ejecución del programa y la verificación de su funcionamiento. Estos datos se pueden modificar o ampliar según sea necesario.
- **Director**: 
  - Nombre 1: Gandalf
  - Nombre 2: Dumbledore
  - Nombre 3: Tronchatoro
- **Hechizos**:
  - **Hechizo 1**:
    - Nombre: Expelliarmus
    - Elemento: Aire -> Opción 4
    - SkillLevel: 1
  - **Hechizo 2**:
    - Nombre: Pepazo
    - Elemento: Tierra -> Opción 2
    - SkillLevel: 2
  - **Hechizo 3**: 
    - Nombre: git push --force
    - Elemento: Fuego -> Opción 1
    - SkillLevel: 3
  - **Hechizo 4**: 
    - Nombre: Agua control
    - Elemento: Agua -> Opción 3
    - SkillLevel: 1
- **Estudiantes**: 
  - **Estudiante 1**
    - Nombre: Harry Potter
    - Edad: 12
    - SkillLevel: 2
  - **Estudiante 2**:
    - Nombre: Guillermo Coria
    - Edad: 57
    - SkillLevel: 1
  - **Estudiante 3**:
    - Nombre: Sabrina Spellman
    - Edad: 16
    - SkillLevel: 2
  - **Estudiante 4**:
    - Nombre: Lulu support
    - Edad: 120
    - SkillLevel: 3
  - **Estudiante 5**:
    - Nombre: Yennefer de Vengerberg
    - Edad: 23
    - SkillLevel: 3
- El programa viene con datos de prueba predefinidos para facilitar la ejecución y verificación del funcionamiento. Estos datos se pueden modificar o ampliar según sea necesario.
