package com.crio.onlinegrocerystore.service;

import java.util.List;

import com.crio.onlinegrocerystore.dto.OrderRequest;
import com.crio.onlinegrocerystore.entity.Order;

public interface OrderService {
  
    Order createOrder(OrderRequest orderRequest);
    Order updateOrder(Long id, OrderRequest orderRequest);
    void deleteOrder(Long id);
    List<Order> getAllOrders();
    Order getOrderById(Long id);

}
