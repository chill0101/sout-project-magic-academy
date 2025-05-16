/**
 * Student class representing a student in the academy.
 * This class extends the Person class and contains additional attributes and methods specific to students.
 * It includes the student's age and a list of spells they have tried to learn and already learned.
 * Also the SkillLevel that is required to learn Spells.
 *
 */

package users;


import academy.SkillLevel;
import academy.Spell;

import java.util.List;
import java.util.ArrayList;

public class Student extends Person {

    private int age;
    private List<Spell> triedSpells;

    public Student(String fullName, SkillLevel skillLevel, int age) {
        super(fullName, skillLevel);
        this.age = age;
        this.triedSpells = new ArrayList<>();

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { // currently not used
        this.age = age;
    }

    public List<Spell> getTriedSpells() {
        return triedSpells;
    }

    @Override
    public String toString() {
        return "| Nombre: " + getFullName() + " | Edad: " + age + " | Nivel: " + getSkillLevel() + " | Hechizos Aprendidos: " + getSpellsLearned();
    }

}
