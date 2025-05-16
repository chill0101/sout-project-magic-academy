package users;

import academy.SkillLevel;
import academy.Spell;

import java.util.ArrayList;

public abstract class Person {
    private String fullName;
    private SkillLevel skillLevel;
    private ArrayList<Spell> spellsLearned;

    public Person(String fullName, SkillLevel skillLevel) {
        this.fullName = fullName;
        this.skillLevel = skillLevel;
        this.spellsLearned = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) { // currently not used
        this.fullName = fullName;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) { // currently not used
        this.skillLevel = skillLevel;
    }

    public ArrayList<Spell> getSpellsLearned() {
        return spellsLearned;
    }

    public void setSpellsLearned(ArrayList<Spell> spellsLearned) { // currently not used
        this.spellsLearned = spellsLearned;
    }

    // Person class is abstract, so it cannot be instantiated directly


}
