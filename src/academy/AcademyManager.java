package academy;

import exceptions.AlreadyTriedToLearn;
import exceptions.InsuffitientRequiredSkillLevel;
import users.Student;

import java.util.ArrayList;
import java.util.List;

public class AcademyManager implements Learnable{
    private List<Spell> spells = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public void registerSpell(Spell spell) {
        //TODO: VALIDAR DUPLICADOS
        spells.add(spell);
        System.out.println("Hechizo " + spell.getName() + " registrado.");
    }

    public void registerStudent( Student student) {
        //TODO: VALIDAR DUPLICADOS
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
    public void learn(Student student, Spell spell, SkillLevel skillLevel) throws InsuffitientRequiredSkillLevel, AlreadyTriedToLearn {
        System.out.println("hola");
    }
}
