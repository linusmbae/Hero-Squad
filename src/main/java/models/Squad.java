package models;

import java.util.ArrayList;

public class Squad {
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;
    private String name;
    private String cause;

    public Squad(int id, String name, String cause) {
        this.id = id;
        this.name = name;
        this.cause = cause;
        instances.add(this);
        this.id = instances.size();
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
