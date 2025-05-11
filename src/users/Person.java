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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public ArrayList<Spell> getSpellsLearned() {
        return spellsLearned;
    }

    public void setSpellsLearned(ArrayList<Spell> spellsLearned) {
        this.spellsLearned = spellsLearned;
    }



}
