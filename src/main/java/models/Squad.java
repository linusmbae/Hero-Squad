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
    }


}
