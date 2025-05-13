import academy.AcademyManager;
import academy.LearningSession;
import academy.SkillLevel;
import academy.Spell;
import exceptions.AlreadyTriedToLearn;
import exceptions.InsuffitientRequiredSkillLevel;
import users.Director;
import users.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenido perro!");
        Scanner scanner = new Scanner(System.in);
        AcademyManager manager = new AcademyManager();
        //Step 1 =>
        /*
         * "Welcome to the SOUT Academy[...]"
         * "Please register the director[...]" => Use the singleton
         * -- Scanner --
         * -- Validate Input --
         * IF input is not valid => Exception
         * -- Create Director --
         * IF Director is already registered => Message and continue
         */
        System.out.println("Bienvenido a SOUT Academy \n");
        System.out.println("Por favor, registre al director de la academia \n");
        String directorName = scanner.nextLine();
        Director director = Director.getInstance(directorName);
        System.out.println("El director de la academia es: " + director.getFullName() + "\n");


        //Step 2 =>
        /*
         * "Please register some spells[...]"
         * -- Scanner --
         * -- Validate Input --
         * IF input is not valid => Exception
         * -- IF name is already registered => Message and register again
         * -- Create Spell --
         * "Want to add another spell?[...]
         * Options: "Y" or "N"
         * IF Y => Go to Step 2
         * IF N => Continue
         */
        System.out.println("Por favor, registre algunos hechizos \n");
        while (true) {
            System.out.println("Ingrese el nombre del hechizo: ");
            String spellName = scanner.nextLine();
            System.out.println("Ingrese el elemento del hechizo");
            System.out.println("1. FUEGO, 2. AGUA, 3. TIERRA, 4. AIRE");
            int IntElement = scanner.nextInt();
            scanner.nextLine();
            String element;
            switch (IntElement) {
                case 1:
                    element = "Fuego";
                    break;
                case 2:
                    element = "Agua";
                    break;
                case 3:
                    element = "Tierra";
                    break;
                case 4:
                    element = "Aire";
                    break;
                default:
                    System.out.println("Elemento no válido");
                    continue;
            }


            System.out.println("Ingrese el nivel de habilidad del hechizo: " +
                    "1. BASICO, 2. INTERMEDIO, 3. AVANZADO");
            int IntLevel = scanner.nextInt();
            scanner.nextLine();
            SkillLevel level;
            switch (IntLevel) {
                case 1:
                    level = SkillLevel.BASICO;
                    break;
                case 2:
                    level = SkillLevel.INTERMEDIO;
                    break;
                case 3:
                    level = SkillLevel.AVANZADO;
                    break;
                default:
                    System.out.println("Nivel no válido");
                    continue;
            }

            Spell spell = new Spell(spellName, element, level);
            manager.registerSpell(spell);
            System.out.println("Registro exitoso del hechizo: " + spell.getName() + "\n");
            System.out.println("¿Desea agregar otro hechizo? (Y/N)");
            String continueOption = scanner.nextLine().toUpperCase();
            if (!continueOption.equals("Y")) {
                System.out.println("Registro de hechizos finalizado \n");
                break;
            } else {
                System.out.println("Continuando con el registro de hechizos \n");

            }


        }

        //Step 3 =>
        /*
         * "Please register some students[...]"
         * -- Scanner --
         * -- Validate Input --
         * IF input is not valid => Exception
         * -- IF name is already registered => Message and register again
         * -- Create Student --
         * "Want to add another student?[...]
         * Options: "Y" or "N"
         * IF Y => Go to Step 3
         * IF N => Continue
         *
         *
         */
        System.out.println("Por favor, registre algunos estudiantes \n");
        while (true) {
            System.out.println("Ingrese el nombre del estudiante: ");
            String studentName = scanner.nextLine();
            System.out.println("Ingrese el nivel de habilidad del estudiante: " +
                    "1. BASICO, 2. INTERMEDIO, 3. AVANZADO");
            int IntLevel = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            SkillLevel level;
            switch (IntLevel) {
                case 1:
                    level = SkillLevel.BASICO;
                    break;
                case 2:
                    level = SkillLevel.INTERMEDIO;
                    break;
                case 3:
                    level = SkillLevel.AVANZADO;
                    break;
                default:
                    System.out.println("Nivel no válido");
                    continue;
            }
            System.out.println("Ingrese la edad del estudiante: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            // Validate age
            if (age < 0) {
                System.out.println("Edad no válida");
                continue; //TODO: SET THIS IN CLASS AND THROW EXCEPTION
            }


            Student student = new Student(studentName, level, age);
            manager.registerStudent(student);
            System.out.println("Registro exitoso del estudiante: " + student.getFullName() + "\n");
            System.out.println("¿Desea agregar otro estudiante? (Y/N)");
            String continueOption = scanner.nextLine().toUpperCase();
            if (!continueOption.equals("Y")) {
                System.out.println("Registro de estudiantes finalizado \n");
                break;
            } else {
                System.out.println("Continuando con el registro de estudiantes \n");

            }
        }
            //Step 4 =>
            /* "Now we have spells and students, let's start the journey[...]"
             * -- Menú ["View students base", "View spells base", "Start a learning Session"]
             * -- Scanner --
             * -- Validate Input --
             * IF input is not valid => Exception and ask again
             * -- If "View students base" => Show all students
             * -- If "View spells base" => Show all spells
             * -- If "Start a learning Session" => Go to Step 5
             *
             */
            System.out.println("Ahora tenemos hechizos y estudiantes, comencemos la aventura \n");
            while(true){
                System.out.println("Menú: ");
                System.out.println("1. Ver base de estudiantes");
                System.out.println("2. Ver base de hechizos");
                System.out.println("3. Iniciar sesión de aprendizaje");
                System.out.println("4. Salir");
                System.out.println("Seleccioanr opción: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        System.out.println("Lista de estudiantes: ");
                        manager.getStudents().forEach(student -> System.out.println(student.getFullName()));
                        System.out.println("Estudiantes registrados: ");
                        break;
                    case 2:
                        System.out.println("Lista de hechizos: ");
                        manager.getSpells().forEach(spell -> System.out.println(spell.toString()));
                        break;
                    case 3:
                        LearningSession session = new LearningSession(manager, scanner);
                        session.start();
                        break;
                    case 4:
                        System.out.println("ADIOS NO VUELVAS...");
                        scanner.close();
                        return; // Exit the program
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                        continue;
                }
            }

            //Step 5 =>
            /*
             * WHEN OPTION IT'S 3
             * "Please select a student[...]"
             * -- Show all students
             * -- Scanner --
             * -- Validate Input --
             * IF input is not valid => Exception and ask again
             * IF student id is not valid =>  Exception and ask again
             * -- Show student info (to see spells and skillLevel)
             * -- Show spells
             * -- Scanner --
             * -- Validate Input --
             * IF input is not valid => Exception and ask again
             * IF spell id is not valid => Exception and ask again
             * -- Show spell info (to see spellName and skillLevel)
             * -- Validate student's skillLevel
             * IF student skillLevel is lower than spell skillLevel => Exception and go to Step 4
             * -- Validate if student already tried to learne the spell
             * IF student already tried to learn the spell => Exception and go to Step 4
             * -- Add spell to student spellsLearned
             * "Start a new learning session?[...]
             * Options: "Y" or "N"
             * -- Scanner --
             * -- Validate Input --
             * IF input is not valid => Exception and ask again
             * IF "Y" => Go to Step 5
             * IF "N" => Go to Step 4 (Menú)
             *
             */



    }
}