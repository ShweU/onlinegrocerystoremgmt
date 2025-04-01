package com.crio.onlinegrocerystore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// This entity will define the table for Grocery Item in the MySQL database

@Entity
@Data
@Table(name = "grocery_items")
public class GroceryItem {
    
    //  Name, Category, Price, Quantity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groceryId;

    @Column(name = "grocery_item_name")
    private String groceryItemName;

    private String category;

    private double groceryItemPrice;

    private double quantity;
}
