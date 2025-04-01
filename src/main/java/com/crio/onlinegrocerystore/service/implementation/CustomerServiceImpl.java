package com.crio.onlinegrocerystore.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crio.onlinegrocerystore.entity.Customer;
import com.crio.onlinegrocerystore.repository.CustomerRepository;
import com.crio.onlinegrocerystore.service.CustomerService;

// the business logic for customer
@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    // create customer
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // get all customers
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // get customer by id
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Customer ID not found" + id));
    }

    // update customer
    @Override
    public Customer updateCustomer(Long id, Customer customerDetails) {
        // check if the given customer id exists or not
        Customer existingCustomer = getCustomerById(id);
        
        // update fields
        existingCustomer.setCustomerName(customerDetails.getCustomerName());
        existingCustomer.setEmailId(customerDetails.getEmailId());
        existingCustomer.setAddress(customerDetails.getAddress());
        existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        return customerRepository.save(existingCustomer);
    }

    // delete customer
    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }

    
    
}
