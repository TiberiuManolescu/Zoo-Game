package com.zoogame.models;

public abstract class Animal {
    private String name;
    private String image;

    public Animal(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    // Implement any additional methods or properties specific to animals
}
