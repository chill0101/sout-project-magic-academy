package users;

import academy.AcademyManager;
import academy.SkillLevel;
import academy.Spell;
import exceptions.AlreadyTriedToLearn;
import exceptions.InsuffitientRequiredSkillLevel;

public class Student extends Person {

    private int age;

    public Student(String fullName, SkillLevel skillLevel, int age) {
        super(fullName, skillLevel);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
