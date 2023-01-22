package com.learningspring.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDao {

    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer customer1 = new Customer(1, "Alex", "alex@gmail.com", 21);
        customers.add(customer1);
        Customer customer2 = new Customer(2, "Frank", "frank@gmail.com", 45);
        customers.add(customer2);
        Customer customer3 = new Customer(3, "Emily", "emily@outlook.com", 29);
        customers.add(customer3);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer customerId) {
        return customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst();
    }
}
