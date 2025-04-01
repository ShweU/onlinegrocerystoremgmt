package com.crio.onlinegrocerystore.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crio.onlinegrocerystore.dto.OrderRequest;
import com.crio.onlinegrocerystore.entity.Customer;
import com.crio.onlinegrocerystore.entity.GroceryItem;
import com.crio.onlinegrocerystore.entity.Order;
import com.crio.onlinegrocerystore.repository.CustomerRepository;
import com.crio.onlinegrocerystore.repository.GroceryItemRepository;
import com.crio.onlinegrocerystore.repository.OrderRepository;
import com.crio.onlinegrocerystore.service.OrderService;

import jakarta.transaction.Transactional;

// Business logic for Order Service
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    // create order
    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Customer customer = customerRepository.findById(orderRequest.getCustomerId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID not found" + orderRequest.getCustomerId()));
        List<GroceryItem> groceryItems = groceryItemRepository.findAllById(orderRequest.getGroceryItemIds());

        // Calculate total price
        double totalPrice = groceryItems.stream()
            .mapToDouble(item -> item.getGroceryItemPrice() * item.getQuantity()).sum();

        Order newOrder = new Order();
        newOrder.setCustomer(customer);
        newOrder.setGroceryItem(groceryItems);
        newOrder.setTotalPrice(totalPrice);
        newOrder.setOrderDate(LocalDateTime.now());
        return orderRepository.save(newOrder);
    }

    // get all orders
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // get order by id
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order ID not found" + id));
    }

    // update order
    @Override
    public Order updateOrder(Long orderId, OrderRequest orderRequest) {
         // check if the id exists
         Order orderToBeUpdated = getOrderById(orderId);
         List<GroceryItem> groceryItems = groceryItemRepository.findAllById(orderRequest.getGroceryItemIds());

        if (groceryItems.isEmpty()) {
            throw new RuntimeException("No valid grocery items found for the provided IDs.");
        }
         // update order
        orderToBeUpdated.setGroceryItem(groceryItems);

        // recalculate price
        double newTotalPrice = groceryItems.stream()
            .mapToDouble(GroceryItem::getGroceryItemPrice).sum();
        orderToBeUpdated.setTotalPrice(newTotalPrice);

        return orderRepository.save(orderToBeUpdated);

    }

    // delete order
    @Override
    public void deleteOrder(Long id) {
        Order orderToBeDeleted = getOrderById(id);
        orderRepository.delete(orderToBeDeleted);
    }

    
    
}
