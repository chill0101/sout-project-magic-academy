import academy.AcademyManager;
import academy.LearningSession;
import academy.SkillLevel;
import academy.Spell;
import exceptions.DuplicateStudentException;
import utils.Art;
import exceptions.DuplicateSpellException;
import users.Director;
import users.Student;
import utils.InputUtils;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main { // Entry point of the program
    public static void main(String[] args) {
        // For a better experience, open the console in full screen :D

        // Initial welcome text. It's a bit long, so I put it in a separate method
        Art.CastleArt(); // Art class stores all the ASCII art and other text things
        Art.BannerArt();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Presione Enter para continuar");
        scanner.nextLine(); // Wait for the user to press Enter

        //Step 1 => Instance of Director and AcademyManager
        // Director it's a singleton class required, but symbolic for the program execution
        // AcademyManager is the main class that manages the spells and students. It also calls the LearningSession class
        System.out.println(
            """
            
            
            *==============================================================================================================================*
            |                                                     # COMENCEMOS!                                                            |
            *==============================================================================================================================*
            |                                                                                                                              |
            |        ## Descripción                                                                                                        |
            |        Este programa le permitirá ejecutar un flujo simple y parcial simulando una academia de magia                         |
            |        donde los estudiantes pueden aprender hechizos de diferentes elementos y niveles de habilidad.                        |
            |                                                                                                                              |
            |        ## Flujo del proceso                                                                                                  |
            |        1. Registrar al director de la academia                                                                               |
            |        2. Registrar hechizos                                                                                                 |
            |        3. Registrar estudiantes                                                                                              |
            |        4. Iniciar sesión de aprendizaje                                                                                      |
            |        5. Ver lista de estudiantes                                                                                           |
            |        6. Ver lista de hechizos                                                                                              |
            |        7. Salir                                                                                                              |
            |                                                                                                                              |
            |                                                                                                                              |
            *==============================================================================================================================*

            """
        );

        System.out.println(
                "*-------------------------------------------------------------------------------------------------------------------------------* \n" +
                "*=== ** Lo primero será registrar al director de la academia ** ================================================================* \n" +
                "*-------------------------------------------------------------------------------------------------------------------------------* \n" +
                "*=== ** El director tendrá acceso a todos los hechizos registrados ** ==========================================================* \n"
        );

        String directorName = InputUtils.rejectNullInput(
                scanner,
                "*=== Ingrese el nombre del director: ===========================================================================================*"
        ); // Use InputUtils class for group the input validation methods => rejectNullInput detects null inputs and warns the user

        Art.LoadingSimulation(); // Simulate a loading with a simple for loop

        // Singleton
        Director director = Director.getInstance(directorName); // Use getInstance to get the singleton instance of Director with the input directorName

        AcademyManager manager = new AcademyManager(director);  // Instance of AcademyManager with the director instance -- We are adding all spells to the director instance because the director it's super wise and powerful

        // Comment ths to avoid having the default spells and students but is less boring to let them be :D
        System.out.println(">>> Recuperando hechizos y estudiantes existentes...\n");
        manager.registerSpell(new Spell("Hadouken", "Fuego", SkillLevel.BASICO)); // Registering default spells for testing purposes
        manager.registerSpell(new Spell("Pepazo", "Tierra", SkillLevel.INTERMEDIO));
        manager.registerSpell(new Spell("Flame of the Fell God", "Fuego", SkillLevel.AVANZADO));
        manager.registerSpell(new Spell("Hell", "Fuego", SkillLevel.AVANZADO));

        manager.registerStudent(new Student("Cosmo", SkillLevel.BASICO, 118)); // Registering default students for testing purposes
        manager.registerStudent(new Student("Elmago Bochini", SkillLevel.AVANZADO, 25));
        manager.registerStudent(new Student("Gargamel", SkillLevel.INTERMEDIO, 65));
        manager.registerStudent(new Student("Lune", SkillLevel.AVANZADO, 33));
        // End of default data section --

        System.out.println(
                "\n"+
                "*=== El director de la academia ahora es ======================================================================================* \n" +
                "*==============================================================================================================================* \n" +
                "--- " + director.getFullName() + " \uD83E\uDDD9\uD83C\uDFFC\u200D♂\uFE0F                                                         \n" + // the weird chars are emojis
                "*==============================================================================================================================*"
        );

        Art.Column();


        //Step 2 => Set up the academy - Spells
        System.out.println(
                "*-------------------------------------------------------------------------------------------------------------------------------* \n" +
                "*=== ** Hora de Registrar a los nuevos hechizos! ** ============================================================================* \n" +
                "*-------------------------------------------------------------------------------------------------------------------------------* \n" +
                "*=== ** Por favor, Ingresa los datos necesarios para el registro ** ============================================================* \n"
        );
        while (true) { // I used a lot of while for the inputs and maybe there's more effective approaches
           try {
               String spellName = InputUtils.rejectNullInput(scanner,
                       "*=== ** Ingrese el nombre del hechizo:  ** =====================================================================================* \n"
               );
               String element = InputUtils.elementInputOptions(scanner,
                       "*=== ** Ingrese el elemento del hechizo: ** ===================================================================================* \n"
               ); // Use InputUtils class for group the input validation methods => elementInputOptions shows the options and validates the input


               SkillLevel level = InputUtils.skillLevelInputOptions( scanner,
                       "*=== ** Ingrese el nivel de habilidad del hechizo: ** =========================================================================* \n"
               ); // Use InputUtils class for group the input validation methods => skillLevelInputOptions shows the options and validates the input

               Art.LoadingSimulation();

               Spell spell = new Spell( spellName, element, level ); // Instance of Spell class with the input data
               manager.registerSpell( spell ); // Register the spell in the academy manager with the manager method
               System.out.println(
                       "*=== Registro exitoso del hechizo::  ==========================================================================================* \n " +
                       "*==============================================================================================================================* \n " +
                       " --- " + spell.getName() + " ✨                                                                                                   \n " +
                       "*==============================================================================================================================* \n "
               );
               System.out.println( "Registro exitoso del hechizo: " + spell.getName() + "\n" );

               String continueOption;
               while ( true ) { // while loop to validate the input
                   continueOption = InputUtils.rejectNullInput(scanner, "--- Desea agregar otro hechizo? (Y/N) ---");
                   if ( continueOption.equalsIgnoreCase( "Y") || continueOption.equalsIgnoreCase("N") ) {
                       break;
                   } else {
                       System.out.println("--- Por favor, ingrese una opción válida (Y/N) ---");
                   }
               }

               if (continueOption.equalsIgnoreCase("N")) {
                   System.out.println("Registro de hechizos finalizado \n");
                   break;
               } else {
                   System.out.println("Continuando con el registro de hechizos \n");
               }


           } catch (DuplicateSpellException e) { // Use the DuplicateSpellException to catch duplicate spells
               System.out.println(e.getMessage() + ". Intente nuevamente.");
           }


        }

        //Step 3 =>
        System.out.println(
                "*=== ** Hora de Registrar a los nuevos aprendices! ** ==================================================================================* \n" +
                "*---------------------------------------------------------------------------------------------------------------------------------------* \n" +
                "*=== ** Por favor, Ingresa los datos necesarios para el registro ** ====================================================================* \n"
        );
        while (true) { // This wile loop is for restart the process if the user wants to add more students
            try {
                String studentName = InputUtils.rejectNullInput(scanner,
                        "*=== ** Ingrese el nombre del estudiante:  ** =========================================================================================* \n"
                );
                SkillLevel level = InputUtils.skillLevelInputOptions(scanner,
                        "*=== ** Ingrese el nivel de habilidad del estudiante:  ** =============================================================================* \n"
                );
                int age = InputUtils.validateAgeInput(scanner,
                        "*=== ** Ingrese la edad del estudiante: ** ============================================================================================* \n"
                );

                Student student = new Student(studentName, level, age);
                manager.registerStudent(student);
                System.out.println("Registro exitoso del estudiante: " + student.getFullName() + "\n");
            } catch ( DuplicateStudentException e ) {
                System.out.println(e.getMessage() + ". Intente nuevamente.");
            }

            String continueOption;
            while ( true ) {
                continueOption = InputUtils.rejectNullInput(scanner, "--- Desea agregar otro estudiante? (Y/N) ---");
                if ( continueOption.equalsIgnoreCase( "Y") || continueOption.equalsIgnoreCase("N") ) {
                    break;
                } else {
                    System.out.println("--- Por favor, ingrese una opción válida (Y/N) ---");
                }
            }

            if (continueOption.equalsIgnoreCase("N")) {
                System.out.println("Registro de estudiantes finalizado \n");
                break;
            } else {
                System.out.println("Continuando con el registro de estudiantes \n");
            }


        }

        Art.Column();

        //Step 4 => Main menu after the initial setup
        System.out.println(
                "*============================== ** Ya tenemos hechizos y estudiantes, comencemos la aventura! ** ==============================* \n" +
                "*------------------------------------------------------------------------------------------------------------------------------* \n" +
                "*============================== ** SOUT ACADEMY - La academia más prestigiosa de esta dimensión ** ============================* \n"
        );
        while(true){ // while to keep the program running until the user decides to exit
            try {
                System.out.println(
                    """
                    
                    
                    *==============================================================================================================================*
                    |                                                  MENÚ DE NAVEGACIÓN                                                          |
                    *==============================================================================================================================*
                    |                                                                                                                              |
                    |                                       1. Ver base de estudiantes                                                             |
                    |                                       2. Ver base de hechizos                                                                |
                    |                                       3. Iniciar sesión de aprendizaje                                                       |
                    |                                       4. Salir                                                                               |
                    |                                                                                                                              |
                    |------------------------------------------------------------------------------------------------------------------------------|
                    |                                       Selecciona una opción y presiona Enter                                                 |
                    *==============================================================================================================================*

                    """
                );
                System.out.print("Escriba aquí la opción: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        Art.LoadingSimulation();
                        System.out.println("Lista de estudiantes: ");
                        manager.getStudents().forEach(student -> System.out.println("- " + student.toString())); // Print the list of students using the toString() method
                        System.out.println("---");
                        break;
                    case 2:
                        Art.LoadingSimulation();
                        System.out.println("Lista de hechizos: ");
                        manager.getSpells().forEach(spell -> System.out.println(spell.toString())); // Print the list of spells using the toString() method
                        System.out.println("---");
                        break;
                    case 3:
                        Art.Column();
                        LearningSession session = new LearningSession(manager, scanner); // Instance of LearningSession class with the manager and scanner instances to execute the main action
                        session.start(); // Calls the public void start method of the LearningSession class
                        break;
                    case 4:
                        System.out.println("ADIOS! NO VUELVAS...");
                        Art.LittleMadThing();
                        System.out.println("---");
                        scanner.close(); // Close the scanner
                        return; // Exit the program
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        System.out.println("---");
                        //continue; // I commented this because IntelliJ has complained about it ._.
                }
            } catch (InputMismatchException e) { // Use the InputMismatchException to catch invalid inputs (built-in exception)
                    System.out.println("Por favor, ingrese un número válido para la opción.");
                    scanner.nextLine(); // Consume the invalid input
            }

        }

    }

}