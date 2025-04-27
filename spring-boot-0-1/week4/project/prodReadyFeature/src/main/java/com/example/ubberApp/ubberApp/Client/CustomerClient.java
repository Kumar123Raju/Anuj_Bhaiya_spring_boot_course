package com.example.ubberApp.ubberApp.Client;

import com.example.ubberApp.ubberApp.dto.CustomerDto;

import java.util.List;

public interface CustomerClient {

    List<CustomerDto> getCustomer();

    CustomerDto getCustomerById(Long id);

    CustomerDto saveCustomer(CustomerDto customerDto);


}
