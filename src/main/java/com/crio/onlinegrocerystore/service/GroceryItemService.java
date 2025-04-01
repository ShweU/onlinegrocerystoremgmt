package com.crio.onlinegrocerystore.service;

import java.util.List;

import com.crio.onlinegrocerystore.entity.GroceryItem;

public interface GroceryItemService {
    GroceryItem createGroceryItem(GroceryItem groceryItem);
    GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem);
    void deleteGroceryItem(Long id);
    List<GroceryItem> getAllGroceryItems();
    GroceryItem getGroceryItemById(Long id);

}
