package com.example.UdemyCourse.controller;

import com.example.UdemyCourse.model.Customer;
import com.example.UdemyCourse.repository.CustomerRepository;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        String hashPwd = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(hashPwd);
        customer.setCreateAt(LocalDateTime.now());

        return saveCustomer(customer)
                .map(saveCustomer -> ResponseEntity
                        .status(CREATED)
                        .body("Customer register successfully"))
                .getOrElseGet(exception -> ResponseEntity
                        .status(BAD_REQUEST)
                        .body("Internal server error: " + exception.getMessage()));
    }

    @GetMapping("/username")
    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/username2")
    public String getUsername2(Authentication authentication) {
        return authentication.getName();
    }

    //endpoint will be call from login page
    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        return customerRepository.findCustomerByEmailIgnoreCase(authentication.getName()).orElse(null);
    }

    private Either<Exception, Customer> saveCustomer(Customer customer) {
        try {
            Customer savedCustomer = customerRepository.save(customer);
            return Either.right(savedCustomer);
        } catch (Exception exception) {
            return Either.left(exception);
        }
    }
}