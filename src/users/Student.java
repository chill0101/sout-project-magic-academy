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
