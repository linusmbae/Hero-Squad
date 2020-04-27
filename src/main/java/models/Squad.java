package models;

import java.util.ArrayList;
import java.util.Objects;

public class Squad {
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;
    private String name;
    private String cause;

    public Squad( String name, String cause) {

        this.name = name;
        this.cause = cause;
        instances.add(this);
        this.id = instances.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return id == squad.id &&
                Objects.equals(name, squad.name) &&
                Objects.equals(cause, squad.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cause);
    }

    public static ArrayList<Squad> getAll() {
        return instances;
    }

    public static void setAll(ArrayList<Squad> instances) {
        Squad.instances = instances;
    }

    public static void clearEntireSquad(){
        instances.clear();
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }

    public  void deleteSquad() {
        instances.remove(id-1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void update(String name, String cause) {
        this.name=name;
        this.cause=cause;
    }
}
