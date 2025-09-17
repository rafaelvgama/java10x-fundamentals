package challenge4.entities;

import challenge4.enums.AbilityType;

public class AdvancedNinja extends BasicNinja {
    private String specialAbility;

    public AdvancedNinja(String nome, int idade, AbilityType habilidade, String specialAbility) {
        super(nome, idade, habilidade);
        this.specialAbility = specialAbility;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    @Override
    public void performAbility() {
        System.out.printf("%s executou a habilidade %s com a especialidade %s.\n\n",
                this.name, this.ability, this.specialAbility);
    }

    @Override
    public String toString() {
        return "AdvancedNinja{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", ability = " + ability +
                ", special ability = " + ability +
                '}';
    }
}
