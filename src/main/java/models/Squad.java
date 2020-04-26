package models;

import java.util.ArrayList;

public class Squad {
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;
    private int maxSize;
    private String name;
    private String cause;

    public Squad(int id, int maxSize, String name, String cause) {
        this.id = id;
        this.maxSize = maxSize;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
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
}
