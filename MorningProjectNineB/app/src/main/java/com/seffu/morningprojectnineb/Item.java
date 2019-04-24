package com.seffu.morningprojectnineb;

public class Item {
    private String name,number;
    private int image;

    public Item(String name, String number, int image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImage() {
        return image;
    }
}
