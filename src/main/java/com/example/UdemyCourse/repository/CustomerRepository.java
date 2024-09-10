package com.example.UdemyCourse.repository;

import com.example.UdemyCourse.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> findCustomerByEmailIgnoreCase(String email);
}