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

import com.crio.onlinegrocerystore.dto.OrderRequest;
import com.crio.onlinegrocerystore.entity.Order;
import com.crio.onlinegrocerystore.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    // get all the orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // get order by id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable ("id") Long id){
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    // create a new order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest newOrderRequest){
        Order saveOrder = orderService.createOrder(newOrderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveOrder);
    }

    // update an order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable ("id") Long id, @RequestBody OrderRequest orderRequest){
        Order updatedOrder = orderService.updateOrder(id, orderRequest);
        return ResponseEntity.ok(updatedOrder);
    }

    // delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable ("id") Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
