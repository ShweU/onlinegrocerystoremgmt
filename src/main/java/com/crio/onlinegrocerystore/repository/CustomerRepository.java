package com.crio.onlinegrocerystore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.onlinegrocerystore.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    List<Customer> findByEmailId(String emailId);
    
}
