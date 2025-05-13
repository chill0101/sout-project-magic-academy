package academy;

import exceptions.AlreadyTriedToLearn;
import exceptions.InsuffitientRequiredSkillLevel;
import exceptions.DuplicateSpellException;
import users.Student;

import java.util.ArrayList;
import java.util.List;

public class AcademyManager implements Learnable{
    private List<Spell> spells = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public void registerSpell( Spell spell ) {
        //TODO: VALIDAR DUPLICADOS
        for ( Spell sp : spells ) {
            if ( sp.getName().equalsIgnoreCase( spell.getName()) ) {
                throw new DuplicateSpellException( spell.getName());
            }
        }

        spells.add(spell);
        System.out.println("Hechizo " + spell.getName() + " registrado.");
    }

    public void registerStudent( Student student) {
        //TODO: VALIDAR DUPLICADOS
        for ( Student st : students ) {
            if ( st.getFullName().equalsIgnoreCase( student.getFullName()) ) {
                throw new DuplicateSpellException( student.getFullName() );
            }
        }

        students.add(student);
        System.out.println("Estudiante " + student.getFullName() + " registrado.");
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public List<Student> getStudents() {
        return students;
    }


    @Override
    public void learn(Student student, Spell spell, SkillLevel skillLevel)
            throws InsuffitientRequiredSkillLevel, AlreadyTriedToLearn      {
        for ( Spell learnedSpell : student.getSpellsLearned() ) { //
            if ( learnedSpell.getName().equalsIgnoreCase( spell.getName() )) {
                throw new AlreadyTriedToLearn( spell.getName() );
            }
        }

        if ( skillLevel.ordinal() < spell.getLevel().ordinal() ) {
            throw new InsuffitientRequiredSkillLevel("Errorcito de skillLevel");
        }

        student.getSpellsLearned().add( spell );
        System.out.println("Estudiante " + student.getFullName() + " ha aprendido el hechizo " + spell.getName() + ".");
    }
}
