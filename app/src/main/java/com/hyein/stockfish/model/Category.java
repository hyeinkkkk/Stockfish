package com.hyein.stockfish.model;

/**
 * Created by nolgong-hyein on 2016. 12. 22..
 */

public class Category {
    String name;
    int id;

    public Category(int id, String name){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "name is "+ name + ". id is "+id;
    }
}
