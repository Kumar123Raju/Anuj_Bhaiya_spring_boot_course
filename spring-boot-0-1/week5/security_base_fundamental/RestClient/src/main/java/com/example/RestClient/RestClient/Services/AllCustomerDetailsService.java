package com.example.RestClient.RestClient.Services;


import com.example.RestClient.RestClient.Model.Customer;
import com.example.RestClient.RestClient.Repository.CustomerRepo;
import com.example.RestClient.RestClient.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("allCustomerDetailsService")
public class AllCustomerDetailsService extends CustomerService<Customer> {

    @Autowired
    private CustomerRepo customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        throw new UnsupportedOperationException("Saving customers is not supported by this service. Use SaveCustomerService.");
    }
}