package models;

import java.util.Objects;

public class Hero {
    private String name;
    private int age;
    private String specialPowers;
    private String weakness;
    private int id;

    public Hero(String name, int age, String specialPowers, String weakness, int id) {
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weakness = weakness;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age &&
                id == hero.id &&
                Objects.equals(name, hero.name) &&
                Objects.equals(specialPowers, hero.specialPowers) &&
                Objects.equals(weakness, hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, specialPowers, weakness, id);
    }
}
