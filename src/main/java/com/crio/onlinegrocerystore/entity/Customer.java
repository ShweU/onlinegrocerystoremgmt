package com.crio.onlinegrocerystore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This entity will define the table for customer in the MySQL database

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    
    // Name, Email, Address, Phone, Id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment primary key
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    private String emailId;

    private String address;

    private long phoneNumber;

}
