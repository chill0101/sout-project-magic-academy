package utils;

import academy.SkillLevel;

import java.util.InputMismatchException;
import java.util.Scanner;


// This class contains utility methods for input validation and user interaction for make Main class cleaner
public class InputUtils {

    public static String elementInputOptions(Scanner scanner, String consoleMessage) {
    // This method displays a menu of elements and returns the selected element as a string.
        System.out.println(consoleMessage);
        System.out.println(
                "1. FUEGO       \uD83D\uDD25 \n" +
                "2. AGUA        \uD83D\uDCA7 \n" +
                "3. TIERRA      ⛰\uFE0F \n" +
                "4. AIRE        \uD83C\uDF43 \n"
        );
        // then it waits for the user to input a number corresponding to the element they want to select
        while ( true ) { // infinite loop until a valid input is received
            try {
                int intElement = scanner.nextInt();
                scanner.nextLine();
                switch (intElement) {
                    case 1:
                        return "Fuego";
                    case 2:
                        return "Agua";
                    case 3:
                        return "Tierra ";
                    case 4:
                        return "Aire";
                    default:
                        System.out.println("Por favor, ingrese un elemento válido (1, 2, 3 o 4):");
                }
            } catch ( InputMismatchException e ) {
                System.out.println("Por favor, ingrese un número válido para el elemento.");
                scanner.nextLine();
            }
        }

    }

    public static SkillLevel skillLevelInputOptions(Scanner scanner, String consoleMessage) {
    // This method displays a menu of skill levels and returns the selected level as a SkillLevel enum
        System.out.println(consoleMessage);
        System.out.println(
                "1. BASICO          \uD83D\uDC80 \n" +
                "2. INTERMEDIO      \uD83D\uDC80 \uD83D\uDC80 \n" +
                "3. AVANZADO        \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \n"
        );

        while(true) {
           try{
               int intLevel = scanner.nextInt();
               scanner.nextLine();
               switch (intLevel) {
                   case 1:
                       return SkillLevel.BASICO;
                   case 2:
                       return SkillLevel.INTERMEDIO;
                   case 3:
                       return SkillLevel.AVANZADO;
                   default:
                       System.out.println("Por favor, ingrese un nivel válido (1, 2 o 3):");
               }
           } catch ( InputMismatchException e ) {
               System.out.println("Por favor, ingrese un número válido para el nivel de habilidad.");
               scanner.nextLine();
           }

        }

    }



    public static int validateAgeInput(Scanner scanner, String consoleMessage) {
        // This method validates the age input with a range of 12 to 120 years
        System.out.println(consoleMessage);
        while (true) {
            try {
                int age = scanner.nextInt();
                scanner.nextLine();
                if (age >= 12 && age <= 120) {
                    return age;
                } else {
                    System.out.println("Por favor, ingrese una edad válida (entre 12 y 120 años):");
                }
            } catch ( InputMismatchException e ) {
                System.out.println("Por favor, ingrese un número válido para la edad.");
                scanner.nextLine();

            }
        }
    }

    public static String rejectNullInput(Scanner scanner, String consoleMessage) {
    // This method rejects null or empty inputs and returns the input string
        System.out.println(consoleMessage);
        while ( true ) {
            String input = scanner.nextLine().trim();

            if ( !input.isEmpty() ) {
                return input;
            } else {
                System.out.println("Por favor, ingrese un valor y no presione enter directamente. POR FAVOR D:");
            }

        }

    }





}
