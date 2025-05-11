public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenido perro!");

        //Step 1 =>
        /*
        * "Welcome to the SOUT Academy[...]
        * "Please register the director[...] => Use the singleton
        * -- Scanner --
        * -- Validate Input --
        * IF input is not valid => Exception
        * -- Create Director --
        * IF Director is already registered => Message and continue
        */




        //Step 2 =>
        /*
         * "Please register some spells[...]
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

        //Step 3 =>
        /*
        * "Please register some students[...]
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


        //Step 4 =>
        /* "Now we have spells and students, let's start the journey[...]
        * -- Menú ["View students base", "View spells base", "Start a learning Session"]
        * -- Scanner --
        * -- Validate Input --
        * IF input is not valid => Exception and ask again
        * -- If "View students base" => Show all students
        * -- If "View spells base" => Show all spells
        * -- If "Start a learning Session" => Go to Step 5
        *
         */

        //Step 5 =>
        /*
        * "Please select a student[...]
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