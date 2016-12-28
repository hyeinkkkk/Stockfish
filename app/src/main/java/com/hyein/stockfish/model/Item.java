package com.hyein.stockfish.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nolgong-hyein on 2016. 12. 23..
 */

public class Item {
    String name;

    @SerializedName("file_name")
    String fileName;
    int id;

    public Item(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
