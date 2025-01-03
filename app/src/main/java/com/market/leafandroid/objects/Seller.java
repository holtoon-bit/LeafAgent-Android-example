package com.market.leafandroid.objects;

public class Seller {
    private int id;
    private String name;
    private String image;

    public Seller(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Seller(int id, String name, String imagePath) {
        this.id = id;
        this.name = name;
        this.image = imagePath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}