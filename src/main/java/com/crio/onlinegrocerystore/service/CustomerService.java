package com.crio.onlinegrocerystore.service;

import java.util.List;

import com.crio.onlinegrocerystore.entity.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    List<Customer> getAllCustomers();
    void deleteCustomer(Long id);
    Customer getCustomerById(Long id);
}
