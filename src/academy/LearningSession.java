package academy;

import exceptions.AlreadyTriedToLearn;
import exceptions.InsuffitientRequiredSkillLevel;
import users.Student;

import java.util.Scanner;


public class LearningSession {
    private final AcademyManager manager;
    private final Scanner scanner;

    public LearningSession(AcademyManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true){

            int studentsSize = manager.getStudents().size();

            System.out.println("Iniciando sesión de aprendizaje...");
            System.out.println("Por favor, seleccione un estudiante: ");
            for ( int i = 0; i < studentsSize ; i++) {
                System.out.println(( i + 1 ) + ". " + manager.getStudents().get(i).getFullName());
            }

            int studentOption = scanner.nextInt() -1;
            scanner.nextLine(); // Consume the newline character
            if ( studentOption < 0 || studentsSize <= studentOption ) {
                System.out.println("Opción no válida, intente nuevamente.");
                continue;
            }
            Student selectedStudent = manager.getStudents().get(studentOption);
            System.out.println("Información del estudiante seleccionado");
            System.out.println("Nombre: " + selectedStudent.getFullName());
            System.out.println("Nivel de habilidad: " + selectedStudent.getSkillLevel());
            System.out.println("Edad: " + selectedStudent.getAge());
            System.out.println("Hechizos aprendidos: "+ selectedStudent.getSpellsLearned());

            System.out.println("Seleccione un hechizo: ");

            int spellsSize = manager.getSpells().size();

            for ( int i  = 0; i < spellsSize ; i++ ) {
                System.out.println(( i + 1 ) + ". " + manager.getSpells().get(i).toString());
            }
            int spellIndex = scanner.nextInt() -1;
            scanner.nextLine(); // Consume the newline character
            if ( spellIndex < 0 || spellIndex  >= spellsSize ) {
                System.out.println("Opción no válida, intente nuevamente.");
                continue;
            }

            Spell selectedSpell = manager.getSpells().get(spellIndex);

            System.out.println("Información del hechizo seleccionado: ");
            System.out.println("Nombre: " + selectedSpell.getName());
            System.out.println("Elemento: " + selectedSpell.getElement());
            System.out.println("Nivel de habilidad: " + selectedSpell.getLevel());

            System.out.println("¿Desea aprender el hechizo? (Y/N)");
            String learnOption = scanner.nextLine().toUpperCase();
            if ( !learnOption.equalsIgnoreCase("Y") ) {
                System.out.println("No se ha aprendido el hechizo.");
                continue;
            }

            try {
                manager.learn(selectedStudent, selectedSpell, selectedStudent.getSkillLevel());

            } catch (InsuffitientRequiredSkillLevel | AlreadyTriedToLearn e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("No se puede aprender el hechizo.");
            }

            System.out.println("¿Desea iniciar otra sesión de aprendizaje? (Y/N)");
            String continueOption = scanner.nextLine().toUpperCase();
            if (!continueOption.equals("Y")) {
                System.out.println("Regresando al menú principal...");
                break;
            }

        }
    }




}
