package interfaces;
import academy.SkillLevel;
import academy.Spell;
import exceptions.AlreadyTriedToLearn;
import exceptions.InsuffitientRequiredSkillLevel;
import users.Student;


// Simple interface to define the contract for learning spells
public interface Learnable {
    void learn(Student student, Spell spell, SkillLevel skillLevel)
        throws InsuffitientRequiredSkillLevel, AlreadyTriedToLearn; // Method to learn a spell
}
