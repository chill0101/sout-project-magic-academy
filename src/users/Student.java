package users;

import academy.AcademyManager;
import academy.SkillLevel;
import academy.Spell;
import exceptions.AlreadyTriedToLearn;
import exceptions.InsuffitientRequiredSkillLevel;

public class Student extends Person {

    public Student(String fullName, SkillLevel skillLevel) {
        super(fullName, skillLevel);
    }

    public void learnSpell(AcademyManager manager, Spell spell) {
        try {
            manager.learn(this, spell, getSkillLevel());
            System.out.println("LEARNED");
        } catch (InsuffitientRequiredSkillLevel | AlreadyTriedToLearn e){
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR UNEXPECTED: " + e.getMessage());
        }
    }



}
