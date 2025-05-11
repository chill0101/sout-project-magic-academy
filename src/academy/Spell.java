package academy;

public class Spell {
    private String name;
    private String element;
    private SkillLevel level;

    public Spell(String name, String element, SkillLevel level) {
        this.name = name;
        this.element = element;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "Nombre: " + name + '\'' +
                ", Elemento: " + element + '\'' +
                ", Nivel Requerido: " + level +
                '}';
    }
}
