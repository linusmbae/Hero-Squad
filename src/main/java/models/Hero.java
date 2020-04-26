package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {
    private static ArrayList<Hero> instances = new ArrayList<>();
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
        instances.add(this);
        this.id = instances.size();
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

    public static ArrayList<Hero> getAll() {
        return instances;
    }

    public static void clearAllHeroes(){
        instances.clear();
    }

    public static Hero findById(int id){
        return instances.get(id-1);
    }

    public void update(String name, int age, String specialPowers, String weakness) {
        this.name = name;
        this.age=age;
        this.specialPowers=specialPowers;
        this.weakness=weakness;
    }

    public void deleteHero(){
        instances.remove(id-1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialPowers() {
        return specialPowers;
    }

    public void setSpecialPowers(String specialPowers) {
        this.specialPowers = specialPowers;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
