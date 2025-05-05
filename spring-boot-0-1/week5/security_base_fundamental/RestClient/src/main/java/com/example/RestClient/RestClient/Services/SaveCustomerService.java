package com.example.RestClient.RestClient.Services;

import com.example.RestClient.RestClient.Model.Customer;
import com.example.RestClient.RestClient.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("saveCustomerService")
public class SaveCustomerService extends CustomerService<Customer> {

    @Autowired
    private CustomerRepo customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        throw new UnsupportedOperationException("Fetching all customers is not supported by this service. Use AllCustomerDetailsService.");
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        throw new UnsupportedOperationException("Fetching customer by ID is not supported by this service. Use AllCustomerDetailsService.");
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
