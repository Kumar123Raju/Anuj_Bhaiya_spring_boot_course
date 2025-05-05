package com.example.RestClient.RestClient.Services;

import java.util.List;
import java.util.Optional;

public abstract class CustomerService<T> {

    public abstract List<T> getAllCustomers();

    public abstract Optional<T> getCustomerById(Long id);

    public abstract T saveCustomer(T customer);


}