package com.crio.onlinegrocerystore.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crio.onlinegrocerystore.entity.GroceryItem;
import com.crio.onlinegrocerystore.repository.GroceryItemRepository;
import com.crio.onlinegrocerystore.service.GroceryItemService;

// Business logic for Grocery Item
@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    // create Grocery Item
    @Override
    public GroceryItem createGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    // Get all the Grocery Items
    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    // Get grocery item by id
    @Override
    public GroceryItem getGroceryItemById(Long id) {
        return groceryItemRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grocery Item not found" + id));
    }

    // update a grocery item with of the given id
    @Override
    public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem) {
        // check if the grocery item id exists or not
        GroceryItem groceryItemDetails = getGroceryItemById(id);
        // update fields
        groceryItemDetails.setGroceryItemName(groceryItem.getGroceryItemName());
        groceryItemDetails.setGroceryItemPrice(groceryItem.getGroceryItemPrice());
        groceryItemDetails.setQuantity(groceryItem.getQuantity());
        groceryItemDetails.setCategory(groceryItem.getCategory());
        return groceryItemRepository.save(groceryItemDetails);
    }

    // delete a grocery item
    @Override
    public void deleteGroceryItem(Long id) {
        GroceryItem groceryItemToBeDeleted = getGroceryItemById(id);
        groceryItemRepository.delete(groceryItemToBeDeleted);
    }
  
    
}
