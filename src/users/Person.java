package users;

import java.util.ArrayList;

public class Person {
    private String fullName;
    private int skillLevel;
    private ArrayList<String> spellsLearned;

    public Person(String fullName, int skillLevel) {
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

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public ArrayList<String> getSpellsLearned() {
        return spellsLearned;
    }

    public void setSpellsLearned(ArrayList<String> spellsLearned) {
        this.spellsLearned = spellsLearned;
    }
}
