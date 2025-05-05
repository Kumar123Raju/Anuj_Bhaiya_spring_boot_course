package com.example.RestClient.RestClient.Repository;

import com.example.RestClient.RestClient.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
