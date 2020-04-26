package models;

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

}
