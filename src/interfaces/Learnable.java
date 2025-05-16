package interfaces;
import academy.SkillLevel;
import academy.Spell;
import exceptions.AlreadyTriedToLearn;
import exceptions.InsuffitientRequiredSkillLevel;
import users.Student;



public interface Learnable {
    void learn(Student student, Spell spell, SkillLevel skillLevel)
        throws InsuffitientRequiredSkillLevel, AlreadyTriedToLearn; // Method to learn a spell
}
