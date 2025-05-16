package academy;

import exceptions.AlreadyTriedToLearn;
import exceptions.DuplicateStudentException;
import exceptions.InsuffitientRequiredSkillLevel;
import exceptions.DuplicateSpellException;
import interfaces.Learnable;
import users.Director;
import users.Student;


import java.util.ArrayList;
import java.util.List;

public class AcademyManager implements Learnable {
    private List<Spell> spells = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private Director director;

    public AcademyManager(Director director) {
        this.director = director; // Initialize the director
    }

    public void registerSpell( Spell spell ) {

        for ( Spell sp : spells ) {
            if ( sp.getName().equalsIgnoreCase( spell.getName()) ) { // Check if the spell already exists using equalsIgnoreCase
                throw new DuplicateSpellException( spell.getName()); // Custom exception to handle duplicate spells
            }
        }

        spells.add( spell ); // Add the spell to the list of spells

        if (director.getSkillLevel().ordinal() < spell.getLevel().ordinal()) {
            throw new InsuffitientRequiredSkillLevel("El Director no tiene el nivel necesario para aprender este hechizo."); // Custom exception to be thrown if the director doesn't have the required skill level but that doesn't happen
        } director.getSpellsLearned().add(spell);

        System.out.println(">>>>>>>>>>> Hechizo " + spell.getName() + " registrado. El Director ahora sabe este hechizo.");

    }

    public void registerStudent( Student student) {

        for ( Student st : students ) {
            if ( st.getFullName().equalsIgnoreCase( student.getFullName()) ) { // Check if the student already exists using equalsIgnoreCase
                throw new DuplicateStudentException( student.getFullName() );
            }
        }

        students.add(student);
        System.out.println(">>>>>>>>>>> Estudiante " + student.getFullName() + " registrado.");
    }

    public List<Spell> getSpells() {
        return spells; // Return the list of spells for use in the learning session
    }

    public List<Student> getStudents() {
        return students; // Return the list of students for use in the learning session
    }


    @Override
    public void learn(Student student, Spell spell, SkillLevel skillLevel)
            throws InsuffitientRequiredSkillLevel, AlreadyTriedToLearn      {

        for ( Spell learnedSpell : student.getSpellsLearned() ) { // Check if the student has already learned the spell
            if ( learnedSpell.getName().equalsIgnoreCase( spell.getName() )) { // Check if the spell already exists using equalsIgnoreCase
                throw new AlreadyTriedToLearn( "El estudiante " + student.getFullName() + " ya ha aprendido " + spell.getName() );
            }
        }


        for (Spell triedSpell : student.getTriedSpells()) { // Check if the student has already tried to learn the spell - This avoids to get the required skill level if the student has already tried to learn the spell
            if (triedSpell.getName().equalsIgnoreCase(spell.getName())) {
                throw new AlreadyTriedToLearn("El estudiante " + student.getFullName() + " ya intentó aprender " + spell.getName() + " en otra sesión."); // Custom exception to handle already tried spells
            }

        }

        student.getTriedSpells().add(spell); // Add the spell to the list of tried spells before checking the skill level

        if ( skillLevel.ordinal() < spell.getLevel().ordinal() ) { // Check if the student has the required skill level - ordinal is used to compare the skill levels because SkillLevel is an enum
            throw new InsuffitientRequiredSkillLevel("Error: El estudiante no tiene el nivel necesario para aprender este hechizo."); // Custom exception to handle insufficient skill level
        }

        student.getSpellsLearned().add( spell );  // Add the spell to the list of learned spells
        System.out.println();
        System.out.println();
        System.out.println(
                ">>>>>>>>>> Estudiante " + student.getFullName() + " ha aprendido el hechizo " + spell.getName() + " con éxito. \n"+
                "El director" + director.getFullName() + " lo felicita. " + Math.round(Math.random()*10) + " puntos para su casa si es que tiene 🧙‍♂️"
        ); // Final message
    }
}
