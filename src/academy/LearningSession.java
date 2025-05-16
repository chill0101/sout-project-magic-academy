/**
 * This class is responsible for implement the learning session of the academy.
 * It allows the user to select a student and a spell, and then attempts to learn the spell.
 * It handles user input and exceptions related to the learning process.
 * For the process, we use validations and while loops for handling user input and control flow.
 *
 */

package academy;

import exceptions.AlreadyTriedToLearn;
import exceptions.InsuffitientRequiredSkillLevel;
import users.Student;
import utils.Art;
import utils.InputUtils;

import java.util.InputMismatchException;
import java.util.Scanner;


public class LearningSession {
    private final AcademyManager manager;
    private final Scanner scanner;

    public LearningSession(AcademyManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() { // start method to initiate the learning session
        while (true) {

            int studentsSize = manager.getStudents().size(); // Get the number of students for display

            System.out.println(
                    "*=== ** Iniciando sesión de aprendizaje ** ==================================================================================* \n" +
                    "*----------------------------------------------------------------------------------------------------------------------------* \n" +
                    "*=== ** Por favor, seleccione un estudiante: ** =============================================================================* \n"
            );

            for (int i = 0; i < studentsSize; i++) { // Display the list of students
                System.out.println((i + 1) + ". " + manager.getStudents().get(i).getFullName());
            }

            int studentOption; // Variable to store the selected student option

            while (true) {
                try {
                    System.out.println("\n --- Seleccione el número de estudiante ---");

                    studentOption = scanner.nextInt();
                    scanner.nextLine(); // Jump
                    if (studentOption >= 1 && studentOption <= studentsSize) {
                        studentOption-- ;
                        break;
                    } else {
                        System.out.println("Opción no válida, intente nuevamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido para el estudiante.");
                    scanner.nextLine(); // Jump
                }
            }

            Student selectedStudent = manager.getStudents().get(studentOption);
            System.out.println("*=== ** Información del estudiante seleccionado ** ========================================================================*");
            System.out.println("- Nombre: " + selectedStudent.getFullName());
            System.out.println("- Nivel de habilidad: " + selectedStudent.getSkillLevel());
            System.out.println("- Edad: " + selectedStudent.getAge());
            System.out.println("- Hechizos aprendidos: " + selectedStudent.getSpellsLearned() + "\n"); // Must improve this part by making it return a formatted list

            System.out.println();
            System.out.println("*=== ** Por favor, seleccione un hechizo: ** ==============================================================================*");
            int spellsSize = manager.getSpells().size();

            for (int i = 0; i < spellsSize; i++) {
                System.out.println((i + 1) + ". " + manager.getSpells().get(i).toString());
            }


            int spellIndex; // Variable to store the selected spell index
            while (true) {
                try {
                    System.out.println("\n --- Seleccione el número de hechizo ---");
                    spellIndex = scanner.nextInt();
                    scanner.nextLine(); // Jump
                    if (spellIndex >= 1 &&  spellIndex <= spellsSize) { // Check if the selected spell index is valid
                        spellIndex-- ; // Adjust for zero-based index that we use in the list
                        break;
                    } else {
                        System.out.println("Opción no válida, intente nuevamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido para el hechizo.");
                    scanner.nextLine(); // Jump
                }
            }

            Spell selectedSpell = manager.getSpells().get(spellIndex); // Get the selected spell from the list
            System.out.println("*=== ** Información del hechizo seleccionado: ** ==========================================================================*");
            System.out.println("- Nombre: " + selectedSpell.getName());
            System.out.println("- Elemento: " + selectedSpell.getElement());
            System.out.println("- Nivel de habilidad: " + selectedSpell.getLevel());

            // Check if the student has already learned the spell
            String learnOption = InputUtils.rejectNullInput(scanner, "\n --- Para iniciar el intento, ingrese Y ---");
            if (!learnOption.equalsIgnoreCase("Y")) {
                System.out.println("No se ha aprendido el hechizo porque no has seleccionado la opción 'Y'.");
                System.out.println("Arrugaste, comencemos otra vez.");
                System.out.println("--- \n");

                continue;
            }


            try {
                manager.learn(selectedStudent, selectedSpell, selectedStudent.getSkillLevel()); // Call the learn method to learn the spell

            } catch (InsuffitientRequiredSkillLevel | AlreadyTriedToLearn e) { // Catch the custom exceptions
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println("No se puede aprender el hechizo.");
                Art.UnluckyMessage();
            }

            System.out.println("\n ");
            String continueOption; // Variable to store the continue option
            while ( true ) {
                continueOption = InputUtils.rejectNullInput(scanner, "--- ¿Desea iniciar otra sesión de aprendizaje? (Y/N) ---");

                if ( continueOption.equalsIgnoreCase( "Y") || continueOption.equalsIgnoreCase("N") ) {
                    break;
                } else {
                    System.out.println("--- Por favor, ingrese una opción válida (Y/N) ---");
                }
            }

            if (!continueOption.equalsIgnoreCase("Y")) {
                System.out.println("*================================================ Regresando al menú principal ================================================*");
                break;
            }

        }
    }




}
