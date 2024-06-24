package com.example.kk;

public class Product {

    private static long nextId = 1;

    private Long id;
    private String name;
    private String description;

    public Product(String name, String description) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Other methods as needed
}
