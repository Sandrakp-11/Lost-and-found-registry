package com.lostfound.dto;

public class Item {

    private int id;
    private String itemName;
    private String description;
    private String location;
    private String status;

    // Default constructor
    public Item() {}

    // Constructor without id (for insert)
    public Item(String itemName, String description, String location, String status) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    // Constructor with id
    public Item(int id, String itemName, String description, String location, String status) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

