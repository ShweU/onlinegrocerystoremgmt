package com.crio.onlinegrocerystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.onlinegrocerystore.entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
    
}
