package com.crio.onlinegrocerystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.onlinegrocerystore.entity.GroceryItem;
import com.crio.onlinegrocerystore.service.GroceryItemService;

@RestController
@RequestMapping("/api/v1/groceryitems")
public class GroceryItemController {
    
    @Autowired
    private GroceryItemService groceryItemService;

    // Get all grocery items
    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems(){
        return ResponseEntity.ok(groceryItemService.getAllGroceryItems());
    }

    // get a grocery item by id
    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable ("id") Long Id){
        GroceryItem groceryItem = groceryItemService.getGroceryItemById(Id);
        return ResponseEntity.ok(groceryItem);
    }

    // create a new grocery item
    @PostMapping
    public ResponseEntity<GroceryItem> createGroceryItem(@RequestBody GroceryItem groceryItem){
        GroceryItem newGroceryItem = groceryItemService.createGroceryItem(groceryItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGroceryItem);
    }

    // update a grocery item
    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable ("id") Long id, @RequestBody GroceryItem groceryItem){
        GroceryItem updateGroceryItem = groceryItemService.updateGroceryItem(id, groceryItem);
        return ResponseEntity.ok(updateGroceryItem);
    }

    // delete a grocery item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable ("id") Long id){
        groceryItemService.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }

}
