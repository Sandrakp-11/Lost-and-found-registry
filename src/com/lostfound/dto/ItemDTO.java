package com.lostfound.dto;

import java.sql.Date;

public class ItemDTO {

    private int itemId;
    private String itemName;
    private String description;
    private String category;
    private String status;
    private String location;
    private Date dateReported;

    // Getters and Setters
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Date getDateReported() { return dateReported; }
    public void setDateReported(Date dateReported) { this.dateReported = dateReported; }
}
